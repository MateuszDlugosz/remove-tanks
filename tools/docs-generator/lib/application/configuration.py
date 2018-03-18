import xml.etree.ElementTree as EXml


class Configuration:
    def __init__(self):
        self.options = {}

    def set_option(self, name, value):
        self.options[str(name)] = str(value)

    def get_option(self, name):
        if str(name) in self.options:
            return self.options[str(name)]
        return None


class ConfigurationXmlReader(object):
    OPTION_ELEMENT = "option"
    NAME_ATTRIBUTE = "name"

    def read_from_file(self, filename):
        tree = EXml.parse(str(filename))
        root = tree.getroot()
        configuration = Configuration()
        for option in root.findall(self.OPTION_ELEMENT):
            configuration.set_option(
                option.get(self.NAME_ATTRIBUTE).strip(),
                option.text.strip()
            )
        return configuration

