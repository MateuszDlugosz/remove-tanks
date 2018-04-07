from lib.html.html import HtmlElement

UL_CLASS_HTML_ATTRIBUTES = "list-group list-group-flush"
LI_CLASS_HTML_ATTRIBUTES = "list-group-item"


class MenuEntityPrefabsHtmlGenerator(object):
    def generate_html(self, codes_filenames):
        try:
            li_elements = []
            for key, value in codes_filenames.items():
                li_elements.append(HtmlElement("li", attributes={
                    "class": LI_CLASS_HTML_ATTRIBUTES
                }, children=[
                    HtmlElement("a", attributes={
                        "href": value
                    }, text=key)
                ]))
            return HtmlElement("ul", children=li_elements, attributes={
                "class": UL_CLASS_HTML_ATTRIBUTES
            })
        except Exception as e:
            raise MenuEntityPrefabsHtmlGenerationException(e)


class MenuEntityPrefabsHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate menu entity prefabs. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
