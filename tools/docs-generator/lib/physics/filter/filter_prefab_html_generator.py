from lib.html.html import HtmlElement

FILTER_HTML_ID_ATTRIBUTE = "doc-filter"


class FilterPrefabHtmlGenerator(object):
    def generate_html(self, filter_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("id", FILTER_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Filter"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Category bit"))
            dl.add_child(HtmlElement("dd", filter_prefab.get_category_bit()))
            dl.add_child(HtmlElement("dt", "Mask bit"))
            dl.add_child(HtmlElement("dd", filter_prefab.get_mask_bit()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise FilterPrefabHtmlGenerationException(filter_prefab, e)


class FilterPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from filter prefab {}. Cause: {}."

    def __init__(self, filter_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(filter_prefab), cause))
