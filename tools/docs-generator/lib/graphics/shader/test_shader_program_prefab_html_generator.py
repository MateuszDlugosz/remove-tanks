import unittest

from lib.graphics.shader.shader_program_prefab import ShaderProgramPrefab
from lib.graphics.shader.shader_program_prefab_html_generator import ShaderProgramPrefabHtmlGenerator
from lib.html.html import HtmlGenerator


class TestShaderProgramPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ShaderProgramPrefab("vertex", "fragment")
        html_generator = HtmlGenerator()
        spp_html_generator = ShaderProgramPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-shader-program"><p>Shaderprogram</p><div><table><tr><th>Fragmentshaderfilename</th>'
            '<td>fragment</td></tr><tr><th>Vertexshaderfilename</th><td>vertex</td></tr></table></div></div>',
            html_generator.generate_html(spp_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
