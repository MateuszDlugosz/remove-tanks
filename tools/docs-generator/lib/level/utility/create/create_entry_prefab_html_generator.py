from lib.html.html import HtmlElement

CREATE_ENTRY_HTML_CLASS_ATTRIBUTE = "doc-create-entry"


class CreateEntryPrefabHtmlGenerator(object):
    def __init__(self, position_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator

    def generate_html(self, create_entry_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": CREATE_ENTRY_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Create entry"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Entity prefab code"),
                            HtmlElement("td", create_entry_prefab.get_prefab_code())
                        ])
                    ])
                ]),
                self.position_prefab_html_generator.generate_html(create_entry_prefab.get_position_prefab())
            ])
        except Exception as e:
            raise CreateEntryPrefabHtmlGenerationException(create_entry_prefab, e)


class CreateEntryPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from create entry prefab {}. Cause: {}."

    def __init__(self, create_entry_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(create_entry_prefab), cause))
