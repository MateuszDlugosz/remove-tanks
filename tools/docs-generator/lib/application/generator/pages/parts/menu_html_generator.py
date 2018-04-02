from lib.html.html import HtmlElement


class MenuHtmlGenerator(object):
    def generate_html(self):
        try:
            html = HtmlElement("div")
            html.add_child(HtmlElement("h2", "Menu"))

            return html
        except Exception as e:
            raise MenuHtmlGenerationException(e)


class MenuHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate menu html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
