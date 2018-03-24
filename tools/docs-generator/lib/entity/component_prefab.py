import xml.etree.ElementTree as EXml

from lib.graphics.effect_prefab import EffectPrefabXmlReader
from lib.utility.surface.position.position_prefab import PositionPrefab, PositionPrefabXmlReader


class ComponentPrefab(object):
    pass


class ComponentPrefabXmlReader(object):
    COMPONENT_ELEMENT = "component"
    COMPONENTS_ELEMENT = "components"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefabs = []

            for child in element.findall(self.COMPONENT_ELEMENT):
                prefabs.append(self.read_prefab_from_string(EXml.tostring(child)))

            return prefabs
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE)

            if prefab_type not in self.sub_readers:
                raise ComponentPrefabXmlReaderNotFoundException(prefab_type)
            
            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)


class SubComponentPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class ComponentPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read component prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class ComponentPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Component prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))


class SpeedComponentPrefab(ComponentPrefab):
    def __init__(self, speed):
        self.speed = float(speed)

    def get_speed(self):
        return self.speed

    def __str__(self):
        return "SpeedComponentPrefab(speed={})".format(self.speed)


class SubSpeedComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    SPEED_ELEMENT = "speed"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            speed = float(element.find(self.SPEED_ELEMENT).text)
            return SpeedComponentPrefab(speed)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "SpeedComponent"


class CameraTrackComponentPrefab(ComponentPrefab):
    def __init__(self, priority, position_prefab):
        self.priority = priority
        self.position_prefab = position_prefab

    def get_priority(self):
        return self.priority

    def get_position_prefab(self):
        return self.position_prefab

    def __str__(self):
        return "CameraTrackComponent(priority={}, position_prefab={})"\
            .format(self.priority, str(self.position_prefab))


class SubCameraTrackComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    PRIORITY_ELEMENT = "priority"

    def __init__(self, position_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            priority = float(element.find(self.PRIORITY_ELEMENT).text)

            if (element.find(PositionPrefabXmlReader.POSITION_ELEMENT)) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            return CameraTrackComponentPrefab(priority, position_prefab)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "CameraTrackComponent"


class LeaveBonusComponentPrefab(ComponentPrefab):
    def __init__(self, chance_modifier):
        self.chance_modifier = float(chance_modifier)

    def get_chance_modifier(self):
        return self.chance_modifier

    def __str__(self):
        return "LeaveBonusComponentPrefab(chance_modifier={})".format(self.chance_modifier)


class SubLeaveBonusComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    CHANCE_MODIFIER_ELEMENT = "chanceModifier"
    CHANCE_MODIFIER_DEFAULT = 0

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            chance_modifier = self.CHANCE_MODIFIER_DEFAULT

            if element.find(self.CHANCE_MODIFIER_ELEMENT) is not None:
                chance_modifier = float(element.find(self.CHANCE_MODIFIER_ELEMENT).text.strip())

            return LeaveBonusComponentPrefab(chance_modifier)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "LeaveBonusComponent"


class AmmoComponentPrefab(ComponentPrefab):
    def __init__(self, current_level, max_level, prefab_codes):
        self.current_level = int(current_level)
        self.max_level = int(max_level)
        self.prefab_codes = prefab_codes

    def get_current_level(self):
        return self.current_level

    def get_max_level(self):
        return self.max_level

    def get_prefab_codes(self):
        return self.prefab_codes

    def __str__(self):
        return "AmmoComponentPrefab(current_level={}, max_level={}, prefab_codes={})" \
                .format(self.current_level, self.max_level, self.prefab_codes)


class SubAmmoComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    CURRENT_LEVEL_ELEMENT = "currentLevel"
    MAX_LEVEL_ELEMENT = "maxLevel"
    AMMO_ELEMENT = "ammo"
    BULLET_ELEMENT = "bullet"
    DIRECTION_ATTRIBUTE = "direction"
    LEVEL_ATTRIBUTE = "level"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            current_level = int(element.find(self.CURRENT_LEVEL_ELEMENT).text.strip())
            max_level = int(element.find(self.MAX_LEVEL_ELEMENT).text.strip())
            prefab_codes = {}

            for ammo_element in element.findall(self.AMMO_ELEMENT):
                bullets = {}
                for bullet_element in ammo_element.findall(self.BULLET_ELEMENT):
                    bullets[bullet_element.get(self.DIRECTION_ATTRIBUTE).strip()] = bullet_element.text.strip()
                prefab_codes[int(ammo_element.get(self.LEVEL_ATTRIBUTE).strip())] = bullets

            return AmmoComponentPrefab(current_level, max_level, prefab_codes)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AmmoComponent"


class AutoShootComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "AutoShootComponentPrefab()"


class SubAutoShootComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AutoShootComponentPrefab()

    def get_type(self):
        return "AutoShootComponent"


class DamageComponentPrefab(ComponentPrefab):
    def __init__(self, damage):
        self.damage = int(damage)

    def get_damage(self):
        return self.damage

    def __str__(self):
        return "DamageComponentPrefab(damage={})".format(self.damage)


class SubDamageComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    DAMAGE_ELEMENT = "damage"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            damage = int(element.find(self.DAMAGE_ELEMENT).text.strip())

            return DamageComponentPrefab(damage)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "DamageComponent"


class HealthComponentPrefab(ComponentPrefab):
    def __init__(self, health, max_health):
        self.health = int(health)
        self.max_health = int(max_health)

    def get_health(self):
        return self.health

    def get_max_health(self):
        return self.max_health

    def __str__(self):
        return "HealthComponentPrefab(health={}, max_health={})".format(self.health, self.max_health)


class SubHealthComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    HEALTH_ELEMENT = "health"
    MAX_HEALTH = "maxHealth"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            health = int(element.find(self.HEALTH_ELEMENT).text.strip())
            max_health = int(element.find(self.MAX_HEALTH).text.strip())

            return HealthComponentPrefab(health, max_health)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "HealthComponent"


class HitComponentPrefab(ComponentPrefab):
    def __init__(self, effect_prefab, hit_time):
        self.effect_prefab = effect_prefab
        self.hit_time = float(hit_time)

    def get_effect_prefab(self):
        return self.effect_prefab

    def get_hit_time(self):
        return self.hit_time

    def __str__(self):
        return "HitComponentPrefab(effect_prefab={}, hit_time={})" \
            .format(str(self.effect_prefab), self.hit_time)


class SubHitComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    HIT_TIME_ELEMENT = "hitTime"

    def __init__(self, effect_prefab_xml_reader):
        self.effect_prefab_xml_reader = effect_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            effect_prefab = self.effect_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(EffectPrefabXmlReader.EFFECT_ELEMENT))
            )
            hit_time = float(element.find(self.HIT_TIME_ELEMENT).text.strip())

            return HitComponentPrefab(effect_prefab, hit_time)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "HitComponent"


class ProtectionComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "ProtectionComponentPrefab()"


class SubProtectionComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ProtectionComponentPrefab()

    def get_type(self):
        return "ProtectionComponent"


class RandomShootComponentPrefab(ComponentPrefab):
    def __init__(self, min_shoot_frequency, max_shoot_frequency):
        self.min_shoot_frequency = float(min_shoot_frequency)
        self.max_shoot_frequency = float(max_shoot_frequency)

    def get_min_shoot_frequency(self):
        return self.min_shoot_frequency

    def get_max_shoot_frequency(self):
        return self.max_shoot_frequency

    def __str__(self):
        return "RandomShootComponentPrefab(min_shoot_frequency={}, max_shoot_frequency={})" \
            .format(self.min_shoot_frequency, self.max_shoot_frequency)


class SubRandomShootComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    MIN_SHOOT_FREQUENCY_ELEMENT = "minShootFrequency"
    MAX_SHOOT_FREQUENCY_ELEMENT = "maxShootFrequency"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            min = float(element.find(self.MIN_SHOOT_FREQUENCY_ELEMENT).text.strip())
            max = float(element.find(self.MAX_SHOOT_FREQUENCY_ELEMENT).text.strip())

            return RandomShootComponentPrefab(min, max)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "RandomShootComponent"


class DirectionComponentPrefab(ComponentPrefab):
    def __init__(self, direction):
        self.direction = str(direction)

    def get_direction(self):
        return self.direction

    def __str__(self):
        return "DirectionComponentPrefab(direction={})".format(self.direction)


class SubDirectionComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    DIRECTION_ELEMENT = "direction"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            direction = element.find(self.DIRECTION_ELEMENT).text.strip()

            return DirectionComponentPrefab(direction)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "DirectionComponent"
