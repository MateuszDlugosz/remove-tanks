from lib.html.html import HtmlElement

HIT_BOX_HTML_CLASS_ATTRIBUTE = "doc-hit-box"


class HitBoxPrefabHtmlGenerator(object):
    def __init__(self, fixture_prefab_html_generator):
        self.fixture_prefab_html_generator = fixture_prefab_html_generator

    def generate_html(self, hit_box_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": HIT_BOX_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Hit box"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Id"),
                            HtmlElement("td", hit_box_prefab.get_id())
                        ])
                    ])
                ]),
                HtmlElement("div", children=[
                    HtmlElement("p", "Fixture")
                ] + self.fixture_prefab_html_generator.generate_html(hit_box_prefab.get_fixture_prefab()))
            ])
        except Exception as e:
            raise HitBoxPrefabHtmlGenerationException(hit_box_prefab, e)


class HitBoxPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from hit box prefab {}. Cause: {}."

    def __init__(self, hit_box_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(hit_box_prefab), cause))
