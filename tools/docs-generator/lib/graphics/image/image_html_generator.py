from lib.html.html import HtmlElement

IMAGE_CLASS_HTML_ATTRIBUTE = "doc-image"


class ImageHtmlGenerator(object):
    def generate_html(self, src, alt=""):
        try:
            return HtmlElement("img", attributes={
                "class": IMAGE_CLASS_HTML_ATTRIBUTE,
                "src": src,
                "alt": alt
            })
        except Exception as e:
            raise ImageHtmlGenerationException(e)


class ImageHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate image html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
