from lib.html.html import HtmlElement

PRELOAD_DATA_HTML_CLASS_ATTRIBUTE = "doc-preload-data"


class PreloadDataHtmlGenerator(object):
    def generate_html(self, preload_data):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", PRELOAD_DATA_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Preload data"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Entity prefab codes"))
            dl.add_child(HtmlElement("dd", ", ".join(preload_data.get_entity_prefab_codes())))
            dl.add_child(HtmlElement("dt", "Asset ids"))
            dl.add_child(HtmlElement("dd", ", ".join(preload_data.get_asset_ids())))

            html.add_child(dl)

            return html
        except Exception as e:
            raise PreloadDataHtmlGenerationException(preload_data, e)


class PreloadDataHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from preload data {}. Cause: {}."

    def __init__(self, preload_data, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(preload_data), cause))
