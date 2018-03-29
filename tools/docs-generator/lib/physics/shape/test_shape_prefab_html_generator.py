import  unittest

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

        self.assertEqual(
            '<divclass="doc-shape"><h6>Rectangleshape</h6><hr/><dl><dt>Width</dt><dd>10.0</dd><dt>Height</dt><dd>20.0'
            '</dd><dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>11.1</dd><dt>'
            'Y</dt><dd>2.33</dd></dl></div></dd></dl></div>',
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
            '<divclass="doc-shape"><h6>Circleshape</h6><hr/><dl><dt>Radius</dt><dd>10.0</dd><dt>Position</dt><dd>'
            '<divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>11.1</dd><dt>Y</dt><dd>2.33</dd></dl>'
            '</div></dd></dl></div>',
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
            '<divclass="doc-shape"><h6>Polygonshape</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position">'
            '<h6>Position</h6><hr/><dl><dt>X</dt><dd>1.1</dd><dt>Y</dt><dd>2.2</dd></dl></div></dd><dt>Vertices</dt>'
            '<dd><div><divclass="doc-vertex"><h6>Vertex</h6><hr/><dl><dt>X</dt><dd>0.9</dd><dt>Y</dt><dd>1.2</dd></dl>'
            '</div><divclass="doc-vertex"><h6>Vertex</h6><hr/><dl><dt>X</dt><dd>2.2</dd><dt>Y</dt><dd>2.3</dd></dl>'
            '</div></div></dd></dl></div>',
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
            '<divclass="doc-shape"><h6>Chainshape</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position"><h6>Position'
            '</h6><hr/><dl><dt>X</dt><dd>1.1</dd><dt>Y</dt><dd>2.2</dd></dl></div></dd><dt>Vertices</dt><dd><div>'
            '<divclass="doc-vertex"><h6>Vertex</h6><hr/><dl><dt>X</dt><dd>0.9</dd><dt>Y</dt><dd>1.2</dd></dl></div>'
            '<divclass="doc-vertex"><h6>Vertex</h6><hr/><dl><dt>X</dt><dd>2.2</dd><dt>Y</dt><dd>2.3</dd></dl></div>'
            '</div></dd></dl></div>',
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
            '<divclass="doc-shape"><h6>Rectangleshape</h6><hr/><dl><dt>Width</dt><dd>10.0</dd><dt>Height</dt><dd>20.0'
            '</dd><dt>Position</dt><dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>11.1</dd><dt>'
            'Y</dt><dd>2.33</dd></dl></div></dd></dl></div>',
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
