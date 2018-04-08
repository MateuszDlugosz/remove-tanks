from lib.html.html import HtmlElement

PRELOAD_DATA_HTML_CLASS_ATTRIBUTE = "doc-preload-data"
TABLE_HTML_CLASS_ATTRIBUTE = "doc-preload-data-table table table-hover table-bordered"
ENTITY_PREFAB_CODES_TH_TITLE = "Entity prefab codes"
ASSET_IDS_TH_TITLE = "Assed ids"
PRELOAD_DATA_TITLE = "Preload data"
PRELOAD_DATA_TITLE_CLASS_ATTRIBUTE = "text-center"


class PreloadDataHtmlGenerator(object):
    def generate_html(self, preload_data):
        try:
            return HtmlElement("div", attributes={
                "class": PRELOAD_DATA_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("h5", PRELOAD_DATA_TITLE, attributes={
                    "class": PRELOAD_DATA_TITLE_CLASS_ATTRIBUTE
                }),
                HtmlElement("table", attributes={
                    "class": TABLE_HTML_CLASS_ATTRIBUTE
                }, children=[
                    HtmlElement("tr", children=[
                        HtmlElement("th", ENTITY_PREFAB_CODES_TH_TITLE),
                        HtmlElement("td", ", ".join(preload_data.get_entity_prefab_codes()))
                    ]),
                    HtmlElement("tr", children=[
                        HtmlElement("th", ASSET_IDS_TH_TITLE),
                        HtmlElement("td", ", ".join(preload_data.get_asset_ids()))
                    ])
                ])
            ])
        except Exception as e:
            raise PreloadDataHtmlGenerationException(preload_data, e)


class PreloadDataHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from preload data {}. Cause: {}."

    def __init__(self, preload_data, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(preload_data), cause))
