import unittest

from lib.html.html import HtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestPositionPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        generator = HtmlGenerator()
        position_prefab_html_generator = PositionPrefabHtmlGenerator()
        prefab = PositionPrefab(0.1, 0.2)

        self.assertEqual(
            generator.generate_html(position_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", ""),
            '<divclass="doc-position"><h6>Position</h6><hr/><dl><dt>X</dt><dd>0.1</dd><dt>Y</dt><dd>0.2</dd></dl></div>'
        )


if __name__ == "__main__":
    unittest.main()
