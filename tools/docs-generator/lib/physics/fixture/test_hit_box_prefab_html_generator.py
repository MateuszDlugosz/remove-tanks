import unittest

from lib.html.html import HtmlGenerator
from lib.physics.filter.filter_prefab import FilterPrefab
from lib.physics.filter.filter_prefab_html_generator import FilterPrefabHtmlGenerator
from lib.physics.fixture.fixture_prefab import FixturePrefab
from lib.physics.fixture.fixture_prefab_html_generator import FixturePrefabHtmlGenerator
from lib.physics.fixture.hit_box_prefab import HitBoxPrefab
from lib.physics.fixture.hit_box_prefab_html_generator import HitBoxPrefabHtmlGenerator
from lib.physics.shape.shape_prefab import RectangleShapePrefab
from lib.physics.shape.shape_prefab_html_generator import ShapePrefabHtmlGenerator, SubRectangleShapePrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestHitBoxPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = HitBoxPrefab("ID", FixturePrefab(
            FilterPrefab("category_bit", "mask_bit"),
            RectangleShapePrefab(PositionPrefab(1, 2), 20, 30),
            40, 50, 60, True
        ))
        html_generator = HtmlGenerator()
        prefab_html_generator = HitBoxPrefabHtmlGenerator(
            FixturePrefabHtmlGenerator(
                ShapePrefabHtmlGenerator([
                    SubRectangleShapePrefabHtmlGenerator(
                        PositionPrefabHtmlGenerator()
                    )
                ]),
                FilterPrefabHtmlGenerator()
            )
        )

        self.assertEqual(
            '<divclass="doc-hit-box"><h6>Hitbox</h6><hr/><dl><dt>Id</dt><dd>ID</dd><dt>Fixture</dt><dd>'
            '<divclass="doc-fixture"><h6>Fixture</h6><hr/><dl><dt>Shape</dt><dd><divclass="doc-shape"><h6>'
            'Rectangleshape</h6><hr/><dl><dt>Width</dt><dd>20.0</dd><dt>Height</dt><dd>30.0</dd><dt>Position</dt>'
            '<dd><divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>1.0</dd><dt>Y</dt><dd>2.0</dd></dl>'
            '</div></dd></dl></div></dd><dt>Filter</dt><dd><divclass="doc-filter"><h6>Filter</h6><hr/><dl><dt>'
            'Categorybit</dt><dd>category_bit</dd><dt>Maskbit</dt><dd>mask_bit</dd></dl></div></dd><dt>Density</dt>'
            '<dd>50.0</dd><dt>Restitution</dt><dd>40.0</dd><dt>Friction</dt><dd>60.0</dd><dt>Issensor</dt><dd>True'
            '</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
