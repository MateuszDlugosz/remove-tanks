from lib.html.html import HtmlElement
from lib.physics.light.light_prefab import PointLightPrefab, DirectionalLightPrefab, ConeLightPrefab

LIGHT_HTML_CLASS_ATTRIBUTE = "doc-light"


class LightPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, light_prefab):
        try:
            if light_prefab.__class__.__name__ not in self.sub_generators:
                raise LightPrefabHtmlGeneratorNotFoundException(light_prefab)

            return self.sub_generators[light_prefab.__class__.__name__].generate_html(light_prefab)
        except Exception as e:
            raise LightPrefabHtmlGenerationException(light_prefab, e)


class SubLightPrefabHtmlGenerator(Exception):
    def generate_html(self, light_prefab):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubPointLightPrefabHtmlGenerator(SubLightPrefabHtmlGenerator):
    def __init__(self, color_prefab_html_generator, position_prefab_html_generator):
        self.color_prefab_html_generator = color_prefab_html_generator
        self.position_prefab_html_generator = position_prefab_html_generator

    def generate_html(self, light_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": LIGHT_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Point light"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "XRay"),
                            HtmlElement("td", light_prefab.get_x_ray())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Distance"),
                            HtmlElement("td", light_prefab.get_distance())
                        ])
                    ])
                ]),
                HtmlElement("div", children=[
                    HtmlElement("p", "Position")
                ] + [self.position_prefab_html_generator.generate_html(light_prefab.get_position_prefab())]),
                self.color_prefab_html_generator.generate_html(light_prefab.get_color_prefab())
            ])
        except Exception as e:
            raise LightPrefabHtmlGenerationException(light_prefab, e)

    def get_type(self):
        return PointLightPrefab.__name__


class SubDirectionalLightPrefabHtmlGenerator(SubLightPrefabHtmlGenerator):
    def __init__(self, color_prefab_html_generator):
        self.color_prefab_html_generator = color_prefab_html_generator

    def generate_html(self, light_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": LIGHT_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Directional light"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "XRay"),
                            HtmlElement("td", light_prefab.get_x_ray())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Direction degree"),
                            HtmlElement("td", light_prefab.get_direction_degree())
                        ])
                    ])
                ]),
                self.color_prefab_html_generator.generate_html(light_prefab.get_color_prefab())
            ])
        except Exception as e:
            raise LightPrefabHtmlGenerationException(light_prefab, e)

    def get_type(self):
        return DirectionalLightPrefab.__name__


class SubConeLightPrefabHtmlGenerator(SubLightPrefabHtmlGenerator):
    def __init__(self, color_prefab_html_generator, position_prefab_html_generator):
        self.color_prefab_html_generator = color_prefab_html_generator
        self.position_prefab_html_generator = position_prefab_html_generator

    def generate_html(self, light_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": LIGHT_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Cone light"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "XRay"),
                            HtmlElement("td", light_prefab.get_x_ray())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Distance"),
                            HtmlElement("td", light_prefab.get_distance())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Direction degree"),
                            HtmlElement("td", light_prefab.get_direction_degree())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Cone degree"),
                            HtmlElement("td", light_prefab.get_cone_degree())
                        ])
                    ])
                ]),
                self.position_prefab_html_generator.generate_html(light_prefab.get_position_prefab()),
                self.color_prefab_html_generator.generate_html(light_prefab.get_color_prefab())
            ])
        except Exception as e:
            raise LightPrefabHtmlGenerationException(light_prefab, e)

    def get_type(self):
        return ConeLightPrefab.__name__


class LightPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from light prefab {}. Cause: {}."

    def __init__(self, light_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(light_prefab), cause))


class LightPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Light prefab html generator of type {} not found."

    def __init__(self, light_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(light_prefab.__class__.__name__))
