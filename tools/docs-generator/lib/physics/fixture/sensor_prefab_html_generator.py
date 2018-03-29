from lib.html.html import HtmlElement

SENSOR_HTML_CLASS_ATTRIBUTE = "doc-sensor"


class SensorPrefabHtmlGenerator(object):
    def __init__(self, fixture_prefab_html_generator):
        self.fixture_prefab_html_generator = fixture_prefab_html_generator

    def generate_html(self, sensor_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", SENSOR_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Sensor"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Id"))
            dl.add_child(HtmlElement("dd", sensor_prefab.get_id()))

            dl.add_child(HtmlElement("dt", "Fixture"))
            fixture_dd = HtmlElement("dd")
            fixture_dd.add_child(
                self.fixture_prefab_html_generator.generate_html(sensor_prefab.get_fixture_prefab()))
            dl.add_child(fixture_dd)

            html.add_child(dl)

            return html
        except Exception as e:
            raise SensorPrefabHtmlGenerationException(sensor_prefab, e)


class SensorPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from hit box prefab {}. Cause: {}."

    def __init__(self, sensor_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(sensor_prefab), cause))
