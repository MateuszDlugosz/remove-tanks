import xml.etree.ElementTree as EXml

from lib.graphics.effect.effect_prefab_xml_reader import EffectPrefabXmlReader
from lib.graphics.view.view_prefab_xml_reader import ViewPrefabXmlReader
from lib.level.engine.entity.component.component_prefab import HitTriggerComponentPrefab, SpeedComponentPrefab, \
    SpeedModifierComponentPrefab, CameraTrackComponentPrefab, LeaveBonusComponentPrefab, AmmoComponentPrefab, \
    AutoShootComponentPrefab, DamageComponentPrefab, HealthComponentPrefab, HitComponentPrefab, \
    RandomShootComponentPrefab, DirectionComponentPrefab, ChangeBehaviorComponentPrefab, RandomDirectionComponentPrefab, \
    EnemyComponentPrefab, PlayerComponentPrefab, IdentityComponentPrefab, InputComponentPrefab, CreateComponentPrefab, \
    DestroyComponentPrefab, DestroyOnContactComponentPrefab, DestroyOnContactLostComponentPrefab, \
    LifetimeComponentPrefab, RandomCreateComponentPrefab, AutoMoveComponentPrefab, PhysicsComponentPrefab, \
    AirplaneRenderLayerComponentPrefab, BombRenderLayerComponentPrefab, BonusRenderLayerComponentPrefab, \
    BulletRenderLayerComponentPrefab, CloudRenderLayerComponentPrefab, ExplosionRenderLayerComponentPrefab, \
    GroundRenderLayerComponentPrefab, ObstacleRenderLayerComponentPrefab, VehicleRenderLayerComponentPrefab, \
    ViewComponentPrefab, AirplaneSpawnerComponentPrefab, RespawnComponentPrefab, AutoSpawnerComponentPrefab, \
    StateComponentPrefab, CreateTriggerComponentPrefab, DestroyTriggerComponentPrefab, ProtectionComponentPrefab
from lib.level.event.entity_event_prefab_xml_reader import EntityEventPrefabXmlReader
from lib.level.utility.create.create_entry_prefab_xml_reader import CreateEntryPrefabXmlReader
from lib.level.utility.direction.direction_xml_reader import DirectionXmlReader
from lib.level.utility.state.state_xml_reader import StateXmlReader
from lib.physics.body.body_prefab_xml_reader import BodyPrefabXmlReader
from lib.physics.fixture.hit_box_prefab_xml_reader import HitBoxPrefabXmlReader
from lib.physics.fixture.sensor_prefab_xml_reader import SensorPrefabXmlReader
from lib.physics.light.light_handler_prefab_xml_reader import LightHandlerPrefabXmlReader
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


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


class SubSpeedModifierComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    SPEED_MODIFIER_ELEMENT = "speedModifier"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            speed_modifier = float(element.find(self.SPEED_MODIFIER_ELEMENT).text)
            return SpeedModifierComponentPrefab(speed_modifier)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "SpeedModifierComponent"


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


class SubAutoShootComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AutoShootComponentPrefab()

    def get_type(self):
        return "AutoShootComponent"


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


class SubEnemyComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return EnemyComponentPrefab()

    def get_type(self):
        return "EnemyComponent"


class SubPlayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return PlayerComponentPrefab()

    def get_type(self):
        return "PlayerComponent"


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


class SubCreateComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return CreateComponentPrefab()

    def get_type(self):
        return "CreateComponent"


class SubDestroyComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return DestroyComponentPrefab()

    def get_type(self):
        return "DestroyComponent"


class SubDestroyOnContactComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return DestroyOnContactComponentPrefab()

    def get_type(self):
        return "DestroyOnContactComponent"


class SubDestroyOnContactLostComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return DestroyOnContactLostComponentPrefab()

    def get_type(self):
        return "DestroyOnContactLostComponent"


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


class SubAutoMoveComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AutoMoveComponentPrefab()

    def get_type(self):
        return "AutoMoveComponent"


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
            hit_box_prefabs = []
            sensor_prefabs = []
            light_handler_prefabs = []

            body_prefab = self.body_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(BodyPrefabXmlReader.BODY_ELEMENT))
            )

            if element.find(HitBoxPrefabXmlReader.HIT_BOXES_ELEMENT) is not None:
                hit_box_prefabs = self.hit_box_prefab_xml_reader.read_prefabs_from_string(
                    EXml.tostring(element.find(HitBoxPrefabXmlReader.HIT_BOXES_ELEMENT))
                )

            if element.find(SensorPrefabXmlReader.SENSORS_ELEMENT) is not None:
                sensor_prefabs = self.sensor_prefab_xml_reader.read_prefabs_from_string(
                    EXml.tostring(element.find(SensorPrefabXmlReader.SENSORS_ELEMENT))
                )

            if element.find(LightHandlerPrefabXmlReader.LIGHT_HANDLERS_ELEMENT) is not None:
                light_handler_prefabs = self.light_handler_prefab_xml_reader.read_prefabs_from_string(
                    EXml.tostring(element.find(LightHandlerPrefabXmlReader.LIGHT_HANDLERS_ELEMENT))
                )

            return PhysicsComponentPrefab(body_prefab, hit_box_prefabs, sensor_prefabs, light_handler_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "PhysicsComponent"


class SubAirplaneRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AirplaneRenderLayerComponentPrefab()

    def get_type(self):
        return "AirplaneRenderLayerComponent"


class SubBombRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return BombRenderLayerComponentPrefab()

    def get_type(self):
        return "BombRenderLayerComponent"


class SubBonusRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return BonusRenderLayerComponentPrefab()

    def get_type(self):
        return "BonusRenderLayerComponent"


class SubBulletRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return BulletRenderLayerComponentPrefab()

    def get_type(self):
        return "BulletRenderLayerComponent"


class SubCloudRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return CloudRenderLayerComponentPrefab()

    def get_type(self):
        return "CloudRenderLayerComponent"


class SubExplosionRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ExplosionRenderLayerComponentPrefab()

    def get_type(self):
        return "ExplosionRenderLayerComponent"


class SubGroundRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return GroundRenderLayerComponentPrefab()

    def get_type(self):
        return "GroundRenderLayerComponent"


class SubObstacleRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ObstacleRenderLayerComponentPrefab()

    def get_type(self):
        return "ObstacleRenderLayerComponent"


class SubVehicleRenderLayerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return VehicleRenderLayerComponentPrefab()

    def get_type(self):
        return "VehicleRenderLayerComponent"


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


class SubRespawnComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return RespawnComponentPrefab()

    def get_type(self):
        return "RespawnComponent"


class SubAutoSpawnerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    ID_ELEMENT = "id"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            id = element.find(self.ID_ELEMENT).text.strip()

            return AutoSpawnerComponentPrefab(id)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AutoSpawnerComponent"


class SubStateComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def __init__(self, state_xml_reader):
        self.state_xml_reader = state_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            state = self.state_xml_reader.read_state_from_string(
                EXml.tostring(element.find(StateXmlReader.STATE_ELEMENT))
            )

            return StateComponentPrefab(state)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "StateComponent"


class SubCreateTriggerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def __init__(self, entity_event_prefab_xml_reader):
        self.entity_event_prefab_xml_reader = entity_event_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            entity_event_prefabs = self.entity_event_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(EntityEventPrefabXmlReader.ENTITY_EVENTS_ELEMENT))
            )

            return CreateTriggerComponentPrefab(entity_event_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "CreateTriggerComponent"


class SubDestroyTriggerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def __init__(self, entity_event_prefab_xml_reader):
        self.entity_event_prefab_xml_reader = entity_event_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            entity_event_prefabs = self.entity_event_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(EntityEventPrefabXmlReader.ENTITY_EVENTS_ELEMENT))
            )

            return DestroyTriggerComponentPrefab(entity_event_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "DestroyTriggerComponent"


class SubHitTriggerComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def __init__(self, entity_event_prefab_xml_reader):
        self.entity_event_prefab_xml_reader = entity_event_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            entity_event_prefabs = self.entity_event_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(EntityEventPrefabXmlReader.ENTITY_EVENTS_ELEMENT))
            )

            return HitTriggerComponentPrefab(entity_event_prefabs)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "HitTriggerComponent"


class SubProtectionComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ProtectionComponentPrefab()

    def get_type(self):
        return "ProtectionComponent"


class SubAirplaneComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ProtectionComponentPrefab()

    def get_type(self):
        return "AirplaneComponent"


class SubCloudComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return ProtectionComponentPrefab()

    def get_type(self):
        return "CloudComponent"


class ComponentPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read component prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class ComponentPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Component prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
