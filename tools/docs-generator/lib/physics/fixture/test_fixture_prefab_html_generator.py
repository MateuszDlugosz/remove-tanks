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
            '<divclass="doc-fixture"><p>Fixture</p><div><table><tr><th>Density</th><td>40.0</td></tr><tr><th>'
            'Restitution</th><td>30.0</td></tr><tr><th>Friction</th><td>50.0</td></tr></table><divclass="doc-filter">'
            '<p>Filter</p><div><table><tr><th>Categorybit</th><td>category_bit</td></tr><tr><th>Maskbit</th><td>'
            'mask_bit</td></tr></table></div></div><divclass="doc-shape"><p>Rectangleshape</p><div><table><tr>'
            '<th>Width</th><td>10.0</td></tr><tr><th>Height</th><td>20.0</td></tr></table><divclass="doc-position">'
            '<p>Position</p><div><table><tr><th>X</th><td>1.1</td></tr><tr><th>Y</th><td>2.2</td></tr></table></div>'
            '</div></div></div></div></div>',
            html_generator.generate_html(fixture_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
