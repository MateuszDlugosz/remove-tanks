import xml.etree.ElementTree as EXml

from lib.level.preload.preload_data import PreloadData


class PreloadDataXmlReader(object):
    PRELOAD_DATA_ELEMENT = "preloadData"
    ASSET_IDS_ELEMENT = "assetIds"
    ASSET_ID_ELEMENT = "assetId"
    ENTITY_PREFAB_CODE_ELEMENT = "entityPrefabCode"
    ENTITY_PREFAB_CODES_ELEMENT = "entityPrefabCodes"

    def read_from_xml(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            entity_prefab_codes = []
            asset_ids = []

            if element.find(self.ENTITY_PREFAB_CODES_ELEMENT) is not None:
                for child in element.find(self.ENTITY_PREFAB_CODES_ELEMENT).findall(self.ENTITY_PREFAB_CODE_ELEMENT):
                    entity_prefab_codes.append(child.text.strip())

            if element.find(self.ASSET_IDS_ELEMENT) is not None:
                for child in element.find(self.ASSET_IDS_ELEMENT).findall(self.ASSET_ID_ELEMENT):
                    asset_ids.append(child.text.strip())

            return PreloadData(entity_prefab_codes, asset_ids)
        except Exception as e:
            raise PreloadDataXmlReadException(xml_string, e)


class PreloadDataXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read preload data from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
