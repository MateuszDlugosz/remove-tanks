import unittest

from lib.graphics.color.color_prefab import RgbColorPrefab, RgbaColorPrefab, HexColorPrefab
from lib.graphics.color.color_prefab_html_generator import SubRgbColorPrefabHtmlGenerator, \
    SubRgbaColorPrefabHtmlGenerator, SubHexColorPrefabHtmlGenerator
from lib.html.html import HtmlGenerator


class TestSubRgbColorPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RgbColorPrefab(1, 2, 3)
        html_generator = HtmlGenerator()
        color_prefab_html_generator = SubRgbColorPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-color"><p>Rgbcolor</p><div><table><tr><th>R</th><td>1.0</td></tr><tr><th>G</th><td>2.0'
            '</td></tr><tr><th>B</th><td>3.0</td></tr></table></div></div>',
            html_generator.generate_html(color_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRgbaColorPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RgbaColorPrefab(1, 2, 3, 4)
        html_generator = HtmlGenerator()
        color_prefab_html_generator = SubRgbaColorPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-color"><p>Rgbacolor</p><div><table><tr><th>R</th><td>1.0</td></tr><tr><th>G</th><td>2.0'
            '</td></tr><tr><th>B</th><td>3.0</td></tr><tr><th>A</th><td>4.0</td></tr></table></div></div>',
            html_generator.generate_html(color_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubHexColorPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HexColorPrefab("CCAAFFEE")
        html_generator = HtmlGenerator()
        color_prefab_html_generator = SubHexColorPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-color"><p>Hexcolor</p><div><table><tr><th>Hexvalue</th><td>CCAAFFEE</td></tr></table>'
            '</div></div>',
            html_generator.generate_html(color_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
