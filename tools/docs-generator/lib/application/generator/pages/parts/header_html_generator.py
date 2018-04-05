from lib.html.html import HtmlElement


class HeaderHtmlGenerator(object):
    def generate_html(self):
        try:
            html = HtmlElement("div")
            html.add_child(HtmlElement("h1", "RemoveTanks! Documentation"))
            
            return html
        except Exception as e:
            raise HeaderHtmlGenerationException(e)


class HeaderHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate header html. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
