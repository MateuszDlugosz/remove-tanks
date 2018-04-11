import unittest

from lib.graphics.color.color_prefab import HexColorPrefab
from lib.graphics.color.color_prefab_html_generator import ColorPrefabHtmlGenerator, SubHexColorPrefabHtmlGenerator
from lib.html.html import HtmlGenerator
from lib.physics.light.light_handler_prefab import LightHandlerPrefab
from lib.physics.light.light_handler_prefab_html_generator import LightHandlerPrefabHtmlGenerator, \
    LightHandlerPrefabHtmlGenerationException
from lib.physics.light.light_prefab import DirectionalLightPrefab
from lib.physics.light.light_prefab_html_generator import LightPrefabHtmlGenerator, \
    SubDirectionalLightPrefabHtmlGenerator


class TestLightHandlerPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = LightHandlerPrefab("ID", DirectionalLightPrefab(HexColorPrefab("CCAAFFEE"), True, 100))
        html_generator = HtmlGenerator()
        lh_html_generator = LightHandlerPrefabHtmlGenerator(
            LightPrefabHtmlGenerator([
                SubDirectionalLightPrefabHtmlGenerator(
                    ColorPrefabHtmlGenerator([
                        SubHexColorPrefabHtmlGenerator()
                    ])
                )
            ])
        )

        self.assertEqual(
            '<divclass="doc-light-handler"><p>Lighthandler</p><div><table><tr><th>Id</th><td>ID</td></tr></table>'
            '</div><divclass="doc-light"><p>Directionallight</p><div><table><tr><th>XRay</th><td>True</td></tr><tr>'
            '<th>Directiondegree</th><td>100.0</td></tr></table></div><divclass="doc-color"><p>Hexcolor</p><div><table>'
            '<tr><th>Hexvalue</th><td>CCAAFFEE</td></tr></table></div></div></div></div>',
            html_generator.generate_html(lh_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )

    def test_generate_html_invalid(self):
        prefab = LightHandlerPrefab("ID", DirectionalLightPrefab(HexColorPrefab("CCAAFFEE"), True, 100))
        lh_html_generator = LightHandlerPrefabHtmlGenerator(LightPrefabHtmlGenerator([]))

        with self.assertRaises(LightHandlerPrefabHtmlGenerationException):
            lh_html_generator.generate_html(prefab)


if __name__ == "__main__":
    unittest.main()
