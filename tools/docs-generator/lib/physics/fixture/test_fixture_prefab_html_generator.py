import unittest

from lib.html.html import HtmlGenerator
from lib.physics.filter.filter_prefab import FilterPrefab
from lib.physics.filter.filter_prefab_html_generator import FilterPrefabHtmlGenerator
from lib.physics.fixture.fixture_prefab import FixturePrefab
from lib.physics.fixture.fixture_prefab_html_generator import FixturePrefabHtmlGenerator
from lib.physics.shape.shape_prefab import RectangleShapePrefab
from lib.physics.shape.shape_prefab_html_generator import ShapePrefabHtmlGenerator, SubRectangleShapePrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestFixturePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = FixturePrefab(
            FilterPrefab("category_bit", "mask_bit"),
            RectangleShapePrefab(PositionPrefab(1.1, 2.2), 10, 20),
            30, 40, 50, False
        )
        html_generator = HtmlGenerator()
        fixture_prefab_html_generator = FixturePrefabHtmlGenerator(
            ShapePrefabHtmlGenerator([SubRectangleShapePrefabHtmlGenerator(PositionPrefabHtmlGenerator())]),
            FilterPrefabHtmlGenerator()
        )

        self.assertEqual(
            '<divclass="doc-fixture"><h6>Fixture</h6><hr/><dl><dt>Shape</dt><dd><divclass="doc-shape"><h6>Rectangleshape</h6>'
            '<hr/><dl><dt>Width</dt><dd>10.0</dd><dt>Height</dt><dd>20.0</dd><dt>Position</dt><dd>'
            '<divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>1.1</dd><dt>Y</dt><dd>2.2</dd></dl></div>'
            '</dd></dl></div></dd><dt>Filter</dt><dd><divclass="doc-filter"><h6>Filter</h6><hr/><dl><dt>Categorybit</dt>'
            '<dd>category_bit</dd><dt>Maskbit</dt><dd>mask_bit</dd></dl></div></dd><dt>Density</dt><dd>40.0</dd><dt>'
            'Restitution</dt><dd>30.0</dd><dt>Friction</dt><dd>50.0</dd><dt>Issensor</dt><dd>False</dd></dl></div>',
            html_generator.generate_html(fixture_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
