from lib.html.html import HtmlElement

PROPERTIES_HTML_ID_ATTRIBUTE = "doc-properties"


class PropertiesHtmlGenerator(object):
    def generate_html(self, properties):
        try:
            html = HtmlElement("div")
            html.set_attribute("id", PROPERTIES_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Properties"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")

            for key, value in properties.get_properties().items():
                dt = HtmlElement("dt", key)
                dd = HtmlElement("dd", value)
                dl.add_child(dt)
                dl.add_child(dd)

            html.add_child(dl)

            return html
        except Exception as e:
            raise PropertiesHtmlGenerationException(properties, e)


class PropertiesHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from properties {}. Cause: {}."

    def __init__(self, properties, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(properties), cause))
