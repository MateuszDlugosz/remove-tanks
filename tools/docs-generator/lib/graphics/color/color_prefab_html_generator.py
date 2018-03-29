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
            html = HtmlElement("div")
            html.set_attribute("class", COLOR_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Rgb color"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "R"))
            dl.add_child(HtmlElement("dd", color_prefab.get_r()))
            dl.add_child(HtmlElement("dt", "G"))
            dl.add_child(HtmlElement("dd", color_prefab.get_g()))
            dl.add_child(HtmlElement("dt", "B"))
            dl.add_child(HtmlElement("dd", color_prefab.get_b()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return RgbColorPrefab.__name__


class SubRgbaColorPrefabHtmlGenerator(SubColorPrefabHtmlGenerator):
    def generate_html(self, color_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COLOR_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Rgba color"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "R"))
            dl.add_child(HtmlElement("dd", color_prefab.get_r()))
            dl.add_child(HtmlElement("dt", "G"))
            dl.add_child(HtmlElement("dd", color_prefab.get_g()))
            dl.add_child(HtmlElement("dt", "B"))
            dl.add_child(HtmlElement("dd", color_prefab.get_b()))
            dl.add_child(HtmlElement("dt", "A"))
            dl.add_child(HtmlElement("dd", color_prefab.get_a()))

            html.add_child(dl)

            return html
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return RgbaColorPrefab.__name__


class SubHexColorPrefabHtmlGenerator(SubColorPrefabHtmlGenerator):
    def generate_html(self, color_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("class", COLOR_HTML_CLASS_ATTRIBUTE)
            html.add_child(HtmlElement("h6", "Hex color"))
            html.add_child(HtmlElement("hr"))

            dl = HtmlElement("dl")
            dl.add_child(HtmlElement("dt", "Hex value"))
            dl.add_child(HtmlElement("dd", color_prefab.get_hex_value()))

            html.add_child(dl)

            return html
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
