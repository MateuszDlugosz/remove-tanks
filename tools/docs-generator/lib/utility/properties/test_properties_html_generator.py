import unittest

from lib.html.html import HtmlGenerator
from lib.utility.properties.properties import Properties
from lib.utility.properties.properties_html_generator import PropertiesHtmlGenerator


class TestPropertiesHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        properties = Properties()
        properties.set_property("keyA", "valA")
        properties.set_property("keyB", "valB")

        html_generator = HtmlGenerator()
        properties_html_generator = PropertiesHtmlGenerator()

        self.assertEqual(
            '<divid="doc-properties"><h6>Properties</h6><hr/><dl><dt>keyA</dt><dd>valA</dd>'
            '<dt>keyB</dt><dd>valB</dd></dl></div>',
            html_generator.generate_html(properties_html_generator.generate_html(properties))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
