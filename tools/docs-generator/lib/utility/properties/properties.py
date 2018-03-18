import xml.etree.ElementTree as EXml


class Properties(object):
    def __init__(self):
        self.properties = {}

    def set_property(self, name, value):
        self.properties[str(name)] = str(value)

    def get_property(self, name):
        if str(name) in self.properties:
            return self.properties[str(name)]
        return None

    def __str__(self):
        return "Properties(properties={})".format(self.properties)


class PropertiesXmlReader(object):
    PROPERTY_ELEMENT = "property"
    NAME_ATTRIBUTE = "name"

    def read_properties_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            properties = Properties()
            for a_property in element.findall(self.PROPERTY_ELEMENT):
                property_name = a_property.get(self.NAME_ATTRIBUTE)
                property_value = a_property.text

                if property_name is None:
                    raise Exception("Property name cannot be none.")

                if property_value is None:
                    raise Exception("Property value cannot be none.")

                properties.set_property(
                    a_property.get("name"),
                    a_property.text
                )
            return properties
        except Exception as e:
            raise PropertiesXmlReadException(xml_string, e)


class PropertiesXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read properties from string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
