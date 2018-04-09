from lib.html.html import HtmlElement

PROPERTIES_HTML_CLASS_ATTRIBUTE = "doc-properties"


class PropertiesHtmlGenerator(object):
    def generate_html(self, properties):
        try:
            properties_table = HtmlElement("table")

            for key, value in properties.get_properties().items():
                properties_table.add_child(HtmlElement("tr", children=[
                    HtmlElement("th", key),
                    HtmlElement("td", value)
                ]))

            return HtmlElement("div", attributes={
                "class": PROPERTIES_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Properties"),
                HtmlElement("div", children=[
                    properties_table
                ])
            ])
        except Exception as e:
            raise PropertiesHtmlGenerationException(properties, e)


class PropertiesHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from properties {}. Cause: {}."

    def __init__(self, properties, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(properties), cause))
