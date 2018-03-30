from lib.html.html import HtmlElement

HIT_BOX_HTML_CLASS_ATTRIBUTE = "doc-hit-box"


class HitBoxPrefabHtmlGenerator(object):
    def __init__(self, fixture_prefab_html_generator):
        self.fixture_prefab_html_generator = fixture_prefab_html_generator

    def generate_html(self, hit_box_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", HIT_BOX_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Hit box"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Id"))
            dl.add_child(HtmlElement("dd", hit_box_prefab.get_id()))

            dl.add_child(HtmlElement("dt", "Fixture"))
            fixture_dd = HtmlElement("dd")
            fixture_dd.add_child(
                self.fixture_prefab_html_generator.generate_html(hit_box_prefab.get_fixture_prefab()))
            dl.add_child(fixture_dd)

            html.add_child(dl)

            return html
        except Exception as e:
            raise HitBoxPrefabHtmlGenerationException(hit_box_prefab, e)


class HitBoxPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from hit box prefab {}. Cause: {}."

    def __init__(self, hit_box_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(hit_box_prefab), cause))