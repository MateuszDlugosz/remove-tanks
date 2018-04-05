from lib.html.html import HtmlElement


class ImageHtmlGenerator(object):
    def generate_html(self, src, alt=""):
        try:
            html = HtmlElement("img")
            html.set_attribute("src", src)
            html.set_attribute("alt", alt)

            return html
        except Exception as e:
            raise ImageHtmlGenerationException(e)


class ImageHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate image html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
