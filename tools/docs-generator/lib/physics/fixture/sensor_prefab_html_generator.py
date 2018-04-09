from lib.html.html import HtmlElement

SENSOR_HTML_CLASS_ATTRIBUTE = "doc-sensor"


class SensorPrefabHtmlGenerator(object):
    def __init__(self, fixture_prefab_html_generator):
        self.fixture_prefab_html_generator = fixture_prefab_html_generator

    def generate_html(self, sensor_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": SENSOR_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Sensor"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Id"),
                            HtmlElement("td", sensor_prefab.get_id())
                        ])
                    ]),
                    self.fixture_prefab_html_generator.generate_html(sensor_prefab.get_fixture_prefab())
                ])
            ])
        except Exception as e:
            raise SensorPrefabHtmlGenerationException(sensor_prefab, e)


class SensorPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from hit box prefab {}. Cause: {}."

    def __init__(self, sensor_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(sensor_prefab), cause))
