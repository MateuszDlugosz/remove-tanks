import unittest

from lib.graphics.color.color_prefab_xml_reader import ColorPrefabXmlReader, SubHexColorPrefabXmlReader
from lib.physics.light.light_prefab_xml_reader import SubPointLightPrefabXmlReader, LightPrefabXmlReadException, \
    SubDirectionalLightPrefabXmlReader, SubConeLightPrefabXmlReader, LightPrefabXmlReader
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class TestSubPointLightPrefabXmlReader(unittest.TestCase):
    def test_point_light_prefab_xml_reader_valid(self):
        xml = """
            <light type="PointLight">
                <color type="HexColor">
                    <hexValue>CCAAFFEE</hexValue>
                </color>
                <position>
                    <x>1</x>
                    <y>2</y>
                </position>
                <distance>10</distance>
                <xRay>true</xRay>
            </light>
        """
        reader = SubPointLightPrefabXmlReader(
            ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]),
            PositionPrefabXmlReader()
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_color_prefab().get_hex_value(), "CCAAFFEE")
        self.assertEqual(prefab.get_position_prefab().get_x(), 1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2)
        self.assertEqual(prefab.get_distance(), 10)
        self.assertTrue(prefab.get_x_ray())

    def test_point_light_prefab_xml_reader_invalid(self):
        xml = """
            <light type="PointLight">
            </light>
        """
        reader = SubPointLightPrefabXmlReader(
            ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]),
            PositionPrefabXmlReader()
        )

        with self.assertRaises(LightPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubDirectionalLightPrefabXmlReader(unittest.TestCase):
    def test_directional_light_prefab_xml_reader_valid(self):
        xml = """
            <light type="DirectionalLight">
                <color type="HexColor">
                    <hexValue>CCAAFFEE</hexValue>
                </color>
                <directionDegree>10</directionDegree>
                <xRay>true</xRay>
            </light>
        """
        reader = SubDirectionalLightPrefabXmlReader(ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_color_prefab().get_hex_value(), "CCAAFFEE")
        self.assertEqual(prefab.get_direction_degree(), 10)
        self.assertTrue(prefab.get_x_ray())

    def test_directional_light_prefab_xml_reader_invalid(self):
        xml = """
            <light type="DirectionalLight">
            </light>
        """
        reader = SubDirectionalLightPrefabXmlReader(ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]))

        with self.assertRaises(LightPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubConeLightPrefabXmlReader(unittest.TestCase):
    def test_cone_light_prefab_xml_reader_valid(self):
        xml = """
            <light type="ConeLight">
                <color type="HexColor">
                    <hexValue>CCAAFFEE</hexValue>
                </color>
                <position>
                    <x>1</x>
                    <y>2</y>
                </position>
                <directionDegree>10</directionDegree>
                <coneDegree>20</coneDegree>
                <distance>30</distance>
                <xRay>true</xRay>
            </light>
        """
        reader = SubConeLightPrefabXmlReader(
            ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]),
            PositionPrefabXmlReader()
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_color_prefab().get_hex_value(), "CCAAFFEE")
        self.assertEqual(prefab.get_position_prefab().get_x(), 1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2)
        self.assertEqual(prefab.get_direction_degree(), 10)
        self.assertEqual(prefab.get_cone_degree(), 20)
        self.assertEqual(prefab.get_distance(), 30)
        self.assertTrue(prefab.get_x_ray())

    def test_cone_light_prefab_xml_reader_invalid(self):
        xml = """
            <light type="ConeLight">
            </light>
        """
        reader = SubConeLightPrefabXmlReader(
            ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]),
            PositionPrefabXmlReader()
        )

        with self.assertRaises(LightPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestLightPrefabXmlReader(unittest.TestCase):
    def test_light_prefab_xml_reader_valid(self):
        xml = """
            <light type="PointLight">
                <color type="HexColor">
                    <hexValue>CCAAFFEE</hexValue>
                </color>
                <position>
                    <x>1</x>
                    <y>2</y>
                </position>
                <distance>10</distance>
                <xRay>false</xRay>
            </light>
        """
        reader = LightPrefabXmlReader([
            SubPointLightPrefabXmlReader(
                ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]),
                PositionPrefabXmlReader()
            )
        ])
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_color_prefab().get_hex_value(), "CCAAFFEE")
        self.assertEqual(prefab.get_position_prefab().get_x(), 1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2)
        self.assertEqual(prefab.get_distance(), 10)
        self.assertFalse(prefab.get_x_ray())

    def test_light_prefab_xml_reader_invalid(self):
        xml = """
            <light type="UnknownLight">
            </light>
        """
        reader = LightPrefabXmlReader([
            SubPointLightPrefabXmlReader(
                ColorPrefabXmlReader([SubHexColorPrefabXmlReader()]),
                PositionPrefabXmlReader()
            )
        ])

        with self.assertRaises(LightPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
