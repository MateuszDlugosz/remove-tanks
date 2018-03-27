import xml.etree.ElementTree as EXml


class Configuration:
    def __init__(self, options):
        self.options = {}
        for key, value in options.items():
            self.options[key] = value

    def get_option(self, name):
        if str(name) in self.options:
            return self.options[str(name)]
        return None


class ConfigurationXmlReader(object):
    OPTION_ELEMENT = "option"
    NAME_ATTRIBUTE = "name"

    def read_from_file(self, filename):
        try:
            tree = EXml.parse(str(filename))
            root = tree.getroot()
            options = {}
            for option in root.findall(self.OPTION_ELEMENT):
                options[option.get(self.NAME_ATTRIBUTE).strip()] = option.text.strip()

            return Configuration(options)
        except Exception as e:
            raise ConfigurationXmlReadException(filename, e)


class ConfigurationXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read configuration from file {}. Cause: {}."

    def __init__(self, filename, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(filename, cause))
