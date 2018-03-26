import os
import unittest

from lib.graphics.effect.effect_prefab import SubAlphaEffectPrefabXmlReader, AlphaEffectPrefab
from lib.level.engine.entity.component.component_prefab import *

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
            SubLifetimeComponentPrefabXmlReader()
        ])
        element = EXml.parse(ENTITY_COMPONENTS_PREFABS_ALL_FILENAME).getroot()
        prefabs = reader.read_prefabs_from_string(EXml.tostring(element))

        self.assertEqual(23, len(prefabs))


if __name__ == "__main__":
    unittest.main()
