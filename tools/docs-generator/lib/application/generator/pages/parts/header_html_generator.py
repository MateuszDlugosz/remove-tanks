from lib.html.html import HtmlElement

HEADER_NAV_CLASS_HTML_ATTRIBUTES = "navbar navbar-dark bg-dark fixed-top"
HEADER_NAV_BRAND_CLASS_HTML_ATTRIBUTES = "navbar-brand mb-0 h1"
HEADER_NAV_BRAND_TEXT = "RemoveTanks! Documentation"


class HeaderHtmlGenerator(object):
    def generate_html(self):
        try:
            return HtmlElement("nav", attributes={
                "class": HEADER_NAV_CLASS_HTML_ATTRIBUTES
            }, children=[
                HtmlElement("span", attributes={
                    "class": HEADER_NAV_BRAND_CLASS_HTML_ATTRIBUTES
                }, text=HEADER_NAV_BRAND_TEXT)
            ])
        except Exception as e:
            raise HeaderHtmlGenerationException(e)


class HeaderHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate header html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
