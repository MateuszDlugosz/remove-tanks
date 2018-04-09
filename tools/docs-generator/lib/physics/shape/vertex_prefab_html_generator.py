from lib.html.html import HtmlElement

VERTICES_HTML_CLASS_ATTRIBUTE = "doc-vertices"
VERTEX_HTML_CLASS_ATTRIBUTE = "doc-vertex"

class VertexPrefabHtmlGenerator(object):
    def generate_html(self, vertices_prefabs):
        try:
            vertices_elements = []
            for vertex_prefab in vertices_prefabs:
                vertices_elements.append(HtmlElement("div", attributes={
                    "class": VERTEX_HTML_CLASS_ATTRIBUTE
                }, children=[
                    HtmlElement("p", "Vertex"),
                    HtmlElement("div", children=[
                        HtmlElement("table", children=[
                            HtmlElement("tr", children=[
                                HtmlElement("th", "X"),
                                HtmlElement("td", vertex_prefab.get_x())
                            ]),
                            HtmlElement("tr", children=[
                                HtmlElement("th", "Y"),
                                HtmlElement("td", vertex_prefab.get_y())
                            ])
                        ])
                    ])
                ]))

            return HtmlElement("div", attributes={
                "class": VERTICES_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Vertices"),
                HtmlElement("div", children=vertices_elements)
            ])
        except Exception as e:
            raise VertexPrefabHtmlGenerationException(vertices_prefabs, e)


class VertexPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from vertices prefabs {}. Cause: {}"

    def __init__(self, vertices_prefabs, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(vertices_prefabs), cause))
