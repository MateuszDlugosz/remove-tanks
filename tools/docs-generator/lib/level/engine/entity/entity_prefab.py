import xml.etree.ElementTree as EXml

from lib.level.engine.entity.component.component_prefab import ComponentPrefabXmlReader
from lib.level.preload.preload_data import PreloadData, PreloadDataXmlReader


class EntityPrefab(object):
    def __init__(self, preload_data, component_prefabs):
        self.preload_data = preload_data
        self.component_prefabs = {}
        for component_prefab in component_prefabs:
            self.component_prefabs[component_prefab.__class__.__name__] = component_prefab

    def get_preload_data(self):
        return self.preload_data

    def get_component(self, type):
        if str(type) in self.component_prefabs:
            return self.component_prefabs[str(type)]
        return None

    def get_all_components(self):
        return self.component_prefabs

    def __str__(self):
        return "EntityPrefab(preload_data={}, component_prefabs=[{}])" \
            .format(
                str(self.preload_data),
                ", ".join('{}={}'.format(key, val) for key, val in self.component_prefabs.items())
            )


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
