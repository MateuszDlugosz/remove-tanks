import unittest

from lib.html.html import HtmlGenerator
from lib.physics.shape.vertex_prefab import VertexPrefab
from lib.physics.shape.vertex_prefab_html_generator import VertexPrefabHtmlGenerator


class TestVertexPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = VertexPrefab(1, 2.2)
        html_generator = HtmlGenerator()
        vertex_prefab_html_generator = VertexPrefabHtmlGenerator()

        self.assertEqual(
            '<divid="doc-vertex"><h6>Vertex</h6><hr/><dl><dt>X</dt><dd>1.0</dd><dt>Y</dt><dd>2.2</dd></dl></div>',
            html_generator.generate_html(vertex_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
