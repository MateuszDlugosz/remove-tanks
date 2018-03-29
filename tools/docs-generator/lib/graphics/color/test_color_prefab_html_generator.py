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
            '<divclass="doc-color"><h6>Rgbcolor</h6><hr/><dl><dt>R</dt><dd>1.0</dd><dt>G</dt><dd>2.0</dd><dt>B'
            '</dt><dd>3.0</dd></dl></div>',
            html_generator.generate_html(color_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRgbaColorPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RgbaColorPrefab(1, 2, 3, 4)
        html_generator = HtmlGenerator()
        color_prefab_html_generator = SubRgbaColorPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-color"><h6>Rgbacolor</h6><hr/><dl><dt>R</dt><dd>1.0</dd><dt>G</dt><dd>2.0</dd><dt>B'
            '</dt><dd>3.0</dd><dt>A</dt><dd>4.0</dd></dl></div>',
            html_generator.generate_html(color_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubHexColorPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HexColorPrefab("CCAAFFEE")
        html_generator = HtmlGenerator()
        color_prefab_html_generator = SubHexColorPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-color"><h6>Hexcolor</h6><hr/><dl><dt>Hexvalue</dt><dd>CCAAFFEE</dd></dl></div>',
            html_generator.generate_html(color_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
