import unittest

from lib.html.html import HtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestPositionPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PositionPrefab(0.1, 0.2)
        generator = HtmlGenerator()
        position_prefab_html_generator = PositionPrefabHtmlGenerator()

        self.assertEqual(
            generator.generate_html(position_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", ""),
            '<divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>0.1</td></tr><tr><th>Y</th><td>'
            '0.2</td></tr></table></div></div>'
        )


if __name__ == "__main__":
    unittest.main()
