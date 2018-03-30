import unittest

from lib.html.html import HtmlGenerator
from lib.level.preload.preload_data import PreloadData
from lib.level.preload.preload_data_html_generator import PreloadDataHtmlGenerator


class TestPreloadDataHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        preload_data = PreloadData(["EPC0", "EPC1"], ["AID0", "AID1", "AID2"])
        html_generator = HtmlGenerator()
        pd_html_generator = PreloadDataHtmlGenerator()

        print(html_generator.generate_html(pd_html_generator.generate_html(preload_data)))


if __name__ == "__main__":
    unittest.main()
