from lib.html.html import HtmlElement

VERTEX_HTML_ID_ATTRIBUTE = "doc-vertex"


class VertexPrefabHtmlGenerator(object):
    def generate_html(self, vertex_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("id", VERTEX_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Vertex"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "X"))
            dl.add_child(HtmlElement("dd", vertex_prefab.get_x()))
            dl.add_child(HtmlElement("dt", "Y"))
            dl.add_child(HtmlElement("dd", vertex_prefab.get_y()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise VertexPrefabHtmlGenerationException(vertex_prefab, e)


class VertexPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from vertex prefab {}. Cause: {}"

    def __init__(self, vertex_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(vertex_prefab), cause))
