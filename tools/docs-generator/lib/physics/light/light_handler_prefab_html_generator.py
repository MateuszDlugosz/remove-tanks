from lib.html.html import HtmlElement

LIGHT_HANDLER_HTML_ID_ATTRIBUTE = "doc-light-handler"


class LightHandlerPrefabHtmlGenerator(object):
    def __init__(self, light_prefab_html_generator):
        self.light_prefab_html_generator = light_prefab_html_generator

    def generate_html(self, light_handler_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": LIGHT_HANDLER_HTML_ID_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Light handler"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Id"),
                            HtmlElement("td", light_handler_prefab.get_id())
                        ])
                    ])
                ]),
                self.light_prefab_html_generator.generate_html(light_handler_prefab.get_light_prefab())
            ])
        except Exception as e:
            raise LightHandlerPrefabHtmlGenerationException(light_handler_prefab, e)


class LightHandlerPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from light handler prefab {}. Cause: {}."

    def __init__(self, light_handler_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(light_handler_prefab), cause))
