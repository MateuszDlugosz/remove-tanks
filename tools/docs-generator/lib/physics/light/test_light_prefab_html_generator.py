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
            '<divclass="doc-light"><p>Directionallight</p><div><table><tr><th>XRay</th><td>True</td></tr><tr><th>'
            'Directiondegree</th><td>10.0</td></tr></table><divclass="doc-color"><h6>Hexcolor</h6><hr/><dl><dt>Hexvalue'
            '</dt><dd>CCAAFFEE</dd></dl></div></div></div>',
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
            '<divclass="doc-light"><p>Conelight</p><div><table><tr><th>XRay</th><td>False</td></tr><tr><th>'
            'Distance</th><td>100.0</td></tr><tr><th>Directiondegree</th><td>45.0</td></tr><tr><th>Conedegree'
            '</th><td>60.0</td></tr></table><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>'
            '10.0</td></tr><tr><th>Y</th><td>20.0</td></tr></table></div></div><divclass="doc-color"><h6>Hexcolor'
            '</h6><hr/><dl><dt>Hexvalue</dt><dd>CCAAFFEE</dd></dl></div></div></div>',
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
            '<divclass="doc-light"><p>Pointlight</p><div><table><tr><th>XRay</th><td>False</td></tr><tr><th>Distance'
            '</th><td>100.0</td></tr></table><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>'
            '10.0</td></tr><tr><th>Y</th><td>20.0</td></tr></table></div></div><divclass="doc-color"><h6>Hexcolor'
            '</h6><hr/><dl><dt>Hexvalue</dt><dd>CCAAFFEE</dd></dl></div></div></div>',
            html_generator.generate_html(prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
