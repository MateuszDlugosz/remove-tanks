from lib.html.html import HtmlElement

POSITION_HTML_CLASS_ATTRIBUTE = "doc-position"


class PositionPrefabHtmlGenerator(object):
    def generate_html(self, position_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", POSITION_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Position"))
            html.add_child(HtmlElement("hr"))
            dl = HtmlElement("dl")
            dt0 = HtmlElement("dt", "X")
            dd0 = HtmlElement("dd", position_prefab.get_x())
            dt1 = HtmlElement("dt", "Y")
            dd1 = HtmlElement("dd", position_prefab.get_y())
            dl.add_child(dt0)
            dl.add_child(dd0)
            dl.add_child(dt1)
            dl.add_child(dd1)
            html.add_child(dl)

            return html
        except Exception as e:
            raise PositionPrefabHtmlGenerationException(position_prefab, e)


class PositionPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from position prefab {}. Cause: {}."

    def __init__(self, position_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(position_prefab), cause))
