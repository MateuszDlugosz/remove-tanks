import xml.etree.ElementTree as EXml

from lib.physics.fixture.fixture_prefab_xml_reader import FixturePrefabXmlReader
from lib.physics.fixture.sensor_prefab import SensorPrefab


class SensorPrefabXmlReader(object):
    SENSOR_ELEMENT = "sensor"
    SENSORS_ELEMENT = "sensors"
    ID_ATTRIBUTE = "id"

    def __init__(self, fixture_prefab_xml_reader):
        self.fixture_prefab_xml_reader = fixture_prefab_xml_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            prefabs = []
            element = EXml.fromstring(xml_string)
            for child in element.findall(self.SENSOR_ELEMENT):
                prefabs.append(
                    self.read_prefab_from_string(EXml.tostring(child))
                )
            return prefabs
        except Exception as e:
            raise SensorPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return SensorPrefab(
                element.get(self.ID_ATTRIBUTE).strip(),
                self.fixture_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(FixturePrefabXmlReader.FIXTURE_ELEMENT)),
                    True
                )
            )
        except Exception as e:
            raise SensorPrefabXmlReadException(xml_string, e)


class SensorPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read sensor prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
