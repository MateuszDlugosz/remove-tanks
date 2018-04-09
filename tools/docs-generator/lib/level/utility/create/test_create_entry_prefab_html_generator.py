import unittest

from lib.html.html import HtmlGenerator
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab
from lib.level.utility.create.create_entry_prefab_html_generator import CreateEntryPrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestCreateEntryPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CreateEntryPrefab("CODE", PositionPrefab(1.1, 2.2))
        html_generator = HtmlGenerator()
        ce_html_generator = CreateEntryPrefabHtmlGenerator(PositionPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-create-entry"><p>Createentry</p><div><table><tr><th>Entityprefabcode</th><td>CODE</td>'
            '</tr></table></div><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>1.1</td></tr>'
            '<tr><th>Y</th><td>2.2</td></tr></table></div></div></div>',
            html_generator.generate_html(ce_html_generator.generate_html(prefab))
              .replace(" ", "").replace("\n", "")
        )



if __name__ == "__main__":
    unittest.main()
