import xml.etree.ElementTree as EXml


class DirectionXmlReader(object):
    DIRECTION_ELEMENT = "direction"
    DIRECTIONS_ELEMENT = "directions"

    def read_directions_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            directions = []

            for direction_element in element.findall(self.DIRECTION_ELEMENT):
                directions.append(direction_element.text.strip())

            return directions
        except Exception as e:
            raise DirectionXmlReadException(xml_string, e)

    def read_direction_from_string(self, xml_string):
        try:
            return EXml.fromstring(xml_string).text.strip()
        except Exception as e:
            raise DirectionXmlReadException(xml_string, e)


class DirectionXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read direction from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
