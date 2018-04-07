from lib.html.html import HtmlElement

FILTER_HTML_CLASS_ATTRIBUTE = "doc-filter"


class FilterPrefabHtmlGenerator(object):
    def generate_html(self, filter_prefab):
        try:
            return HtmlElement(
                "div",
                attributes={
                    "class": FILTER_HTML_CLASS_ATTRIBUTE
                },
                children=[
                    HtmlElement("button", "Filter"),
                    HtmlElement("div", children=[
                        HtmlElement("p", children=[
                            HtmlElement("table", children=[
                                HtmlElement("tr", children=[
                                    HtmlElement("th", "Category bit"),
                                    HtmlElement("td", filter_prefab.get_category_bit())
                                ]),
                                HtmlElement("tr", children=[
                                    HtmlElement("th", "Mask bit"),
                                    HtmlElement("td", filter_prefab.get_mask_bit())
                                ])
                            ])
                        ])
                    ])
                ]
            )
        except Exception as e:
            raise FilterPrefabHtmlGenerationException(filter_prefab, e)


class FilterPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from filter prefab {}. Cause: {}."

    def __init__(self, filter_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(filter_prefab), cause))
