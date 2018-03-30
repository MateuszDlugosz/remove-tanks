from lib.html.html import HtmlElement

CREATE_ENTRY_HTML_CLASS_ATTRIBUTE = "doc-create-entry"


class CreateEntryPrefabHtmlGenerator(object):
    def __init__(self, position_prefab_html_generator):
        self.position_prefab_html_generator = position_prefab_html_generator

    def generate_html(self, create_entry_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", CREATE_ENTRY_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Create entry"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Position"))
            dd_position = HtmlElement("dd")
            dd_position.add_child(self.position_prefab_html_generator.generate_html(
                create_entry_prefab.get_position_prefab()))
            dl.add_child(dd_position)

            dl.add_child(HtmlElement("dt", "Entity prefab code"))
            dl.add_child(HtmlElement("dd", create_entry_prefab.get_prefab_code()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise CreateEntryPrefabHtmlGenerationException(create_entry_prefab, e)


class CreateEntryPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from create entry prefab {}. Cause: {}."

    def __init__(self, create_entry_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(create_entry_prefab), cause))
