import xml.etree.ElementTree as EXml

from lib.utility.surface.position.position_prefab import PositionPrefab, PositionPrefabXmlReader


class CreateEntryPrefab(object):
    def __init__(self, prefab_code, position_prefab):
        self.prefab_code = str(prefab_code)
        self.position_prefab = position_prefab

    def get_prefab_code(self):
        return self.prefab_code

    def get_position_prefab(self):
        return self.position_prefab

    def __str__(self):
        return "CreateEntryPrefab(prefab_code={}, position_prefab={})" \
            .format(self.prefab_code, str(self.position_prefab))


class CreateEntryPrefabXmlReader(object):
    CREATE_ENTRY_ELEMENT = "createEntry"
    CREATE_ENTRIES_ELEMENT = "createEntries"
    ENTITY_PREFAB_CODE_ELEMENT = "entityPrefabCode"

    def __init__(self, position_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefabs = []

            for ce_element in element.findall(self.CREATE_ENTRY_ELEMENT):
                prefabs.append(self.read_prefab_from_string(EXml.tostring(ce_element)))

            return prefabs
        except Exception as e:
            raise CreateEntryPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_code = element.find(self.ENTITY_PREFAB_CODE_ELEMENT).text.strip()
            position_prefab = PositionPrefab(0, 0)

            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            return CreateEntryPrefab(prefab_code, position_prefab)
        except Exception as e:
            raise CreateEntryPrefabXmlReadException(xml_string, e)


class CreateEntryPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read create entry prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
