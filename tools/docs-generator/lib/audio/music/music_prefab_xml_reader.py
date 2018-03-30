import xml.etree.ElementTree as EXml

from lib.audio.music.music_prefab import MusicPrefab


class MusicPrefabXmlReader(object):
    MUSIC_ELEMENT = "music"
    FILENAME_ELEMENT = "filename"

    def read_prefab_from_string(self, xml_string):
        try:
            filename = EXml.fromstring(xml_string).find(self.FILENAME_ELEMENT).text.strip()

            return MusicPrefab(filename)
        except Exception as e:
            raise MusicPrefabXmlReadException(xml_string, e)


class MusicPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read music prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
