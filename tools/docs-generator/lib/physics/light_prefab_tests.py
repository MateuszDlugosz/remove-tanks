import unittest

from lib.graphics.color_prefab import *
from lib.physics.light_prefab import *
from lib.utility.surface.position.position_prefab import *


class TestLightPrefab(unittest.TestCase):
    def test_point_light_prefab_to_string(self):
        self.assertEqual(
            str(PointLightPrefab(RgbColorPrefab(1, 2, 3), True, PositionPrefab(1, 2), 10)),
            "PointLightPrefab(color_prefab=RgbColorPrefab(r=1.0, g=2.0, b=3.0), x_ray=True, "
            "position_prefab=PositionPrefab(x=1.0, y=2.0), distance=10.0)"
        )

    def test_directional_light_prefab_to_string(self):
        self.assertEqual(
            str(DirectionalLightPrefab(HexColorPrefab("CCAAFFEE"), False, 3)),
            "DirectionalLightPrefab(color_prefab=HexColorPrefab(hex_value=CCAAFFEE), x_ray=False, direction_degree=3.0)"
        )

    def test_cone_light_prefab_to_string(self):
        self.assertEqual(
            str(ConeLightPrefab(HexColorPrefab("CCAAFFEE"), True, PositionPrefab(1, 2), 10, 20, 30)),
            "ConeLightPrefab(color_prefab=HexColorPrefab(hex_value=CCAAFFEE), x_ray=True, "
            "position_prefab=PositionPrefab(x=1.0, y=2.0), distance=10.0, direction_degree=20.0, cone_degree=30.0)"
        )


class TestLightPrefabXmlReader(unittest.TestCase):
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
