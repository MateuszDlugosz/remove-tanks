from lib.html.html import HtmlElement

FIXTURE_HTML_CLASS_ATTRIBUTE = "doc-fixture"


class FixturePrefabHtmlGenerator(object):
    def __init__(self, shape_prefab_html_generator, filter_prefab_html_generator):
        self.shape_prefab_html_generator = shape_prefab_html_generator
        self.filter_prefab_html_generator = filter_prefab_html_generator

    def generate_html(self, fixture_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", FIXTURE_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Fixture"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")

            dl.add_child(HtmlElement("dt", "Shape"))
            shape_dd = HtmlElement("dd")
            shape_dd.add_child(self.shape_prefab_html_generator.generate_html(fixture_prefab.get_shape_prefab()))
            dl.add_child(shape_dd)

            dl.add_child(HtmlElement("dt", "Filter"))
            filter_dd = HtmlElement("dd")
            filter_dd.add_child(self.filter_prefab_html_generator.generate_html(fixture_prefab.get_filter_prefab()))
            dl.add_child(filter_dd)

            dl.add_child(HtmlElement("dt", "Density"))
            dl.add_child(HtmlElement("dd", fixture_prefab.get_density()))

            dl.add_child(HtmlElement("dt", "Restitution"))
            dl.add_child(HtmlElement("dd", fixture_prefab.get_restitution()))

            dl.add_child(HtmlElement("dt", "Friction"))
            dl.add_child(HtmlElement("dd", fixture_prefab.get_friction()))

            dl.add_child(HtmlElement("dt", "Is sensor"))
            dl.add_child(HtmlElement("dd", fixture_prefab.get_is_sensor()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise FixturePrefabHtmlGenerationException(fixture_prefab, e)


class FixturePrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from fixture prefab {}. Cause: {}."

    def __init__(self, fixture_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(fixture_prefab), cause))
