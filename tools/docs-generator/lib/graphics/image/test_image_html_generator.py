import unittest

from lib.graphics.image.image_html_generator import ImageHtmlGenerator
from lib.html.html import HtmlGenerator


class TestImageHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        html_generator = HtmlGenerator()
        img_html_generator = ImageHtmlGenerator()
        self.assertEqual(
            html_generator.generate_html(img_html_generator.generate_html("test/src", "alternate"))
                .replace(" ", "").replace("\n", ""),
            '<imgsrc="test/src"alt="alternate"/>'
        )


if __name__ == "__main__":
    unittest.main()
