import xml.etree.ElementTree as EXml

from lib.html.html import HtmlElement

COLOR_HTML_ID_ATTRIBUTE = "doc-color"


class ColorPrefab(object):
    pass


class RgbColorPrefab(ColorPrefab):
    def __init__(self, r, g, b):
        self.r = float(r)
        self.g = float(g)
        self.b = float(b)

    def get_r(self):
        return self.r

    def get_g(self):
        return self.g

    def get_b(self):
        return self.b

    def __str__(self):
        return "RgbColorPrefab(r={}, g={}, b={})".format(self.r, self.g, self.b)


class RgbaColorPrefab(ColorPrefab):
    def __init__(self, r, g, b, a):
        self.r = float(r)
        self.g = float(g)
        self.b = float(b)
        self.a = float(a)

    def get_r(self):
        return self.r

    def get_g(self):
        return self.g

    def get_b(self):
        return self.b

    def get_a(self):
        return self.a

    def __str__(self):
        return "RgbaColorPrefab(r={}, g={}, b={}, a={})".format(self.r, self.g, self.b, self.a)


class HexColorPrefab(ColorPrefab):
    def __init__(self, hex_value):
        self.hex_value = str(hex_value)

    def get_hex_value(self):
        return self.hex_value

    def __str__(self):
        return "HexColorPrefab(hex_value={})".format(self.hex_value)


class ColorPrefabXmlReader(object):
    COLOR_ELEMENT = "color"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE)

            if prefab_type not in self.sub_readers:
                raise ColorPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise ColorPrefabXmlReadException(xml_string, e)


class ColorPrefabHtmlGenerator(object):
    def __init__(self, sub_generators):
        self.sub_generators = {}
        for sub_generator in sub_generators:
            self.sub_generators[sub_generator.__class__.__name__] = sub_generator

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
            html.set_attribute("id", COLOR_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", color_prefab.__class__.__name__))
            html.add_child(HtmlElement("hr"))
            html.add_child(HtmlElement(
                "div", "p", "r:{}, g:{}, b:{}"
                    .format(color_prefab.get_r(), color_prefab.get_g(), color_prefab.get_b())))

            return html
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return RgbColorPrefab.__class__.__name__


class SubRgbaColorPrefabHtmlGenerator(SubColorPrefabHtmlGenerator):
    def generate_html(self, color_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("id", COLOR_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", color_prefab.__class__.__name__))
            html.add_child(HtmlElement("hr"))
            html.add_child(HtmlElement(
                "div", "p", "r:{}, g:{}, b:{}, a:{}".format(
                    color_prefab.get_r(), color_prefab.get_g(), color_prefab.get_b(), color_prefab.get_a())))

            return html
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return RgbaColorPrefab.__class__.__name__


class SubHexColorPrefabHtmlGenerator(SubColorPrefabHtmlGenerator):
    def generate_html(self, color_prefab):
        try:
            html = HtmlElement("div")
            html.set_attribute("id", COLOR_HTML_ID_ATTRIBUTE)
            html.add_child(HtmlElement("h6", color_prefab.__class__.__name__))
            html.add_child(HtmlElement("hr"))
            html.add_child(HtmlElement(
                "div", "p", "Hex value:{}".format(color_prefab.get_hex_value())))

            return html
        except Exception as e:
            raise ColorPrefabHtmlGenerationException(color_prefab, e)

    def get_type(self):
        return HexColorPrefab.__class__.__name__


class SubColorPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubRgbColorPrefabXmlReader(SubColorPrefabXmlReader):
    R_ELEMENT = "r"
    G_ELEMENT = "g"
    B_ELEMENT = "b"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return RgbColorPrefab(
                float(element.find(self.R_ELEMENT).text),
                float(element.find(self.G_ELEMENT).text),
                float(element.find(self.B_ELEMENT).text)
            )
        except Exception as e:
            raise ColorPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "RgbColor"


class SubRgbaColorPrefabXmlReader(SubColorPrefabXmlReader):
    R_ELEMENT = "r"
    G_ELEMENT = "g"
    B_ELEMENT = "b"
    A_ELEMENT = "a"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return RgbaColorPrefab(
                float(element.find(self.R_ELEMENT).text),
                float(element.find(self.G_ELEMENT).text),
                float(element.find(self.B_ELEMENT).text),
                float(element.find(self.A_ELEMENT).text)
            )
        except Exception as e:
            raise ColorPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "RgbaColor"


class SubHexColorPrefabXmlReader(SubColorPrefabXmlReader):
    HEX_VALUE_ELEMENT = "hexValue"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return HexColorPrefab(
                element.find(self.HEX_VALUE_ELEMENT).text
            )
        except Exception as e:
            raise ColorPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "HexColor"


class ColorPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read color prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class ColorPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate htmml from color prefab {}. Cause: {}."

    def __init__(self, color_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(color_prefab), cause))


class ColorPrefabHtmlGeneratorNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Color prefab html generator of {} color prefab not found."

    def __init__(self, color_prefab):
        super().__init__(self.MESSAGE_TEMPLATE.format(color_prefab.__class__.__name__))


class ColorPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Color prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
