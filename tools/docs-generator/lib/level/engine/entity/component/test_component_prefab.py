import unittest

from lib.graphics.color.color_prefab import HexColorPrefab
from lib.graphics.effect.effect_prefab import AlphaEffectPrefab
from lib.graphics.sprite.sprite_prefab import FileSpritePrefab
from lib.graphics.view.view_prefab import SpriteViewPrefab
from lib.level.engine.entity.component.component_prefab import *
from lib.level.event.entity_event_prefab import CreateEntityEventPrefab
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab
from lib.physics.body.body_prefab import BodyPrefab
from lib.physics.filter.filter_prefab import FilterPrefab
from lib.physics.fixture.fixture_prefab import FixturePrefab
from lib.physics.fixture.hit_box_prefab import HitBoxPrefab
from lib.physics.fixture.sensor_prefab import SensorPrefab
from lib.physics.light.light_handler_prefab import LightHandlerPrefab
from lib.physics.light.light_prefab import PointLightPrefab
from lib.physics.shape.shape_prefab import CircleShapePrefab
from lib.utility.surface.position.position_prefab import PositionPrefab


class TestSpeedComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(SpeedComponentPrefab(1)),
            "SpeedComponentPrefab(speed=1.0)"
        )


class TestSpeedModifierComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(SpeedModifierComponentPrefab(1)),
            "SpeedModifierComponentPrefab(speed_modifier=1.0)"
        )


class TestChangeBehaviorComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(ChangeBehaviorComponentPrefab([SpeedComponentPrefab(2)])),
            "ChangeBehaviorComponentPrefab(component_prefabs={})"
                    .format(str([str(SpeedComponentPrefab(speed=2.0))]))
        )


class TestProtectionComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(ProtectionComponentPrefab()),
            "ProtectionComponentPrefab()"
        )


class TestCameraTrackComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(CameraTrackComponentPrefab(100, PositionPrefab(1.1, 2.2))),
            "CameraTrackComponentPrefab(priority=100, position_prefab={})"
                    .format(str(PositionPrefab(1.1, 2.2)))
        )


class TestLeaveBonusComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(LeaveBonusComponentPrefab(14)),
            "LeaveBonusComponentPrefab(chance_modifier=14.0)"
        )


class TestSubAmmoComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(AmmoComponentPrefab(0, 1, {0:{"Left": "LeftBullet"}})),
            "AmmoComponentPrefab(current_level=0, max_level=1, prefab_codes={0: {'Left': 'LeftBullet'}})"
        )


class TestAutoShootComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(AutoShootComponentPrefab()),
            "AutoShootComponentPrefab()"
        )


class TestDamageComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(DamageComponentPrefab(1)),
            "DamageComponentPrefab(damage=1)"
        )


class TestHealthComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(HealthComponentPrefab(1, 2)),
            "HealthComponentPrefab(health=1, max_health=2)"
        )


class TestHitComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(HitComponentPrefab(AlphaEffectPrefab(1), 1.5)),
            "HitComponentPrefab(effect_prefab=AlphaEffectPrefab(alpha_value=1), hit_time=1.5)"
        )


class TestRandomShootComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(RandomShootComponentPrefab(1.1, 2.2)),
            "RandomShootComponentPrefab(min_shoot_frequency=1.1, max_shoot_frequency=2.2)"
        )


class TestDirectionComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(DirectionComponentPrefab("Left")),
            "DirectionComponentPrefab(direction=Left)"
        )


class TestRandomDirectionComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(RandomDirectionComponentPrefab(1.1, 2.2, ["Left", "Right"])),
            "RandomDirectionComponentPrefab(min_change_direction_frequency=1.1, max_change_direction_frequency=2.2,"
            " directions=['Left', 'Right'])"
        )


class TestEnemyComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(EnemyComponentPrefab()),
            "EnemyComponentPrefab()"
        )


class TestPlayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(PlayerComponentPrefab()),
            "PlayerComponentPrefab()"
        )


class TestIdentityComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(IdentityComponentPrefab("ID")),
            "IdentityComponentPrefab(id=ID)"
        )


class TestInputComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(InputComponentPrefab(1.4)),
            "InputComponentPrefab(shoot_delay=1.4)"
        )


class TestLifetimeComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(LifetimeComponentPrefab(1.4)),
            "LifetimeComponentPrefab(lifetime=1.4)"
        )


class TestCreateComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(CreateComponentPrefab()),
            "CreateComponentPrefab()"
        )


class TestDestroyComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(DestroyComponentPrefab()),
            "DestroyComponentPrefab()"
        )


class TestDestroyOnContactComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(DestroyOnContactComponentPrefab()),
            "DestroyOnContactComponentPrefab()"
        )


class TestDestroyOnContactLostComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(DestroyOnContactLostComponentPrefab()),
            "DestroyOnContactLostComponentPrefab()"
        )


class TestRandomCreateComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(RandomCreateComponentPrefab(
                1.1, 2.2,
                [
                    CreateEntryPrefab("C0", PositionPrefab(1, 2)),
                    CreateEntryPrefab("C0", PositionPrefab(3, 4))
                ]
            )),
            "RandomCreateComponentPrefab(min_create_frequency=1.1, max_create_frequency=2.2, create_entry_prefabs=[{}])"
                .format(str(", ".join('\'{}\''.format(str(val)) for val in [
                    CreateEntryPrefab("C0", PositionPrefab(1, 2)),
                    CreateEntryPrefab("C0", PositionPrefab(3, 4))
                ])))
        )


class TestAutoMoveComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(AutoMoveComponentPrefab()),
            "AutoMoveComponentPrefab()"
        )


class TestPhysicsComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(
                PhysicsComponentPrefab(
                    BodyPrefab("StaticBody", True, False, True, False, True, 1, 45, 1, 2),
                    [
                        HitBoxPrefab("HitBox0", FixturePrefab(FilterPrefab("CategoryBit", "MaskBit"),
                                                              CircleShapePrefab(PositionPrefab(1.1, 2.2), 7), 1, 2, 3,
                                                              False))
                    ],
                    [
                        SensorPrefab("Sensor0", FixturePrefab(FilterPrefab("CategoryBit", "MaskBit"),
                                                              CircleShapePrefab(PositionPrefab(1.1, 2.2), 7), 1, 2, 3,
                                                              True))
                    ],
                    [
                        LightHandlerPrefab("LightHandler0", PointLightPrefab(HexColorPrefab("CCAAFFEE"), True,
                                                                             PositionPrefab(0.1, 0.2), 10))
                    ]
                )
            ),
            "PhysicsComponentPrefab(body_prefab=BodyPrefab(body_type=StaticBody, active=True, allow_sleep=False, "
            "awake=True, bullet=False, fixed_rotation=True, gravity_scale=1.0, angle=45.0, angular_damping=1.0, "
            "linear_damping=2.0), hit_box_prefab=['HitBoxPrefab(id=HitBox0, fixture_prefab=FixturePrefab("
            "filter_prefab=FilterPrefab(category_bit=CategoryBit, mask_bit=MaskBit), shape_prefab=CircleShapePrefab("
            "position_prefab=PositionPrefab(x=1.1, y=2.2), radius=7.0), restitution=1.0, density=2.0, friction=3.0, "
            "is_sensor=False))'], sensor_prefabs=['SensorPrefab(id=Sensor0, fixture_prefab=FixturePrefab("
            "filter_prefab=FilterPrefab(category_bit=CategoryBit, mask_bit=MaskBit), shape_prefab=CircleShapePrefab("
            "position_prefab=PositionPrefab(x=1.1, y=2.2), radius=7.0), restitution=1.0, density=2.0, friction=3.0, "
            "is_sensor=True))'], light_handler_prefabs=['LightHandlerPrefab(id=LightHandler0, "
            "light_prefab=PointLightPrefab(color_prefab=HexColorPrefab(hex_value=CCAAFFEE), x_ray=True, "
            "position_prefab=PositionPrefab(x=0.1, y=0.2), distance=10.0))'])"
        )


class TestAirplaneRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(AirplaneRenderLayerComponentPrefab()),
            "AirplaneRenderLayerComponentPrefab()"
        )


class TestBombRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(BombRenderLayerComponentPrefab()),
            "BombRenderLayerComponentPrefab()"
        )


class TestBonusRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(BonusRenderLayerComponentPrefab()),
            "BonusRenderLayerComponentPrefab()"
        )


class TestBulletRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(BulletRenderLayerComponentPrefab()),
            "BulletRenderLayerComponentPrefab()"
        )


class TestCloudRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(CloudRenderLayerComponentPrefab()),
            "CloudRenderLayerComponentPrefab()"
        )


class TestExplosionRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(ExplosionRenderLayerComponentPrefab()),
            "ExplosionRenderLayerComponentPrefab()"
        )


class TestGroundRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(GroundRenderLayerComponentPrefab()),
            "GroundRenderLayerComponentPrefab()"
        )


class TestObstacleRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(ObstacleRenderLayerComponentPrefab()),
            "ObstacleRenderLayerComponentPrefab()"
        )


class TestVehicleRenderLayerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(VehicleRenderLayerComponentPrefab()),
            "VehicleRenderLayerComponentPrefab()"
        )


class TestViewComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(ViewComponentPrefab([SpriteViewPrefab("ID", PositionPrefab(1.1, 2.2),
                                                      FileSpritePrefab(True, False, "filename-test"))])),
            "ViewComponentPrefab(view_prefabs=[{}])"
                .format(str(", ".join('\'{}\''.format(str(val)) for val in
                                      [SpriteViewPrefab("ID", PositionPrefab(1.1, 2.2),
                                                        FileSpritePrefab(True, False, "filename-test"))])))
        )


class TestAirplaneSpawnerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(AirplaneSpawnerComponentPrefab("CODE")),
            "AirplaneSpawnerComponentPrefab(entity_prefab_code=CODE)"
        )


class TestRespawnComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(RespawnComponentPrefab()),
            "RespawnComponentPrefab()"
        )


class TestAutoSpawnerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(AutoSpawnerComponentPrefab("ID")),
            "AutoSpawnerComponentPrefab(id=ID)"
        )


class TestCreateTriggerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(CreateTriggerComponentPrefab([CreateEntityEventPrefab([]), CreateEntityEventPrefab([])])),
            "CreateTriggerComponentPrefab(entity_event_prefabs=[{}])"
                .format(str(", ".join('\'{}\''.format(str(val)) for val in [CreateEntityEventPrefab([]),
                                                                            CreateEntityEventPrefab([])])))
        )


class TestDestroyTriggerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(DestroyTriggerComponentPrefab([CreateEntityEventPrefab([]), CreateEntityEventPrefab([])])),
            "DestroyTriggerComponentPrefab(entity_event_prefabs=[{}])"
                .format(str(", ".join('\'{}\''.format(str(val)) for val in [CreateEntityEventPrefab([]),
                                                                            CreateEntityEventPrefab([])])))
        )


class TestHitTriggerComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(HitTriggerComponentPrefab([CreateEntityEventPrefab([]), CreateEntityEventPrefab([])])),
            "HitTriggerComponentPrefab(entity_event_prefabs=[{}])"
                .format(str(", ".join('\'{}\''.format(str(val)) for val in [CreateEntityEventPrefab([]),
                                                                            CreateEntityEventPrefab([])])))
        )


class TestStateComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(StateComponentPrefab("STATE")),
            "StateComponentPrefab(state=STATE)"
        )


if __name__ == "__main__":
    unittest.main()
