import unittest

from lib.graphics.color.color_prefab import HexColorPrefab
from lib.graphics.color.color_prefab_html_generator import ColorPrefabHtmlGenerator, SubHexColorPrefabHtmlGenerator
from lib.html.html import HtmlGenerator
from lib.physics.light.light_prefab import DirectionalLightPrefab, ConeLightPrefab, PointLightPrefab
from lib.physics.light.light_prefab_html_generator import SubDirectionalLightPrefabHtmlGenerator, \
    SubConeLightPrefabHtmlGenerator, SubPointLightPrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSubDirectionalLightPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DirectionalLightPrefab(HexColorPrefab("CCAAFFEE"), True, 10)
        html_generator = HtmlGenerator()
        prefab_html_generator = SubDirectionalLightPrefabHtmlGenerator(
            ColorPrefabHtmlGenerator([
                SubHexColorPrefabHtmlGenerator()
            ])
        )

        self.assertEqual(
            '<divclass="doc-light"><h6>Directionallight</h6><hr/><dl><dt>XRay</dt><dd>True</dd><dt>Color</dt><dd>'
            '<divclass="doc-color"><h6>Hexcolor</h6><hr/><dl><dt>Hexvalue</dt><dd>CCAAFFEE</dd></dl></div></dd><dt>'
            'Directiondegree</dt><dd>10.0</dd></dl></div>',
            html_generator.generate_html(prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubConeLightPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ConeLightPrefab(HexColorPrefab("CCAAFFEE"), False, PositionPrefab(10, 20), 100, 45, 60)
        html_generator = HtmlGenerator()
        prefab_html_generator = SubConeLightPrefabHtmlGenerator(
            ColorPrefabHtmlGenerator([
                SubHexColorPrefabHtmlGenerator()
            ]),
            PositionPrefabHtmlGenerator()
        )

        self.assertEqual(
            '<divclass="doc-light"><h6>Conelight</h6><hr/><dl><dt>XRay</dt><dd>False</dd><dt>Color</dt><dd>'
            '<divclass="doc-color"><h6>Hexcolor</h6><hr/><dl><dt>Hexvalue</dt><dd>CCAAFFEE</dd></dl></div></dd>'
            '<dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>10.0</dd><dt>'
            'Y</dt><dd>20.0</dd></dl></div></dd><dt>Distance</dt><dd>100.0</dd><dt>Conedegree</dt><dd>60.0</dd>'
            '<dt>Directiondegree</dt><dd>45.0</dd></dl></div>',
            html_generator.generate_html(prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPointLightPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PointLightPrefab(HexColorPrefab("CCAAFFEE"), False, PositionPrefab(10, 20), 100)
        html_generator = HtmlGenerator()
        prefab_html_generator = SubPointLightPrefabHtmlGenerator(
            ColorPrefabHtmlGenerator([
                SubHexColorPrefabHtmlGenerator()
            ]),
            PositionPrefabHtmlGenerator()
        )

        self.assertEqual(
            '<divclass="doc-light"><h6>Pointlight</h6><hr/><dl><dt>XRay</dt><dd>False</dd><dt>Color</dt><dd>'
            '<divclass="doc-color"><h6>Hexcolor</h6><hr/><dl><dt>Hexvalue</dt><dd>CCAAFFEE</dd></dl></div></dd>'
            '<dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>10.0</dd><dt>'
            'Y</dt><dd>20.0</dd></dl></div></dd><dt>Distance</dt><dd>100.0</dd></dl></div>',
            html_generator.generate_html(prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
