import xml.etree.ElementTree as EXml


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


class PositionPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read position prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
