from lib.html.html import HtmlElement

ENTITY_CLASS_HTML_ATTRIBUTE = "doc-entity"


class EntityPrefabHtmlGenerator(object):
    def __init__(self, preload_data_html_generator, component_prefab_html_generator):
        self.preload_data_html_generator = preload_data_html_generator
        self.component_prefab_html_generator = component_prefab_html_generator

    def generate_html(self, entity_prefab, code):
        try:
            components = []
            for class_name, component in entity_prefab.get_all_components().items():
                components.append(self.component_prefab_html_generator.generate_html(component))

            return HtmlElement("div", attributes={
                "class": ENTITY_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Entity: {}".format(code)),
                HtmlElement("div", children=[
                    HtmlElement("p", "Components")
                ] + components)
            ])
        except Exception as e:
            raise EntityPrefabHtmlGenerationException(entity_prefab, e)


class EntityPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from entity prefab {}. Cause: {}."

    def __init__(self, entity_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(entity_prefab), cause))
