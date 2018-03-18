import xml.etree.ElementTree as EXml


class ComponentPrefab(object):
    def __init__(self):
        self.variables = {}

    def set_variable(self, name, value):
        self.variables[str(name)] = value

    def get_variable(self, name):
        if str(name) in self.variables:
            return self.variables[str(name)]
        return None


class ComponentPrefabXmlReader(object):
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[str(sub_reader.get_type())] = sub_reader

    def read_from_string(self, xml_string):
        tree = EXml.fromstring(xml_string)
        root = tree.getroot()
        component_type = root.get(self.TYPE_ATTRIBUTE).strip()
        return self.sub_readers[component_type].read_from_string(xml_string)


class SubComponentPrefabXmlReader(object):
    def read_from_string(self, xml_string):
        raise NotImplemented("Method not implemented yet.")

    def get_type(self):
        raise NotImplemented("Method not implemented yet.")


class SubSpeedComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    SPEED_ELEMENT = "speed"

    def read_from_string(self, xml_string):
        component = ComponentPrefab()
        component.set_variable("speed", EXml.fromstring(xml_string).find(self.SPEED_ELEMENT).text)
        return component

    def get_type(self):
        return "SpeedComponent"
