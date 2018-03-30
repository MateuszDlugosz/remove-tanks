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
            '<divclass="doc-create-entry"><h6>Createentry</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position">'
            '<h6>Position</h6><hr/><dl><dt>X</dt><dd>1.1</dd><dt>Y</dt><dd>2.2</dd></dl></div></dd><dt>Entityprefabcode'
            '</dt><dd>CODE</dd></dl></div>',
            html_generator.generate_html(ce_html_generator.generate_html(prefab))
              .replace(" ", "").replace("\n", "")
        )



if __name__ == "__main__":
    unittest.main()
