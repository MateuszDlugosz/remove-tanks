from lib.html.html import HtmlElement

PRELOAD_DATA_HTML_CLASS_ATTRIBUTE = "doc-preload-data"


class PreloadDataHtmlGenerator(object):
    def generate_html(self, preload_data):
        try:
            return HtmlElement("div", attributes={
                "class": PRELOAD_DATA_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Preload data"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Entity prefab codes"),
                            HtmlElement("td", ", ".join(preload_data.get_entity_prefab_codes()))
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Asset ids"),
                            HtmlElement("td", ", ".join(preload_data.get_asset_ids()))
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise PreloadDataHtmlGenerationException(preload_data, e)


class PreloadDataHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from preload data {}. Cause: {}."

    def __init__(self, preload_data, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(preload_data), cause))
