import unittest

from lib.html.html import HtmlGenerator
from lib.physics.shape.vertex_prefab import VertexPrefab
from lib.physics.shape.vertex_prefab_html_generator import VertexPrefabHtmlGenerator


class TestVertexPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefabs = [VertexPrefab(1, 2.2), VertexPrefab(2.5, 3.2)]
        html_generator = HtmlGenerator()
        vertex_prefab_html_generator = VertexPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-vertices"><p>Vertices</p><div><divclass="doc-vertex"><p>Vertex</p><div><table><tr><th>X'
            '</th><td>1.0</td></tr><tr><th>Y</th><td>2.2</td></tr></table></div></div><divclass="doc-vertex"><p>'
            'Vertex</p><div><table><tr><th>X</th><td>2.5</td></tr><tr><th>Y</th><td>3.2</td></tr></table></div>'
            '</div></div></div>',
            html_generator.generate_html(vertex_prefab_html_generator.generate_html(prefabs))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
