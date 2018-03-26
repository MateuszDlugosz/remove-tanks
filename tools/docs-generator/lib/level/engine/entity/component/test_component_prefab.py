import os
import unittest

from lib.graphics.color.color_prefab import HexColorPrefab, ColorPrefabXmlReader, SubHexColorPrefabXmlReader
from lib.graphics.effect.effect_prefab import SubAlphaEffectPrefabXmlReader, AlphaEffectPrefab
from lib.graphics.sprite.sprite_prefab import FileSpritePrefab, SpritePrefabXmlReader, SubFileSpritePrefabXmlReader
from lib.graphics.view.view_prefab import ViewPrefab, SpriteViewPrefab, SubSpriteViewPrefabXmlReader
from lib.level.engine.entity.component.component_prefab import *
from lib.level.utility.create_entry_prefab import CreateEntryPrefab
from lib.physics.body.body_prefab import BodyPrefab
from lib.physics.filter.filter_prefab import FilterPrefab, FilterPrefabXmlReader
from lib.physics.fixture.fixture_prefab import HitBoxPrefab, FixturePrefab, SensorPrefab, FixturePrefabXmlReader
from lib.physics.light.light_prefab import LightHandlerPrefab, PointLightPrefab, LightPrefabXmlReader, \
    SubDirectionalLightPrefabXmlReader
from lib.physics.shape.shape_prefab import CircleShapePrefab, ShapePrefabXmlReader, SubCircleShapePrefabXmlReader

ENTITY_COMPONENTS_PREFABS_ALL_FILENAME = os.path.join(
    os.path.dirname(__file__), 'test-entity-components-prefabs-all.xml')


class TestSpeedComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(SpeedComponentPrefab(1)),
            "SpeedComponentPrefab(speed=1.0)"
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


class TestStateComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(StateComponentPrefab("STATE")),
            "StateComponentPrefab(state=STATE)"
        )


class TestSubSpeedComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="SpeedComponent">
                <speed>6</speed>
            </component>
        """
        reader = SubSpeedComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_speed(), 6)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="SpeedComponent">
            </component>
        """
        reader = SubSpeedComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubChangeBehaviorComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="ChangeBehaviorComponent">
                <components>
                    <component type="SpeedComponent">
                        <speed>1.1</speed>
                    </component>
                </components>
            </component>
        """
        reader = SubChangeBehaviorComponentPrefabXmlReader(
            ComponentPrefabXmlReader(
                [
                    SubSpeedComponentPrefabXmlReader()
                ]
            )
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_component_prefabs()[0].get_speed(), 1.1)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="ChangeBehaviorComponent">
                <components>
                    <component type="SpeedComponent">
                    </component>
                </components>
            </component>
        """
        reader = SubChangeBehaviorComponentPrefabXmlReader(
            ComponentPrefabXmlReader(
                [
                    SubSpeedComponentPrefabXmlReader()
                ]
            )
        )

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubCameraTrackComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="CameraTrackComponent">
                <priority>1</priority>
                <position>
                    <x>7.1</x>
                    <y>2.6</y>
                </position>
            </component>
        """
        reader = SubCameraTrackComponentPrefabXmlReader(PositionPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_priority(), 1)
        self.assertEqual(prefab.get_position_prefab().get_x(), 7.1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2.6)

    def test_component_prefab_xml_reader_valid_defaults(self):
        xml = """
            <component type="CameraTrackComponent">
                <priority>1</priority>
            </component>
        """
        reader = SubCameraTrackComponentPrefabXmlReader(PositionPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_priority(), 1)
        self.assertEqual(prefab.get_position_prefab().get_x(), 0)
        self.assertEqual(prefab.get_position_prefab().get_y(), 0)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="CameraTrackComponent" />
        """
        reader = SubCameraTrackComponentPrefabXmlReader(PositionPrefabXmlReader())

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubLeaveBonusComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="LeaveBonusComponent">
                <chanceModifier>10</chanceModifier>
            </component>
        """
        reader = SubLeaveBonusComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_chance_modifier(), 10)

    def test_component_prefab_xml_reader_valid_defaults(self):
        xml = """
            <component type="LeaveBonusComponent" />
        """
        reader = SubLeaveBonusComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_chance_modifier(), 0)


class TestSubAmmoComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
        <component type="AmmoComponent">
            <currentLevel>0</currentLevel>
            <maxLevel>1</maxLevel>
            <ammo level="0">
                <bullet direction="Left">LeftBullet0</bullet>
                <bullet direction="Right">RightBullet0</bullet>
                <bullet direction="Up">UpBullet0</bullet>
                <bullet direction="Down">DownBullet0</bullet>
            </ammo>
            <ammo level="1">
                <bullet direction="Left">LeftBullet1</bullet>
                <bullet direction="Right">RightBullet1</bullet>
                <bullet direction="Up">UpBullet1</bullet>
                <bullet direction="Down">DownBullet1</bullet>
            </ammo>
        </component>
        """
        reader = SubAmmoComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_current_level(), 0)
        self.assertEqual(prefab.get_max_level(), 1)
        self.assertEqual(prefab.get_prefab_codes()[0]["Left"], "LeftBullet0")
        self.assertEqual(prefab.get_prefab_codes()[0]["Right"], "RightBullet0")
        self.assertEqual(prefab.get_prefab_codes()[0]["Up"], "UpBullet0")
        self.assertEqual(prefab.get_prefab_codes()[0]["Down"], "DownBullet0")
        self.assertEqual(prefab.get_prefab_codes()[1]["Left"], "LeftBullet1")
        self.assertEqual(prefab.get_prefab_codes()[1]["Right"], "RightBullet1")
        self.assertEqual(prefab.get_prefab_codes()[1]["Up"], "UpBullet1")
        self.assertEqual(prefab.get_prefab_codes()[1]["Down"], "DownBullet1")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="AmmoComponent" />
        """
        reader = SubAmmoComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubAutoShootComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="AutoShootComponent" />
        """
        reader = SubAutoShootComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubDamageComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="DamageComponent">
                <damage>6</damage>
            </component>
        """
        reader = SubDamageComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_damage(), 6)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="DamageComponent" />
        """
        reader = SubDamageComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubHealthComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="HealthComponent">
                <health>1</health>
                <maxHealth>2</maxHealth>
            </component>
        """
        reader = SubHealthComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_health(), 1)
        self.assertEqual(prefab.get_max_health(), 2)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="HealthComponent" />
        """
        reader = SubHealthComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubHitComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
        <component type="HitComponent">
            <effect type="AlphaEffect">
                <alphaValue>1</alphaValue>
            </effect>
            <hitTime>1.5</hitTime>
        </component>
        """
        reader = SubHitComponentPrefabXmlReader(EffectPrefabXmlReader([SubAlphaEffectPrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_hit_time(), 1.5)
        self.assertEqual(prefab.get_effect_prefab().get_alpha_value(), 1)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
        <component type="HitComponent" />
        """
        reader = SubHitComponentPrefabXmlReader(EffectPrefabXmlReader([SubAlphaEffectPrefabXmlReader()]))

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubProtectionComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="ProtectionComponent" />
        """
        reader = SubProtectionComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubRandomShootComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="RandomShootComponent">
                <minShootFrequency>1.1</minShootFrequency>
                <maxShootFrequency>2.4</maxShootFrequency>
            </component>
        """
        reader = SubRandomShootComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_min_shoot_frequency(), 1.1)
        self.assertEqual(prefab.get_max_shoot_frequency(), 2.4)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="RandomShootComponent" />
        """
        reader = SubRandomShootComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubDirectionComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="DirectionComponent">
                <direction>Left</direction>
            </component>
        """
        reader = SubDirectionComponentPrefabXmlReader(DirectionXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_direction(), "Left")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="DirectionComponent" />
        """
        reader = SubDirectionComponentPrefabXmlReader(DirectionXmlReader())

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubRandomDirectionComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="RandomDirectionComponent">
                <minChangeDirectionFrequency>1.1</minChangeDirectionFrequency>
                <maxChangeDirectionFrequency>2.2</maxChangeDirectionFrequency>
                <directions>
                    <direction>Left</direction>
                    <direction>Right</direction>
                </directions>
            </component>
        """
        reader = SubRandomDirectionComponentPrefabXmlReader(DirectionXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(len(prefab.get_directions()), 2)
        self.assertEqual(prefab.get_directions()[0], "Left")
        self.assertEqual(prefab.get_directions()[1], "Right")
        self.assertEqual(prefab.get_min_change_direction_frequency(), 1.1)
        self.assertEqual(prefab.get_max_change_direction_frequency(), 2.2)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="RandomDirectionComponent" />
        """
        reader = SubRandomDirectionComponentPrefabXmlReader(DirectionXmlReader())

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubEnemyComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="EnemyComponent" />
        """
        reader = SubEnemyComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubPlayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="PlayerComponent" />
        """
        reader = SubPlayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubIdentityComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="IdentityComponent">
                <id>ID</id>
            </component>
        """
        reader = SubIdentityComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "ID")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="IdentityComponent" />
        """
        reader = SubIdentityComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubInputComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="InputComponent">
                <shootDelay>3.4</shootDelay>
            </component>
        """
        reader = SubInputComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_shoot_delay(), 3.4)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="InputComponent" />
        """
        reader = SubInputComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubLifetimeComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="LifetimeComponent">
                <lifetime>1.4</lifetime>
            </component>
        """
        reader = SubLifetimeComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_lifetime(), 1.4)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="LifetimeComponent" />
        """
        reader = SubLifetimeComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubCreateComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="CreateComponent" />
        """
        reader = SubCreateComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubDestroyComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="DestroyComponent" />
        """
        reader = SubDestroyComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubDestroyOnContactComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="DestroyOnContactComponent" />
        """
        reader = SubDestroyOnContactComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubDestroyOnContactLostComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="DestroyOnContactLostComponent" />
        """
        reader = SubDestroyOnContactLostComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubRandomCreateComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="RandomCreateComponent">
                <minCreateFrequency>1.1</minCreateFrequency>
                <maxCreateFrequency>2.2</maxCreateFrequency>
                <createEntries>
                    <createEntry>
                        <entityPrefabCode>CODE_0</entityPrefabCode>
                        <position>
                            <x>3.3</x>
                            <y>4.4</y>
                        </position>
                    </createEntry>
                </createEntries>
            </component>
        """
        reader = SubRandomCreateComponentPrefabXmlReader(CreateEntryPrefabXmlReader(PositionPrefabXmlReader()))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_min_create_frequency(), 1.1)
        self.assertEqual(prefab.get_max_create_frequency(), 2.2)
        self.assertEqual(len(prefab.get_create_entry_prefabs()), 1)
        self.assertEqual(prefab.get_create_entry_prefabs()[0].get_position_prefab().get_x(), 3.3)
        self.assertEqual(prefab.get_create_entry_prefabs()[0].get_position_prefab().get_y(), 4.4)
        self.assertEqual(prefab.get_create_entry_prefabs()[0].get_prefab_code(), "CODE_0")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="RandomCreateComponent" />
        """
        reader = SubRandomCreateComponentPrefabXmlReader(CreateEntryPrefabXmlReader(PositionPrefabXmlReader()))

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubAutoMoveComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="AutoMoveComponent" />
        """
        reader = SubAutoMoveComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubPhysicsComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="PhysicsComponent">
                <body>
                    <type>KinematicBody</type>
                    <active>true</active>
                    <allowSleep>false</allowSleep>
                    <awake>false</awake>
                    <bullet>true</bullet>
                    <fixedRotation>false</fixedRotation>
                    <gravityScale>1</gravityScale>
                    <angle>10</angle>
                    <angularDamping>2</angularDamping>
                    <linearDamping>8</linearDamping>
                </body>
                <hitBoxes>
                    <hitBox id="A">
                        <fixture>
                            <shape type="CircleShape">
                                <radius>2</radius>
                                <position>
                                    <x>10</x>
                                    <y>20</y>
                                </position>
                            </shape>
                            <filter>
                                <categoryBit>CategoryBit0</categoryBit>
                                <maskBit>MaskBit0</maskBit>
                            </filter>
                            <restitution>1</restitution>
                            <density>5</density>
                            <friction>8</friction>
                        </fixture>
                    </hitBox>
                </hitBoxes>
                <sensors>
                    <sensor id="B">
                        <fixture>
                            <shape type="CircleShape">
                                <radius>2</radius>
                                <position>
                                    <x>10</x>
                                    <y>20</y>
                                </position>
                            </shape>
                            <filter>
                                <categoryBit>CategoryBit0</categoryBit>
                                <maskBit>MaskBit0</maskBit>
                            </filter>
                            <restitution>1</restitution>
                            <density>5</density>
                            <friction>8</friction>
                        </fixture>
                    </sensor>
                </sensors>
                <lightHandlers>
                    <lightHandler id="TestID0">
                        <light type="DirectionalLight">
                            <color type="HexColor">
                                <hexValue>CCAAFFEE</hexValue>
                            </color>
                            <xRay>true</xRay>
                            <directionDegree>10</directionDegree>
                        </light>
                    </lightHandler>
                </lightHandlers>
            </component>
        """
        reader = SubPhysicsComponentPrefabXmlReader(
            BodyPrefabXmlReader(),
            HitBoxPrefabXmlReader(
                FixturePrefabXmlReader(
                    FilterPrefabXmlReader(),
                    ShapePrefabXmlReader(
                        [
                            SubCircleShapePrefabXmlReader(
                                PositionPrefabXmlReader()
                            )
                        ]
                    )
                )
            ),
            SensorPrefabXmlReader(
                FixturePrefabXmlReader(
                    FilterPrefabXmlReader(),
                    ShapePrefabXmlReader(
                        [
                            SubCircleShapePrefabXmlReader(
                                PositionPrefabXmlReader()
                            )
                        ]
                    )
                )
            ),
            LightHandlerPrefabXmlReader(
                LightPrefabXmlReader(
                    [
                        SubDirectionalLightPrefabXmlReader(
                            ColorPrefabXmlReader(
                                [
                                    SubHexColorPrefabXmlReader()
                                ]
                            )
                        )
                    ]
                )
            )
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_body_prefab().get_body_type(), "KinematicBody")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="PhysicsComponent" />
        """
        reader = SubPhysicsComponentPrefabXmlReader(
            BodyPrefabXmlReader(),
            HitBoxPrefabXmlReader(FixturePrefabXmlReader(FilterPrefabXmlReader(), ShapePrefabXmlReader([]))),
            SensorPrefabXmlReader(FixturePrefabXmlReader(FilterPrefabXmlReader(), ShapePrefabXmlReader([]))),
            LightHandlerPrefabXmlReader(LightPrefabXmlReader([]))
        )

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubAirplaneRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="AirplaneRenderLayerComponent" />
        """
        reader = SubAirplaneRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubBombRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="BombRenderLayerComponent" />
        """
        reader = SubBombRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubBonusRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="BonusRenderLayerComponent" />
        """
        reader = SubBonusRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubBulletRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="BulletRenderLayerComponent" />
        """
        reader = SubBulletRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubCloudRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="CloudRenderLayerComponent" />
        """
        reader = SubCloudRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubExplosionRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="ExplosionRenderLayerComponent" />
        """
        reader = SubExplosionRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubGroundRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="GroundRenderLayerComponent" />
        """
        reader = SubGroundRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubObstacleRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="ObstacleRenderLayerComponent" />
        """
        reader = SubObstacleRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubVehicleRenderLayerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="VehicleRenderLayerComponent" />
        """
        reader = SubVehicleRenderLayerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubViewComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="ViewComponent">
                <views>
                    <view id="ID" type="SpriteView">
                        <sprite type="FileSprite">
                            <filename>test-filename</filename>
                        </sprite>
                    </view>
                </views>
            </component>
        """
        reader = SubViewComponentPrefabXmlReader(
            ViewPrefabXmlReader(
                [
                    SubSpriteViewPrefabXmlReader(
                        PositionPrefabXmlReader(),
                        SpritePrefabXmlReader(
                            [
                                SubFileSpritePrefabXmlReader()
                            ]
                        )
                    )
                ]
            )
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="ViewComponent" />
        """
        reader = SubViewComponentPrefabXmlReader(ViewPrefabXmlReader([]))

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubAirplaneSpawnerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="AirplaneSpawnerComponent">
                <entityPrefabCode>CODE</entityPrefabCode>
            </component>
        """
        reader = SubAirplaneSpawnerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_entity_prefab_code(), "CODE")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="AirplaneSpawnerComponent" />
        """
        reader = SubAirplaneSpawnerComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)



class TestSubRespawnComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="RespawnComponent" />
        """
        reader = SubRespawnComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubAutoSpawnerComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="AutoSpawnerComponent">
                <id>ID</id>
            </component>
        """
        reader = SubAutoSpawnerComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "ID")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="AutoSpawnerComponent" />
        """
        reader = SubAutoSpawnerComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubStateComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="StateComponent">
                <state>ID</state>
            </component>
        """
        reader = SubStateComponentPrefabXmlReader(StateXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_state(), "ID")

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="StateComponent" />
        """
        reader = SubStateComponentPrefabXmlReader(StateXmlReader())

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestComponentPrefabXmlReader(unittest.TestCase):
    def test_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="SpeedComponent">
                <speed>5</speed>
            </component>
        """
        reader = ComponentPrefabXmlReader([SubSpeedComponentPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_speed(), 5)

    def test_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="SpeedComponent">
            </component>
        """
        reader = ComponentPrefabXmlReader([])

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_component_prefabs_xml_reader_valid(self):
        xml = """
            <components>
                <component type="SpeedComponent">
                    <speed>1</speed>
                </component>
                <component type="SpeedComponent">
                    <speed>2</speed>
                </component>
            </components>
        """
        reader = ComponentPrefabXmlReader([SubSpeedComponentPrefabXmlReader()])
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(len(prefabs), 2)
        self.assertEqual(prefabs[0].get_speed(), 1)
        self.assertEqual(prefabs[1].get_speed(), 2)

    def test_component_prefabs_xml_reader_invalid(self):
        xml = """
            <components>
                <component type="SpeedComponent">
                </component>
            </components>
        """
        reader = ComponentPrefabXmlReader([SubSpeedComponentPrefabXmlReader()])

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefabs_from_string(xml)

    def test_component_prefabs_xml_reader_all(self):
        reader = ComponentPrefabXmlReader([
            SubCameraTrackComponentPrefabXmlReader(PositionPrefabXmlReader()),
            SubLeaveBonusComponentPrefabXmlReader(),
            SubAmmoComponentPrefabXmlReader(),
            SubAutoShootComponentPrefabXmlReader(),
            SubDamageComponentPrefabXmlReader(),
            SubHealthComponentPrefabXmlReader(),
            SubHitComponentPrefabXmlReader(
                EffectPrefabXmlReader([
                    SubAlphaEffectPrefabXmlReader()
                ])
            ),
            SubProtectionComponentPrefabXmlReader(),
            SubRandomShootComponentPrefabXmlReader(),
            SubDirectionComponentPrefabXmlReader(
                DirectionXmlReader()
            ),
            SubChangeBehaviorComponentPrefabXmlReader(
                ComponentPrefabXmlReader(
                    [
                        SubCameraTrackComponentPrefabXmlReader(PositionPrefabXmlReader())
                    ]
                )
            ),
            SubRandomDirectionComponentPrefabXmlReader(
                DirectionXmlReader()
            ),
            SubEnemyComponentPrefabXmlReader(),
            SubPlayerComponentPrefabXmlReader(),
            SubIdentityComponentPrefabXmlReader(),
            SubInputComponentPrefabXmlReader(),
            SubCreateComponentPrefabXmlReader(),
            SubDestroyComponentPrefabXmlReader(),
            SubDestroyOnContactComponentPrefabXmlReader(),
            SubDestroyOnContactLostComponentPrefabXmlReader(),
            SubLifetimeComponentPrefabXmlReader(),
            SubRandomCreateComponentPrefabXmlReader(
                CreateEntryPrefabXmlReader(
                    PositionPrefabXmlReader()
                )
            ),
            SubAutoMoveComponentPrefabXmlReader(),
            SubPhysicsComponentPrefabXmlReader(
                BodyPrefabXmlReader(),
                HitBoxPrefabXmlReader(
                    FixturePrefabXmlReader(
                        FilterPrefabXmlReader(),
                        ShapePrefabXmlReader(
                            [
                                SubCircleShapePrefabXmlReader(
                                    PositionPrefabXmlReader()
                                )
                            ]
                        )
                    )
                ),
                SensorPrefabXmlReader(
                    FixturePrefabXmlReader(
                        FilterPrefabXmlReader(),
                        ShapePrefabXmlReader(
                            [
                                SubCircleShapePrefabXmlReader(
                                    PositionPrefabXmlReader()
                                )
                            ]
                        )
                    )
                ),
                LightHandlerPrefabXmlReader(
                    LightPrefabXmlReader(
                        [
                            SubDirectionalLightPrefabXmlReader(
                                ColorPrefabXmlReader(
                                    [
                                        SubHexColorPrefabXmlReader()
                                    ]
                                )
                            )
                        ]
                    )
                )
            ),
            SubAirplaneRenderLayerComponentPrefabXmlReader(),
            SubBombRenderLayerComponentPrefabXmlReader(),
            SubBonusRenderLayerComponentPrefabXmlReader(),
            SubBulletRenderLayerComponentPrefabXmlReader(),
            SubCloudRenderLayerComponentPrefabXmlReader(),
            SubExplosionRenderLayerComponentPrefabXmlReader(),
            SubGroundRenderLayerComponentPrefabXmlReader(),
            SubObstacleRenderLayerComponentPrefabXmlReader(),
            SubVehicleRenderLayerComponentPrefabXmlReader(),
            SubViewComponentPrefabXmlReader(
                ViewPrefabXmlReader(
                    [
                        SubSpriteViewPrefabXmlReader(
                            PositionPrefabXmlReader(),
                            SpritePrefabXmlReader(
                                [
                                    SubFileSpritePrefabXmlReader()
                                ]
                            )
                        )
                    ]
                )
            ),
            SubAirplaneSpawnerComponentPrefabXmlReader(),
            SubRespawnComponentPrefabXmlReader(),
            SubAutoSpawnerComponentPrefabXmlReader(),
            SubStateComponentPrefabXmlReader(StateXmlReader())
        ])
        element = EXml.parse(ENTITY_COMPONENTS_PREFABS_ALL_FILENAME).getroot()
        prefabs = reader.read_prefabs_from_string(EXml.tostring(element))

        self.assertEqual(40, len(prefabs))


if __name__ == "__main__":
    unittest.main()
