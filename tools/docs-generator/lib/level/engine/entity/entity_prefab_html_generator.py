from lib.html.html import HtmlElement

ENTITY_CLASS_HTML_ATTRIBUTE = "doc-entity card"
ENTITY_BODY_CLASS_HTML_ATTRIBUTES = "doc-entity-body card-body"
ENTITY_TITLE_CLASS_HTML_ATTRIBUTES = "doc-entity-title card-title text-center"
ENTITY_tEXT_TEMPLATE = "Entity prefab: {}"


class EntityPrefabHtmlGenerator(object):
    def __init__(self, preload_data_html_generator, component_prefab_html_generator):
        self.preload_data_html_generator = preload_data_html_generator
        self.component_prefab_html_generator = component_prefab_html_generator

    def generate_html(self, entity_prefab, code):
        try:
            return HtmlElement("div", attributes={
                "class": ENTITY_CLASS_HTML_ATTRIBUTE
            }, children=[
                HtmlElement("div", attributes={
                    "class": ENTITY_BODY_CLASS_HTML_ATTRIBUTES
                }, children=[
                    HtmlElement("h5", attributes={
                        "class": ENTITY_TITLE_CLASS_HTML_ATTRIBUTES
                    }, text=ENTITY_tEXT_TEMPLATE.format(code)),
                    HtmlElement("hr"),
                    self.preload_data_html_generator.generate_html(entity_prefab.get_preload_data()),
                    HtmlElement("hr")
                ])
            ])
        except Exception as e:
            raise EntityPrefabHtmlGenerationException(entity_prefab, e)


class EntityPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from entity prefab {}. Cause: {}."

    def __init__(self, entity_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(entity_prefab), cause))
