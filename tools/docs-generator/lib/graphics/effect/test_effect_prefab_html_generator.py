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
            '<divclass="doc-effect"><h6>Alphaeffect</h6><hr/><dl><dt>Alphavalue</dt><dd>1</dd></dl></div>',
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
            '<divclass="doc-effect"><h6>Tinteffect</h6><hr/><dl><dt>Color</dt><dd><divclass="doc-color"><h6>'
            'Hexcolor</h6><hr/><dl><dt>Hexvalue</dt><dd>CCAAFFEE</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(tep_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubShaderEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ShaderEffectPrefab(ShaderProgramPrefab("vertex", "fragment"))
        html_generator = HtmlGenerator()
        sep_html_generator = SubShaderEffectPrefabHtmlGenerator(ShaderProgramPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-effect"><h6>Shadereffect</h6><hr/><dl><dt>Shaderprogram</dt><dd>'
            '<divclass="doc-shader-program"><h6>Shaderprogram</h6><hr/><dl><dt>Fragmentshaderfilename</dt><dd>'
            'fragment</dd><dt>Vertexshaderfilename</dt><dd>vertex</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sep_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AlphaEffectPrefab(1.2)
        html_generator = HtmlGenerator()
        effect_html_generator = EffectPrefabHtmlGenerator([SubAlphaEffectPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-effect"><h6>Alphaeffect</h6><hr/><dl><dt>Alphavalue</dt><dd>1</dd></dl></div>',
            html_generator.generate_html(effect_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
