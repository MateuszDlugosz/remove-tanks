from lib.html.html import HtmlElement

MENU_CLASS_HTML_ATTRIBUTES = "doc-menu card"
MENU_BODY_CLASS_HTML_ATTRIBUTES = "doc-menu-body card-body"
MENU_TITLE_CLASS_HTML_ATTRIBUTES = "doc-menu-title card-title text-center"
MENU_TITLE_TEXT = "Table of Contents"

class MenuHtmlGenerator(object):
    def generate_html(self, contents):
        try:
            return HtmlElement("div", attributes={
                "class": MENU_CLASS_HTML_ATTRIBUTES
            }, children=[
                HtmlElement("div", attributes={
                    "class": MENU_BODY_CLASS_HTML_ATTRIBUTES
                }, children=[
                    HtmlElement("h5", attributes={
                        "class": MENU_TITLE_CLASS_HTML_ATTRIBUTES
                    }, text=MENU_TITLE_TEXT),
                    contents
                ])
            ])
        except Exception as e:
            raise MenuHtmlGenerationException(e)


class MenuHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate menu html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
