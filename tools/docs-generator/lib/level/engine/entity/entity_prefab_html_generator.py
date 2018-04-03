from lib.html.html import HtmlElement

ENTITY_CLASS_HTML_ATTRIBUTE = "doc-entity"


class EntityPrefabHtmlGenerator(object):
    def __init__(self, preload_data_html_generator, component_prefab_html_generator):
        self.preload_data_html_generator = preload_data_html_generator
        self.component_prefab_html_generator = component_prefab_html_generator

    def generate_html(self, entity_prefab, code):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", ENTITY_CLASS_HTML_ATTRIBUTE)
            html.add_child(HtmlElement("h3", f"{code} Entity prefab"))
            html.add_child(HtmlElement("hr"))

            pd_div = HtmlElement("h4", "Preload data")
            pd_div.add_child(HtmlElement("hr"))
            pd_div.add_child(self.preload_data_html_generator.generate_html(entity_prefab.get_preload_data()))

            c_div = HtmlElement("h4", "Components")
            c_div.add_child(HtmlElement("hr"))

            for key, value in entity_prefab.get_all_components().items():
                c_div.add_child(self.component_prefab_html_generator.generate_html(value))

            html.add_child(pd_div)
            html.add_child(c_div)

            return html
        except Exception as e:
            raise EntityPrefabHtmlGenerationException(entity_prefab, e)


class EntityPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from entity prefab {}. Cause: {}."

    def __init__(self, entity_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(entity_prefab), cause))
