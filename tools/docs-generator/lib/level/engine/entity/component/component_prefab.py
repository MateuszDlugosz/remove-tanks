import xml.etree.ElementTree as EXml

from lib.graphics.effect.effect_prefab import EffectPrefabXmlReader
from lib.graphics.view.view_prefab import ViewPrefabXmlReader
from lib.level.utility.create_entry_prefab import CreateEntryPrefabXmlReader
from lib.level.utility.direction import DirectionXmlReader
from lib.physics.body.body_prefab import BodyPrefabXmlReader
from lib.physics.fixture.fixture_prefab import HitBoxPrefabXmlReader, SensorPrefabXmlReader
from lib.physics.light.light_prefab import LightHandlerPrefabXmlReader
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
        return "CameraTrackComponentPrefab(priority={}, position_prefab={})"\
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
    def __init__(self, direction_xml_reader):
        self.direction_xml_reader = direction_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            direction = self.direction_xml_reader.read_direction_from_string(
                EXml.tostring(element.find(DirectionXmlReader.DIRECTION_ELEMENT))
            )

            return DirectionComponentPrefab(direction)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "DirectionComponent"


class ChangeBehaviorComponentPrefab(ComponentPrefab):
    def __init__(self, component_prefabs):
        self.component_prefabs = component_prefabs

    def get_component_prefabs(self):
        return self.component_prefabs

    def __str__(self):
        return "ChangeBehaviorComponentPrefab(component_prefabs=[{}])" \
            .format(", ".join('\'{}\''.format(str(val)) for val in self.component_prefabs))


class SubChangeBehaviorComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def __init__(self, component_prefab_xml_reader):
        self.component_prefab_xml_reader = component_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            component_prefabs = self.component_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(ComponentPrefabXmlReader.COMPONENTS_ELEMENT))
            )

            return ChangeBehaviorComponentPrefab(component_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ChangeBehaviorComponent"


class RandomDirectionComponentPrefab(ComponentPrefab):
    def __init__(self, min_change_direction_frequency, max_change_direction_frequency, directions):
        self.min_change_direction_frequency = float(min_change_direction_frequency)
        self.max_change_direction_frequency = float(max_change_direction_frequency)
        self.directions = directions

    def get_min_change_direction_frequency(self):
        return self.min_change_direction_frequency

    def get_max_change_direction_frequency(self):
        return self.max_change_direction_frequency

    def get_directions(self):
        return self.directions

    def __str__(self):
        return "RandomDirectionComponentPrefab(min_change_direction_frequency={}, max_change_direction_frequency={}, " \
               "directions={})" \
                    .format(self.min_change_direction_frequency, self.max_change_direction_frequency, self.directions)


class SubRandomDirectionComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    MIN_CHANGE_DIRECTION_FREQUENCY = "minChangeDirectionFrequency"
    MAX_CHANGE_DIRECTION_FREQUENCY = "maxChangeDirectionFrequency"

    def __init__(self, direction_xml_reader):
        self.direction_xml_reader = direction_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            min_change_direction_frequency = float(element.find(self.MIN_CHANGE_DIRECTION_FREQUENCY).text.strip())
            max_change_direction_frequency = float(element.find(self.MAX_CHANGE_DIRECTION_FREQUENCY).text.strip())
            directions = self.direction_xml_reader.read_directions_from_string(
                EXml.tostring(element.find(DirectionXmlReader.DIRECTIONS_ELEMENT))
            )

            return RandomDirectionComponentPrefab(
                min_change_direction_frequency, max_change_direction_frequency, directions)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "RandomDirectionComponent"


class EnemyComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "EnemyComponentPrefab()"


class SubEnemyComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return EnemyComponentPrefab()

    def get_type(self):
        return "EnemyComponent"


class PlayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "PlayerComponentPrefab()"


class SubPlayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return PlayerComponentPrefab()

    def get_type(self):
        return "PlayerComponent"


class IdentityComponentPrefab(ComponentPrefab):
    def __init__(self, id):
        self.id = str(id)

    def get_id(self):
        return self.id

    def __str__(self):
        return "IdentityComponentPrefab(id={})".format(self.id)


class SubIdentityComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    ID_ELEMENT = "id"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            id = element.find(self.ID_ELEMENT).text.strip()

            return IdentityComponentPrefab(id)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "IdentityComponent"


class InputComponentPrefab(ComponentPrefab):
    def __init__(self, shoot_delay):
        self.shoot_delay = float(shoot_delay)

    def get_shoot_delay(self):
        return self.shoot_delay

    def __str__(self):
        return "InputComponentPrefab(shoot_delay={})".format(self.shoot_delay)


class SubInputComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    SHOOT_DELAY_ELEMENT = "shootDelay"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            shoot_delay = float(element.find(self.SHOOT_DELAY_ELEMENT).text.strip())

            return InputComponentPrefab(shoot_delay)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "InputComponent"


class CreateComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "CreateComponentPrefab()"


class SubCreateComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return CreateComponentPrefab()

    def get_type(self):
        return "CreateComponent"


class DestroyComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "DestroyComponentPrefab()"


class SubDestroyComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return DestroyComponentPrefab()

    def get_type(self):
        return "DestroyComponent"


class DestroyOnContactComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "DestroyOnContactComponentPrefab()"


class SubDestroyOnContactComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return DestroyOnContactComponentPrefab()

    def get_type(self):
        return "DestroyOnContactComponent"


class DestroyOnContactLostComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "DestroyOnContactLostComponentPrefab()"


class SubDestroyOnContactLostComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return DestroyOnContactLostComponentPrefab()

    def get_type(self):
        return "DestroyOnContactLostComponent"


class LifetimeComponentPrefab(ComponentPrefab):
    def __init__(self, lifetime):
        self.lifetime = float(lifetime)

    def get_lifetime(self):
        return self.lifetime

    def __str__(self):
        return "LifetimeComponentPrefab(lifetime={})".format(self.lifetime)


class SubLifetimeComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    LIFETIME_ELEMENT = "lifetime"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            lifetime = float(element.find(self.LIFETIME_ELEMENT).text.strip())

            return LifetimeComponentPrefab(lifetime)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "LifetimeComponent"


class RandomCreateComponentPrefab(ComponentPrefab):
    def __init__(self, min_create_frequency, max_create_frequency, create_entry_prefabs):
        self.min_create_frequency = float(min_create_frequency)
        self.max_create_frequency = float(max_create_frequency)
        self.create_entry_prefabs = create_entry_prefabs

    def get_min_create_frequency(self):
        return self.min_create_frequency

    def get_max_create_frequency(self):
        return self.max_create_frequency

    def get_create_entry_prefabs(self):
        return self.create_entry_prefabs

    def __str__(self):
        return "RandomCreateComponentPrefab(min_create_frequency={}, max_create_frequency={}, create_entry_prefabs=[{}])"\
            .format(self.min_create_frequency, self.max_create_frequency,
                    str(", ".join('\'{}\''.format(str(val)) for val in self.create_entry_prefabs)))


class SubRandomCreateComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    MIN_CREATE_FREQUENCY_ELEMENT = "minCreateFrequency"
    MAX_CREATE_FREQUENCY_ELEMENT = "maxCreateFrequency"

    def __init__(self, create_entry_prefab_xml_reader):
        self.create_entry_prefab_xml_reader = create_entry_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            min_create_frequency = float(element.find(self.MIN_CREATE_FREQUENCY_ELEMENT).text.strip())
            max_create_frequency = float(element.find(self.MAX_CREATE_FREQUENCY_ELEMENT).text.strip())
            create_entry_prefabs = self.create_entry_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(CreateEntryPrefabXmlReader.CREATE_ENTRIES_ELEMENT))
            )

            return RandomCreateComponentPrefab(min_create_frequency, max_create_frequency, create_entry_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "RandomCreateComponent"


class AutoMoveComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "AutoMoveComponentPrefab()"


class SubAutoMoveComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AutoMoveComponentPrefab()

    def get_type(self):
        return "AutoMoveComponent"


class PhysicsComponentPrefab(ComponentPrefab):
    def __init__(self, body_prefab, hit_box_prefabs, sensor_prefabs, light_handler_prefabs):
        self.body_prefab = body_prefab
        self.hit_box_prefabs = hit_box_prefabs
        self.sensor_prefabs = sensor_prefabs
        self.light_handler_prefabs = light_handler_prefabs

    def get_body_prefab(self):
        return self.body_prefab

    def get_hit_box_prefabs(self):
        return self.hit_box_prefabs

    def get_sensor_prefabs(self):
        return self.sensor_prefabs

    def get_light_handler_prefabs(self):
        return self.light_handler_prefabs

    def __str__(self):
        return "PhysicsComponentPrefab(body_prefab={}, hit_box_prefab=[{}], " \
               "sensor_prefabs=[{}], light_handler_prefabs=[{}])"\
            .format(
                str(self.body_prefab),
                str(", ".join('\'{}\''.format(str(val)) for val in self.hit_box_prefabs)),
                str(", ".join('\'{}\''.format(str(val)) for val in self.sensor_prefabs)),
                str(", ".join('\'{}\''.format(str(val)) for val in self.light_handler_prefabs))
            )


class SubPhysicsComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def __init__(self, body_prefab_xml_reader, hit_box_prefab_xml_reader,
                 sensor_prefab_xml_reader, light_handler_prefab_xml_reader):
        self.body_prefab_xml_reader = body_prefab_xml_reader
        self.hit_box_prefab_xml_reader = hit_box_prefab_xml_reader
        self.sensor_prefab_xml_reader = sensor_prefab_xml_reader
        self.light_handler_prefab_xml_reader = light_handler_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            body_prefab = self.body_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(BodyPrefabXmlReader.BODY_ELEMENT))
            )
            hit_box_prefabs = self.hit_box_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(HitBoxPrefabXmlReader.HIT_BOXES_ELEMENT))
            )
            sensor_prefabs = self.sensor_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(SensorPrefabXmlReader.SENSORS_ELEMENT))
            )
            light_handler_prefabs = self.light_handler_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(LightHandlerPrefabXmlReader.LIGHT_HANDLERS_ELEMENT))
            )

            return PhysicsComponentPrefab(body_prefab, hit_box_prefabs, sensor_prefabs, light_handler_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "PhysicsComponent"


class AirplaneRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "AirplaneRenderLayerComponentPrefab()"


class SubAirplaneRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AirplaneRenderLayerComponentPrefab()

    def get_type(self):
        return "AirplaneRenderLayerComponent"


class BombRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "BombRenderLayerComponentPrefab()"


class SubBombRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return BombRenderLayerComponentPrefab()

    def get_type(self):
        return "BombRenderLayerComponent"


class BonusRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "BonusRenderLayerComponentPrefab()"


class SubBonusRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return BonusRenderLayerComponentPrefab()

    def get_type(self):
        return "BonusRenderLayerComponent"


class BulletRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "BulletRenderLayerComponentPrefab()"


class SubBulletRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return BulletRenderLayerComponentPrefab()

    def get_type(self):
        return "BulletRenderLayerComponent"


class CloudRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "CloudRenderLayerComponentPrefab()"


class SubCloudRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return CloudRenderLayerComponentPrefab()

    def get_type(self):
        return "CloudRenderLayerComponent"


class ExplosionRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "ExplosionRenderLayerComponentPrefab()"


class SubExplosionRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ExplosionRenderLayerComponentPrefab()

    def get_type(self):
        return "ExplosionRenderLayerComponent"


class GroundRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "GroundRenderLayerComponentPrefab()"


class SubGroundRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return GroundRenderLayerComponentPrefab()

    def get_type(self):
        return "GroundRenderLayerComponent"


class ObstacleRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "ObstacleRenderLayerComponentPrefab()"


class SubObstacleRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ObstacleRenderLayerComponentPrefab()

    def get_type(self):
        return "ObstacleRenderLayerComponent"


class VehicleRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "VehicleRenderLayerComponentPrefab()"


class SubVehicleRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return VehicleRenderLayerComponentPrefab()

    def get_type(self):
        return "VehicleRenderLayerComponent"


class ViewComponentPrefab(ComponentPrefab):
    def __init__(self, view_prefabs):
        self.view_prefabs = view_prefabs

    def get_view_prefabs(self):
        return self.view_prefabs

    def __str__(self):
        return "ViewComponentPrefab(view_prefabs=[{}])" \
            .format(str(", ".join('\'{}\''.format(str(val)) for val in self.view_prefabs)))


class SubViewComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def __init__(self, view_prefab_xml_reader):
        self.view_prefab_xml_reader = view_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            view_prefabs = self.view_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(ViewPrefabXmlReader.VIEWS_ELEMENT))
            )

            return ViewComponentPrefab(view_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ViewComponent"


class AirplaneSpawnerComponentPrefab(ComponentPrefab):
    def __init__(self, entity_prefab_code):
        self.entity_prefab_code = entity_prefab_code

    def get_entity_prefab_code(self):
        return self.entity_prefab_code

    def __str__(self):
        return "AirplaneSpawnerComponentPrefab(entity_prefab_code={})".format(self.entity_prefab_code)


class SubAirplaneSpawnerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    ENTITY_PREFAB_CODE_ELEMENT = "entityPrefabCode"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_code = element.find(self.ENTITY_PREFAB_CODE_ELEMENT).text.strip()

            return AirplaneSpawnerComponentPrefab(prefab_code)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AirplaneSpawnerComponent"
