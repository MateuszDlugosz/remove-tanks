class ComponentPrefab(object):
    pass


class SpeedComponentPrefab(ComponentPrefab):
    def __init__(self, speed):
        self.speed = float(speed)

    def get_speed(self):
        return self.speed

    def __str__(self):
        return "SpeedComponentPrefab(speed={})".format(self.speed)


class SpeedModifierComponentPrefab(ComponentPrefab):
    def __init__(self, speed_modifier):
        self.speed_modifier = float(speed_modifier)

    def get_speed_modifier(self):
        return self.speed_modifier

    def __str__(self):
        return "SpeedModifierComponentPrefab(speed_modifier={})".format(self.speed_modifier)


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


class LeaveBonusComponentPrefab(ComponentPrefab):
    def __init__(self, chance_modifier):
        self.chance_modifier = float(chance_modifier)

    def get_chance_modifier(self):
        return self.chance_modifier

    def __str__(self):
        return "LeaveBonusComponentPrefab(chance_modifier={})".format(self.chance_modifier)


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


class AutoShootComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "AutoShootComponentPrefab()"


class DamageComponentPrefab(ComponentPrefab):
    def __init__(self, damage):
        self.damage = int(damage)

    def get_damage(self):
        return self.damage

    def __str__(self):
        return "DamageComponentPrefab(damage={})".format(self.damage)


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


class ProtectionComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "ProtectionComponentPrefab()"


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


class DirectionComponentPrefab(ComponentPrefab):
    def __init__(self, direction):
        self.direction = str(direction)

    def get_direction(self):
        return self.direction

    def __str__(self):
        return "DirectionComponentPrefab(direction={})".format(self.direction)


class ChangeBehaviorComponentPrefab(ComponentPrefab):
    def __init__(self, component_prefabs):
        self.component_prefabs = component_prefabs

    def get_component_prefabs(self):
        return self.component_prefabs

    def __str__(self):
        return "ChangeBehaviorComponentPrefab(component_prefabs=[{}])" \
            .format(", ".join('\'{}\''.format(str(val)) for val in self.component_prefabs))


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


class EnemyComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "EnemyComponentPrefab()"


class PlayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "PlayerComponentPrefab()"


class IdentityComponentPrefab(ComponentPrefab):
    def __init__(self, id):
        self.id = str(id)

    def get_id(self):
        return self.id

    def __str__(self):
        return "IdentityComponentPrefab(id={})".format(self.id)


class InputComponentPrefab(ComponentPrefab):
    def __init__(self, shoot_delay):
        self.shoot_delay = float(shoot_delay)

    def get_shoot_delay(self):
        return self.shoot_delay

    def __str__(self):
        return "InputComponentPrefab(shoot_delay={})".format(self.shoot_delay)


class CreateComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "CreateComponentPrefab()"


class DestroyComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "DestroyComponentPrefab()"


class DestroyOnContactComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "DestroyOnContactComponentPrefab()"


class DestroyOnContactLostComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "DestroyOnContactLostComponentPrefab()"


class LifetimeComponentPrefab(ComponentPrefab):
    def __init__(self, lifetime):
        self.lifetime = float(lifetime)

    def get_lifetime(self):
        return self.lifetime

    def __str__(self):
        return "LifetimeComponentPrefab(lifetime={})".format(self.lifetime)


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
        return "RandomCreateComponentPrefab(min_create_frequency={}, max_create_frequency={}, " \
               "create_entry_prefabs=[{}])"\
            .format(self.min_create_frequency, self.max_create_frequency,
                    str(", ".join('\'{}\''.format(str(val)) for val in self.create_entry_prefabs)))


class AutoMoveComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "AutoMoveComponentPrefab()"


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


class AirplaneRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "AirplaneRenderLayerComponentPrefab()"


class BombRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "BombRenderLayerComponentPrefab()"


class BonusRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "BonusRenderLayerComponentPrefab()"


class BulletRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "BulletRenderLayerComponentPrefab()"


class CloudRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "CloudRenderLayerComponentPrefab()"


class ExplosionRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "ExplosionRenderLayerComponentPrefab()"


class GroundRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "GroundRenderLayerComponentPrefab()"


class ObstacleRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "ObstacleRenderLayerComponentPrefab()"


class VehicleRenderLayerComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "VehicleRenderLayerComponentPrefab()"


class ViewComponentPrefab(ComponentPrefab):
    def __init__(self, view_prefabs):
        self.view_prefabs = view_prefabs

    def get_view_prefabs(self):
        return self.view_prefabs

    def __str__(self):
        return "ViewComponentPrefab(view_prefabs=[{}])" \
            .format(str(", ".join('\'{}\''.format(str(val)) for val in self.view_prefabs)))


class AirplaneSpawnerComponentPrefab(ComponentPrefab):
    def __init__(self, entity_prefab_code):
        self.entity_prefab_code = entity_prefab_code

    def get_entity_prefab_code(self):
        return self.entity_prefab_code

    def __str__(self):
        return "AirplaneSpawnerComponentPrefab(entity_prefab_code={})".format(self.entity_prefab_code)


class RespawnComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "RespawnComponentPrefab()"


class AutoSpawnerComponentPrefab(ComponentPrefab):
    def __init__(self, id):
        self.id = id

    def get_id(self):
        return self.id

    def __str__(self):
        return "AutoSpawnerComponentPrefab(id={})".format(self.id)


class StateComponentPrefab(ComponentPrefab):
    def __init__(self, state):
        self.state = str(state)

    def get_state(self):
        return self.state

    def __str__(self):
        return "StateComponentPrefab(state={})".format(self.state)


class CreateTriggerComponentPrefab(ComponentPrefab):
    def __init__(self, entity_event_prefabs):
        self.entity_event_prefabs = entity_event_prefabs

    def get_entity_event_prefabs(self):
        return self.entity_event_prefabs

    def __str__(self):
        return "CreateTriggerComponentPrefab(entity_event_prefabs=[{}])" \
            .format(str(", ".join('\'{}\''.format(str(val)) for val in self.entity_event_prefabs)))


class DestroyTriggerComponentPrefab(ComponentPrefab):
    def __init__(self, entity_event_prefabs):
        self.entity_event_prefabs = entity_event_prefabs

    def get_entity_event_prefabs(self):
        return self.entity_event_prefabs

    def __str__(self):
        return "DestroyTriggerComponentPrefab(entity_event_prefabs=[{}])" \
            .format(str(", ".join('\'{}\''.format(str(val)) for val in self.entity_event_prefabs)))


class HitTriggerComponentPrefab(ComponentPrefab):
    def __init__(self, entity_event_prefabs):
        self.entity_event_prefabs = entity_event_prefabs

    def get_entity_event_prefabs(self):
        return self.entity_event_prefabs

    def __str__(self):
        return "HitTriggerComponentPrefab(entity_event_prefabs=[{}])" \
            .format(str(", ".join('\'{}\''.format(str(val)) for val in self.entity_event_prefabs)))


class AirplaneComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "AirplaneComponentPrefab()"


class CloudComponentPrefab(ComponentPrefab):
    def __str__(self):
        return "CloudComponentPrefab()"
