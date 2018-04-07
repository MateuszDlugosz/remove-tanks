from lib.html.html import HtmlElement

POSITION_HTML_CLASS_ATTRIBUTE = "doc-position"


class PositionPrefabHtmlGenerator(object):
    def generate_html(self, position_prefab):
        try:
            return HtmlElement(
                "div",
                attributes={
                    "class": POSITION_HTML_CLASS_ATTRIBUTE
                },
                children=[
                    HtmlElement("button", "Position"),
                    HtmlElement("div", children=[
                        HtmlElement("p", children=[
                            HtmlElement("table", children=[
                                HtmlElement("tr", children=[
                                    HtmlElement("th", "X"),
                                    HtmlElement("td", position_prefab.get_x())
                                ]),
                                HtmlElement("tr", children=[
                                    HtmlElement("th", "Y"),
                                    HtmlElement("td", position_prefab.get_y())
                                ])
                            ])
                        ])
                    ])
                ]
            )
        except Exception as e:
            raise PositionPrefabHtmlGenerationException(position_prefab, e)


class PositionPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from position prefab {}. Cause: {}."

    def __init__(self, position_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(position_prefab), cause))
