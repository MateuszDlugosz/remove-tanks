from lib.html.html import HtmlElement

FIXTURE_HTML_CLASS_ATTRIBUTE = "doc-fixture"


class FixturePrefabHtmlGenerator(object):
    def __init__(self, shape_prefab_html_generator, filter_prefab_html_generator):
        self.shape_prefab_html_generator = shape_prefab_html_generator
        self.filter_prefab_html_generator = filter_prefab_html_generator

    def generate_html(self, fixture_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": FIXTURE_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Fixture"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Density"),
                            HtmlElement("td", fixture_prefab.get_density())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Restitution"),
                            HtmlElement("td", fixture_prefab.get_restitution())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Friction"),
                            HtmlElement("td", fixture_prefab.get_friction())
                        ])
                    ])
                ]),
                self.filter_prefab_html_generator.generate_html(fixture_prefab.get_filter_prefab()),
                self.shape_prefab_html_generator.generate_html(fixture_prefab.get_shape_prefab())
            ])
        except Exception as e:
            raise FixturePrefabHtmlGenerationException(fixture_prefab, e)


class FixturePrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from fixture prefab {}. Cause: {}."

    def __init__(self, fixture_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(fixture_prefab), cause))
