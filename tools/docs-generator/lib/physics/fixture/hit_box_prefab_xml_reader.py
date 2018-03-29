import xml.etree.ElementTree as EXml

from lib.physics.fixture.fixture_prefab_xml_reader import FixturePrefabXmlReader
from lib.physics.fixture.hit_box_prefab import HitBoxPrefab


class HitBoxPrefabXmlReader(object):
    HIT_BOX_ELEMENT = "hitBox"
    HIT_BOXES_ELEMENT = "hitBoxes"
    ID_ATTRIBUTE = "id"

    def __init__(self, fixture_prefab_xml_reader):
        self.fixture_prefab_xml_reader = fixture_prefab_xml_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            prefabs = []
            element = EXml.fromstring(xml_string)
            for child in element.findall(self.HIT_BOX_ELEMENT):
                prefabs.append(
                    self.read_prefab_from_string(EXml.tostring(child))
                )
            return prefabs
        except Exception as e:
            raise HitBoxPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return HitBoxPrefab(
                element.get(self.ID_ATTRIBUTE).strip(),
                self.fixture_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(FixturePrefabXmlReader.FIXTURE_ELEMENT)),
                    False
                )
            )
        except Exception as e:
            raise HitBoxPrefabXmlReadException(xml_string, e)


class HitBoxPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read hit box prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
