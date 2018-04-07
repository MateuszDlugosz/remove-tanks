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
            '<divclass="doc-position"><div>Position</div><div><p><table><tr><th>X</th><th>Y</th></tr><tr><td>0.1</td>'
            '<td>0.2</td></tr></table></p></div></div>'
        )


if __name__ == "__main__":
    unittest.main()
