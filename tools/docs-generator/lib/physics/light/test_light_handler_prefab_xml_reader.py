import unittest

from lib.graphics.color.color_prefab import HexColorPrefab
from lib.graphics.color.color_prefab_xml_reader import ColorPrefabXmlReader, SubHexColorPrefabXmlReader
from lib.physics.light.light_handler_prefab import LightHandlerPrefab
from lib.physics.light.light_handler_prefab_xml_reader import LightHandlerPrefabXmlReader, \
    LightHandlerPrefabXmlReadException
from lib.physics.light.light_prefab import DirectionalLightPrefab
from lib.physics.light.light_prefab_xml_reader import LightPrefabXmlReader, SubDirectionalLightPrefabXmlReader


class TestLightHandlerPrefab(unittest.TestCase):
    def test_light_handler_prefab_to_string(self):
        self.assertEqual(
            str(LightHandlerPrefab("TestID", DirectionalLightPrefab(HexColorPrefab("CCAAFFEE"), True, 10))),
            "LightHandlerPrefab(id=TestID, light_prefab=DirectionalLightPrefab("
            "color_prefab=HexColorPrefab(hex_value=CCAAFFEE), "
            "x_ray=True, direction_degree=10.0))"
        )


class TestLightHandlerPrefabXmlReader(unittest.TestCase):
    def test_light_handler_prefab_xml_reader_valid(self):
        xml = """
            <lightHandler id="TestID">
                <light type="DirectionalLight">
                    <color type="HexColor">
                        <hexValue>CCAAFFEE</hexValue>
                    </color>
                    <xRay>true</xRay>
                    <directionDegree>10</directionDegree>
                </light>
            </lightHandler>
        """
        reader = LightHandlerPrefabXmlReader(
            LightPrefabXmlReader([
                SubDirectionalLightPrefabXmlReader(
                    ColorPrefabXmlReader([
                        SubHexColorPrefabXmlReader()
                    ])
                )
            ])
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_light_prefab().get_color_prefab().get_hex_value(), "CCAAFFEE")
        self.assertEqual(prefab.get_light_prefab().get_direction_degree(), 10)
        self.assertTrue(prefab.get_light_prefab().get_x_ray())

    def test_light_handler_prefab_xml_reader_invalid(self):
        xml = """
            <lightHandler></lightHandler>
        """
        reader = LightHandlerPrefabXmlReader(LightPrefabXmlReader([]))

        with self.assertRaises(LightHandlerPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_light_handler_prefabs_xml_reader_valid(self):
        xml = """
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
                <lightHandler id="TestID1">
                    <light type="DirectionalLight">
                        <color type="HexColor">
                            <hexValue>CCAAFFEE</hexValue>
                        </color>
                        <xRay>false</xRay>
                        <directionDegree>101</directionDegree>
                    </light>
                </lightHandler>
            </lightHandlers>
        """
        reader = LightHandlerPrefabXmlReader(
            LightPrefabXmlReader([
                SubDirectionalLightPrefabXmlReader(
                    ColorPrefabXmlReader([
                        SubHexColorPrefabXmlReader()
                    ])
                )
            ])
        )
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(prefabs[0].get_id(), "TestID0")
        self.assertEqual(prefabs[0].get_light_prefab().get_color_prefab().get_hex_value(), "CCAAFFEE")
        self.assertEqual(prefabs[0].get_light_prefab().get_direction_degree(), 10)
        self.assertTrue(prefabs[0].get_light_prefab().get_x_ray())
        self.assertEqual(prefabs[1].get_id(), "TestID1")
        self.assertEqual(prefabs[1].get_light_prefab().get_color_prefab().get_hex_value(), "CCAAFFEE")
        self.assertEqual(prefabs[1].get_light_prefab().get_direction_degree(), 101)
        self.assertFalse(prefabs[1].get_light_prefab().get_x_ray())

    def test_light_handler_prefabs_xml_reader_invalid(self):
        xml = """
            <lightHandlers>
                <lightHandler></lightHandler>
            </lightHandlers>
        """
        reader = LightHandlerPrefabXmlReader(
            LightPrefabXmlReader([
                SubDirectionalLightPrefabXmlReader(
                    ColorPrefabXmlReader([
                        SubHexColorPrefabXmlReader()
                    ])
                )
            ])
        )

        with self.assertRaises(LightHandlerPrefabXmlReadException):
            reader.read_prefabs_from_string(xml)


if __name__ == "__main__":
    unittest.main()
