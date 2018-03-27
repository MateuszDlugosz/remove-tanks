import xml.etree.ElementTree as EXml


class SoundPrefab(object):
    def __init__(self, filename):
        self.filename = str(filename)

    def get_filename(self):
        return self.filename

    def __str__(self):
        return "SoundPrefab(filename={})".format(self.filename)


class SoundPrefabXmlReader(object):
    SOUND_ELEMENT = "sound"
    FILENAME_ELEMENT = "filename"

    def read_prefab_from_string(self, xml_string):
        try:
            filename = EXml.fromstring(xml_string).find(self.FILENAME_ELEMENT).text.strip()

            return SoundPrefab(filename)
        except Exception as e:
            raise SoundPrefabXmlReadException(xml_string, e)


class SoundPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read sound prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
