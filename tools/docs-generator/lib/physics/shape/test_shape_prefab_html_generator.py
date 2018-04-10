import unittest

from lib.html.html import HtmlGenerator
from lib.physics.shape.shape_prefab import RectangleShapePrefab, CircleShapePrefab, PolygonShapePrefab, ChainShapePrefab
from lib.physics.shape.shape_prefab_html_generator import SubRectangleShapePrefabHtmlGenerator, \
    SubCircleShapePrefabHtmlGenerator, SubPolygonShapePrefabHtmlGenerator, SubChainShapePrefabHtmlGenerator, \
    ShapePrefabHtmlGenerator, ShapePrefabHtmlGenerationException
from lib.physics.shape.vertex_prefab import VertexPrefab
from lib.physics.shape.vertex_prefab_html_generator import VertexPrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSubRectangleShapePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RectangleShapePrefab(PositionPrefab(11.1, 2.33), 10, 20)
        html_generator = HtmlGenerator()
        shape_prefab_html_generator = SubRectangleShapePrefabHtmlGenerator(
            PositionPrefabHtmlGenerator()
        )
        print(html_generator.generate_html(shape_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", ""))
        self.assertEqual(
            '<divclass="doc-shape"><p>Rectangleshape</p><div><table><tr><th>Width</th><td>10.0</td></tr><tr><th>'
            'Height</th><td>20.0</td></tr></table><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th>'
            '<td>11.1</td></tr><tr><th>Y</th><td>2.33</td></tr></table></div></div></div></div>',
            html_generator.generate_html(shape_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCircleShapePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CircleShapePrefab(PositionPrefab(11.1, 2.33), 10)
        html_generator = HtmlGenerator()
        shape_prefab_html_generator = SubCircleShapePrefabHtmlGenerator(
            PositionPrefabHtmlGenerator()
        )

        self.assertEqual(
            '<divclass="doc-shape"><p>Circleshape</p><div><table><tr><th>Radius</th><td>10.0</td></tr></table>'
            '<divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>11.1</td></tr><tr><th>Y</th>'
            '<td>2.33</td></tr></table></div></div></div></div>',
            html_generator.generate_html(shape_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPolygonShapePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PolygonShapePrefab(PositionPrefab(1.1, 2.2), [VertexPrefab(0.9, 1.2), VertexPrefab(2.2, 2.3)])
        html_generator = HtmlGenerator()
        shape_prefab_html_generator = SubPolygonShapePrefabHtmlGenerator(
            PositionPrefabHtmlGenerator(), VertexPrefabHtmlGenerator()
        )

        self.assertEqual(
            '<divclass="doc-shape"><p>Polygonshape</p><div><divclass="doc-position"><p>Position</p><div><table><tr>'
            '<th>X</th><td>1.1</td></tr><tr><th>Y</th><td>2.2</td></tr></table></div></div><divclass="doc-vertices">'
            '<p>Vertices</p><div><divclass="doc-vertex"><p>Vertex</p><div><table><tr><th>X</th><td>0.9</td></tr>'
            '<tr><th>Y</th><td>1.2</td></tr></table></div></div><divclass="doc-vertex"><p>Vertex</p><div><table>'
            '<tr><th>X</th><td>2.2</td></tr><tr><th>Y</th><td>2.3</td></tr></table></div></div></div></div></div>'
            '</div>',
            html_generator.generate_html(shape_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubChainShapePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ChainShapePrefab(PositionPrefab(1.1, 2.2), [VertexPrefab(0.9, 1.2), VertexPrefab(2.2, 2.3)])
        html_generator = HtmlGenerator()
        shape_prefab_html_generator = SubChainShapePrefabHtmlGenerator(
            PositionPrefabHtmlGenerator(), VertexPrefabHtmlGenerator()
        )

        self.assertEqual(
            '<divclass="doc-shape"><p>Chainshape</p><div><divclass="doc-position"><p>Position</p><div><table><tr><th>'
            'X</th><td>1.1</td></tr><tr><th>Y</th><td>2.2</td></tr></table></div></div><divclass="doc-vertices"><p>'
            'Vertices</p><div><divclass="doc-vertex"><p>Vertex</p><div><table><tr><th>X</th><td>0.9</td></tr><tr><th>'
            'Y</th><td>1.2</td></tr></table></div></div><divclass="doc-vertex"><p>Vertex</p><div><table><tr><th>X'
            '</th><td>2.2</td></tr><tr><th>Y</th><td>2.3</td></tr></table></div></div></div></div></div></div>',
            html_generator.generate_html(shape_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestShapePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = RectangleShapePrefab(PositionPrefab(11.1, 2.33), 10, 20)
        html_generator = HtmlGenerator()
        shape_prefab_html_generator = ShapePrefabHtmlGenerator([
            SubRectangleShapePrefabHtmlGenerator(PositionPrefabHtmlGenerator())
        ])

        self.assertEqual(
            '<divclass="doc-shape"><p>Rectangleshape</p><div><table><tr><th>Width</th><td>10.0</td></tr><tr><th>'
            'Height</th><td>20.0</td></tr></table><divclass="doc-position"><p>Position</p><div><table><tr><th>X'
            '</th><td>11.1</td></tr><tr><th>Y</th><td>2.33</td></tr></table></div></div></div></div>',
            html_generator.generate_html(shape_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )

    def test_generate_invalid(self):
        prefab = RectangleShapePrefab(PositionPrefab(11.1, 2.33), 10, 20)
        shape_prefab_html_generator = ShapePrefabHtmlGenerator([])

        with self.assertRaises(ShapePrefabHtmlGenerationException):
            shape_prefab_html_generator.generate_html(prefab)


if __name__ == "__main__":
    unittest.main()
