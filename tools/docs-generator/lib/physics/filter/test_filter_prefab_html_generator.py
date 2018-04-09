import unittest

from lib.html.html import HtmlGenerator
from lib.physics.filter.filter_prefab import FilterPrefab
from lib.physics.filter.filter_prefab_html_generator import FilterPrefabHtmlGenerator


class TestFilterPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = FilterPrefab("category_bit", "mask_bit")
        html_generator = HtmlGenerator()
        filter_prefab_html_generator = FilterPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-filter"><p>Filter</p><div><table><tr><th>Categorybit</th><td>category_bit</td></tr><tr>'
            '<th>Maskbit</th><td>mask_bit</td></tr></table></div></div>',
            html_generator.generate_html(filter_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
