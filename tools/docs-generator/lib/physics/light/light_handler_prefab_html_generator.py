from lib.html.html import HtmlElement

LIGHT_HANDLER_HTML_ID_ATTRIBUTE = "doc-light-handler"


class LightHandlerPrefabHtmlGenerator(object):
    def __init__(self, light_prefab_html_generator):
        self.light_prefab_html_generator = light_prefab_html_generator

    def generate_html(self, light_handler_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", LIGHT_HANDLER_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Light handler"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Id"))
            dl.add_child(HtmlElement("dd", light_handler_prefab.get_id()))

            dl.add_child(HtmlElement("dt", "Light"))
            dd_light = HtmlElement("dd")
            dd_light.add_child(self.light_prefab_html_generator.generate_html(
                light_handler_prefab.get_light_prefab()
            ))
            dl.add_child(dd_light)

            html.add_child(dl)

            return html
        except Exception as e:
            raise LightHandlerPrefabHtmlGenerationException(light_handler_prefab, e)


class LightHandlerPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from light handler prefab {}. Cause: {}."

    def __init__(self, light_handler_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(light_handler_prefab), cause))
