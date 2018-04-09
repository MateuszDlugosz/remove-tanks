import unittest

from lib.html.html import HtmlGenerator
from lib.level.preload.preload_data import PreloadData
from lib.level.preload.preload_data_html_generator import PreloadDataHtmlGenerator


class TestPreloadDataHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        preload_data = PreloadData(["EPC0", "EPC1"], ["AID0", "AID1", "AID2"])
        html_generator = HtmlGenerator()
        pd_html_generator = PreloadDataHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-preload-data"><p>Preloaddata</p><div><table><tr><th>Entityprefabcodes</th><td>'
            'EPC0,EPC1</td></tr><tr><th>Assetids</th><td>AID0,AID1,AID2</td></tr></table></div></div>',
            html_generator.generate_html(pd_html_generator.generate_html(preload_data))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
