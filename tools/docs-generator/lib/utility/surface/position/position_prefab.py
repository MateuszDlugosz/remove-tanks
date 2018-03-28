import xml.etree.ElementTree as EXml

from lib.html.html import HtmlElement


class PositionPrefab(object):
    def __init__(self, x, y):
        self.x = float(x)
        self.y = float(y)

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def __str__(self):
        return "PositionPrefab(x={}, y={})".format(self.x, self.y)


class PositionPrefabXmlReader(object):
    POSITION_ELEMENT = "position"
    X_ELEMENT = "x"
    Y_ELEMENT = "y"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return PositionPrefab(
                float(element.find(self.X_ELEMENT).text),
                float(element.find(self.Y_ELEMENT).text)
            )
        except Exception as e:
            raise PositionPrefabXmlReadException(xml_string, e)


class PositionPrefabHtmlGenerator(object):
    def generate_html(self, position_prefab):
        try:
            return HtmlElement("div", "x:{}, y:{}".format(position_prefab.get_x(), position_prefab.get_y()))
        except Exception as e:
            raise PositionPrefabHtmlGenerationException(position_prefab, e)


class PositionPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read position prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class PositionPrefabHtmlGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate html from position prefab {}. Cause: {}."

    def __init__(self, position_prefab, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(str(position_prefab), cause))
