from lib.graphics.color.color_prefab import RgbColorPrefab, RgbaColorPrefab, HexColorPrefab
from lib.html.html import HtmlElement

COLOR_HTML_CLASS_ATTRIBUTE = "doc-color"


class ColorPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.get_type()] = sub_generator

    def generate_html(self, color_prefab):
        try:
            if color_prefab.__class__.__name__ not in self.sub_generators:
                raise ColorPrefabHtmlGeneratorNotFoundException(color_prefab)
            return self.sub_generators[color_prefab.__class__.__name__].generate_html(color_prefab)
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)


class SubColorPrefabHtmlGenerator(object):
    def generate_html(self, color_prefab):
        raise NotImplemented("Not implemented yet.")

    def get_type(self):
        raise NotImplemented("Not implemented yet.")


class SubRgbColorPrefabHtmlGenerator(SubColorPrefabHtmlGenerator):
    def generate_html(self, color_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": COLOR_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Rgb color"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "R"),
                            HtmlElement("td", color_prefab.get_r())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "G"),
                            HtmlElement("td", color_prefab.get_g())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "B"),
                            HtmlElement("td", color_prefab.get_b())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return RgbColorPrefab.__name__


class SubRgbaColorPrefabHtmlGenerator(SubColorPrefabHtmlGenerator):
    def generate_html(self, color_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": COLOR_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Rgba color"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "R"),
                            HtmlElement("td", color_prefab.get_r())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "G"),
                            HtmlElement("td", color_prefab.get_g())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "B"),
                            HtmlElement("td", color_prefab.get_b())
                        ]),
                        HtmlElement("tr", children=[
                            HtmlElement("th", "A"),
                            HtmlElement("td", color_prefab.get_a())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return RgbaColorPrefab.__name__


class SubHexColorPrefabHtmlGenerator(SubColorPrefabHtmlGenerator):
    def generate_html(self, color_prefab):
        try:
            return HtmlElement("div", attributes={
                "class": COLOR_HTML_CLASS_ATTRIBUTE
            }, children=[
                HtmlElement("p", "Hex color"),
                HtmlElement("div", children=[
                    HtmlElement("table", children=[
                        HtmlElement("tr", children=[
                            HtmlElement("th", "Hex value"),
                            HtmlElement("td", color_prefab.get_hex_value())
                        ])
                    ])
                ])
            ])
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return HexColorPrefab.__name__


class ColorPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from color prefab {}. Cause: {}."

    def __init__(self, color_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(color_prefab), cause))


class ColorPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Color prefab html generator of {} color prefab not found."

    def __init__(self, color_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(color_prefab.__class__.__name__))
