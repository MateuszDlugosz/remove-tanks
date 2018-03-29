import unittest

from lib.graphics.color.color_prefab import *


class TestColorPrefab(unittest.TestCase):
    def test_rgb_color_prefab_to_string(self):
        self.assertEqual(
            str(RgbColorPrefab(1, 2, 3)),
            "RgbColorPrefab(r=1.0, g=2.0, b=3.0)"
        )

    def test_rgba_color_prefab_to_string(self):
        self.assertEqual(
            str(RgbaColorPrefab(1, 2, 3, 4)),
            "RgbaColorPrefab(r=1.0, g=2.0, b=3.0, a=4.0)"
        )

    def test_hex_color_prefab_to_string(self):
        self.assertEqual(
            str(HexColorPrefab("CCAAFFEE")),
            "HexColorPrefab(hex_value=CCAAFFEE)"
        )


if __name__ == "__main__":
    unittest.main()
