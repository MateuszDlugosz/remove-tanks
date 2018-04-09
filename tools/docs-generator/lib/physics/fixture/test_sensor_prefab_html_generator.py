import unittest

from lib.html.html import HtmlGenerator
from lib.physics.filter.filter_prefab import FilterPrefab
from lib.physics.filter.filter_prefab_html_generator import FilterPrefabHtmlGenerator
from lib.physics.fixture.fixture_prefab import FixturePrefab
from lib.physics.fixture.fixture_prefab_html_generator import FixturePrefabHtmlGenerator
from lib.physics.fixture.sensor_prefab import SensorPrefab
from lib.physics.fixture.sensor_prefab_html_generator import SensorPrefabHtmlGenerator
from lib.physics.shape.shape_prefab import RectangleShapePrefab
from lib.physics.shape.shape_prefab_html_generator import ShapePrefabHtmlGenerator, SubRectangleShapePrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSensorPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SensorPrefab("ID", FixturePrefab(
            FilterPrefab("category_bit", "mask_bit"),
            RectangleShapePrefab(PositionPrefab(1, 2), 20, 30),
            40, 50, 60, True
        ))
        html_generator = HtmlGenerator()
        prefab_html_generator = SensorPrefabHtmlGenerator(
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
            '<divclass="doc-sensor"><p>Sensor</p><div><table><tr><th>Id</th><td>ID</td></tr></table>'
            '<divclass="doc-fixture"><p>Fixture</p><div><table><tr><th>Density</th><td>50.0</td></tr><tr>'
            '<th>Restitution</th><td>40.0</td></tr><tr><th>Friction</th><td>60.0</td></tr></table>'
            '<divclass="doc-filter"><p>Filter</p><div><table><tr><th>Categorybit</th><td>category_bit</td></tr><tr>'
            '<th>Maskbit</th><td>mask_bit</td></tr></table></div></div><divclass="doc-shape"><p>Rectangleshape</p>'
            '<div><table><tr><th>Width</th><td>20.0</td></tr><tr><th>Height</th><td>30.0</td></tr></table>'
            '<divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>1.0</td></tr><tr><th>Y</th><td>'
            '2.0</td></tr></table></div></div></div></div></div></div></div></div>',
            html_generator.generate_html(prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
