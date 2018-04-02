import xml.etree.ElementTree as EXml

from lib.level.engine.entity.component.component_prefab_xml_reader import ComponentPrefabXmlReader
from lib.level.engine.entity.entity_prefab import EntityPrefab
from lib.level.preload.preload_data import PreloadData
from lib.level.preload.preload_data_xml_reader import PreloadDataXmlReader


class EntityPrefabXmlReader(object):
    def __init__(self, preload_data_xml_reader, component_prefab_xml_reader):
        self.preload_data_xml_reader = preload_data_xml_reader
        self.component_prefab_xml_reader = component_prefab_xml_reader

    def read_prefab_from_file(self, filename):
        try:
            tree = EXml.parse(filename)
            element = tree.getroot()
            preload_data = PreloadData()

            if element.find(PreloadDataXmlReader.PRELOAD_DATA_ELEMENT) is not None:
                preload_data = self.preload_data_xml_reader.read_from_xml(
                    EXml.tostring(element.find(PreloadDataXmlReader.PRELOAD_DATA_ELEMENT))
                )

            component_prefabs = self.component_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(ComponentPrefabXmlReader.COMPONENTS_ELEMENT))
            )

            return EntityPrefab(preload_data, component_prefabs)
        except Exception as e:
            raise EntityPrefabXmlReadException(filename, e)


class EntityPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read entity prefab from file {}. Cause: {}."

    def __init__(self, filename, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(filename, cause))
