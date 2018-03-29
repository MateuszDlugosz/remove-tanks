import xml.etree.ElementTree as EXml

from lib.graphics.color.color_prefab import RgbColorPrefab, RgbaColorPrefab, HexColorPrefab


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


class ColorPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Color prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
