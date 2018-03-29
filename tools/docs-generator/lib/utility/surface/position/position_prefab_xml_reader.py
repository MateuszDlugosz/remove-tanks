import xml.etree.ElementTree as EXml

from lib.utility.surface.position.position_prefab import PositionPrefab


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
