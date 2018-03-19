import unittest

from lib.graphics.color_prefab import *


class TestColorPrefab(unittest.TestCase):
    def test_rgb_color_prefab_to_string(self):
        self.assertEquals(
            str(RgbColorPrefab(1, 2, 3)),
            "RgbColorPrefab(r=1.0, g=2.0, b=3.0)"
        )

    def test_rgba_color_prefab_to_string(self):
        self.assertEquals(
            str(RgbaColorPrefab(1, 2, 3, 4)),
            "RgbaColorPrefab(r=1.0, g=2.0, b=3.0, a=4.0)"
        )

    def test_hex_color_prefab_to_string(self):
        self.assertEquals(
            str(HexColorPrefab("CCAAFFEE")),
            "HexColorPrefab(hex_value=CCAAFFEE)"
        )


class TestColorPrefabXmlReader(unittest.TestCase):
    def test_rgb_color_prefab_xml_reader_valid(self):
        xml = """
            <color type="RgbColor">
                <r>1</r>
                <g>2</g>
                <b>3</b>
            </color>
        """
        reader = SubRgbColorPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEquals(prefab.get_r(), 1)
        self.assertEquals(prefab.get_g(), 2)
        self.assertEquals(prefab.get_b(), 3)

    def test_rgb_color_prefab_xml_reader_invalid(self):
        xml = """
            <color></color>
        """
        reader = SubRgbColorPrefabXmlReader()

        with self.assertRaises(ColorPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_rgba_color_prefab_xml_reader_valid(self):
        xml = """
            <color type="RgbaColor">
                <r>1</r>
                <g>2</g>
                <b>3</b>
                <a>4</a>
            </color>
        """
        reader = SubRgbaColorPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEquals(prefab.get_r(), 1)
        self.assertEquals(prefab.get_g(), 2)
        self.assertEquals(prefab.get_b(), 3)
        self.assertEquals(prefab.get_a(), 4)

    def test_rgba_color_prefab_xml_reader_invalid(self):
        xml = """
            <color></color>
        """
        reader = SubRgbaColorPrefabXmlReader()

        with self.assertRaises(ColorPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_hex_color_prefab_xml_reader_valid(self):
        xml = """
            <color type="HexColor">
                <hexValue>CCAAFFEE</hexValue>
            </color>
        """
        reader = SubHexColorPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEquals(prefab.get_hex_value(), "CCAAFFEE")

    def test_hex_color_prefab_xml_reader_invalid(self):
        xml = """
            <color></color>
        """
        reader = SubHexColorPrefabXmlReader()

        with self.assertRaises(ColorPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_color_prefab_xml_reader_valid(self):
        xml = """
            <color type="HexColor">
                <hexValue>CCAAFFEE</hexValue>
            </color>
        """
        reader = ColorPrefabXmlReader([SubHexColorPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_hex_value(), "CCAAFFEE")

    def test_color_prefab_xml_reader_invalid(self):
        xml = """
            <color type="UnknownColorType" />
        """
        reader = ColorPrefabXmlReader([SubHexColorPrefabXmlReader()])

        with self.assertRaises(ColorPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
