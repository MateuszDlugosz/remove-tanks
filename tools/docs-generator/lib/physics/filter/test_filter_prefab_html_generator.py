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
            '<divclass="doc-filter"><h6>Filter</h6><hr/><dl><dt>Categorybit</dt><dd>category_bit</dd><dt>Maskbit'
            '</dt><dd>mask_bit</dd></dl></div>',
            html_generator.generate_html(filter_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
