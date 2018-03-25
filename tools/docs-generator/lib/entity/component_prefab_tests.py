import os
import unittest
from lib.entity.component_prefab import *
from lib.graphics.effect_prefab import SubAlphaEffectPrefabXmlReader

ENTITY_COMPONENTS_PREFABS_ALL_FILENAME = os.path.join(os.path.dirname(__file__), 'test-entity-components-prefabs-all.xml')


class TestComponentPrefab(unittest.TestCase):
    def test_component_prefab_to_string(self):
        self.assertEqual(
            str(SpeedComponentPrefab(1)),
            "SpeedComponentPrefab(speed=1.0)"
        )


class TestComponentPrefabXmlReader(unittest.TestCase):
    def test_speed_component_prefab_xml_reader_valid(self):
        xml = """
            <component type="SpeedComponent">
                <speed>6</speed>
            </component>
        """
        reader = SubSpeedComponentPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_speed(), 6)

    def test_speed_component_prefab_xml_reader_invalid(self):
        xml = """
            <component type="SpeedComponent">
            </component>
        """
        reader = SubSpeedComponentPrefabXmlReader()

        with self.assertRaises(ComponentPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

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
            SubDirectionComponentPrefabXmlReader()
        ])
        element = EXml.parse(ENTITY_COMPONENTS_PREFABS_ALL_FILENAME).getroot()
        prefabs = reader.read_prefabs_from_string(EXml.tostring(element))

        self.assertEqual(12, len(prefabs))


if __name__ == "__main__":
    unittest.main()
