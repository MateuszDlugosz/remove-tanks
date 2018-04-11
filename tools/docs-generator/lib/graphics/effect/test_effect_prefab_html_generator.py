import unittest

from lib.graphics.color.color_prefab import HexColorPrefab
from lib.graphics.color.color_prefab_html_generator import ColorPrefabHtmlGenerator, SubHexColorPrefabHtmlGenerator
from lib.graphics.effect.effect_prefab import AlphaEffectPrefab, TintEffectPrefab, ShaderEffectPrefab
from lib.graphics.effect.effect_prefab_html_generator import SubAlphaEffectPrefabHtmlGenerator, \
    SubTintEffectPrefabHtmlGenerator, SubShaderEffectPrefabHtmlGenerator, EffectPrefabHtmlGenerator
from lib.graphics.shader.shader_program_prefab import ShaderProgramPrefab
from lib.graphics.shader.shader_program_prefab_html_generator import ShaderProgramPrefabHtmlGenerator
from lib.html.html import HtmlGenerator


class TestSubAlphaEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AlphaEffectPrefab(1.2)
        html_generator = HtmlGenerator()
        aep_html_generator = SubAlphaEffectPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-effect"><p>Alphaeffect</p><div><table><tr><th>Alphavalue</th><td>1</td></tr>'
            '</table></div></div>',
            html_generator.generate_html(aep_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubTintEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = TintEffectPrefab(HexColorPrefab("CCAAFFEE"))
        html_generator = HtmlGenerator()
        tep_html_generator = SubTintEffectPrefabHtmlGenerator(
            ColorPrefabHtmlGenerator([SubHexColorPrefabHtmlGenerator()]))

        self.assertEqual(
            '<divclass="doc-effect"><p>Tinteffect</p><divclass="doc-color"><p>Hexcolor</p><div><table><tr><th>Hexvalue'
            '</th><td>CCAAFFEE</td></tr></table></div></div></div>',
            html_generator.generate_html(tep_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubShaderEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ShaderEffectPrefab(ShaderProgramPrefab("vertex", "fragment"))
        html_generator = HtmlGenerator()
        sep_html_generator = SubShaderEffectPrefabHtmlGenerator(ShaderProgramPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-effect"><p>Shadereffect</p><divclass="doc-shader-program"><p>Shaderprogram</p><div><table>'
            '<tr><th>Fragmentshaderfilename</th><td>fragment</td></tr><tr><th>Vertexshaderfilename</th><td>vertex</td>'
            '</tr></table></div></div></div>',
            html_generator.generate_html(sep_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AlphaEffectPrefab(1.2)
        html_generator = HtmlGenerator()
        effect_html_generator = EffectPrefabHtmlGenerator([SubAlphaEffectPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-effect"><p>Alphaeffect</p><div><table><tr><th>Alphavalue</th><td>1</td></tr>'
            '</table></div></div>',
            html_generator.generate_html(effect_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
