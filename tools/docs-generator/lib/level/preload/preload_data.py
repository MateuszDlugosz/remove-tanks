import xml.etree.ElementTree as EXml


class PreloadData(object):
    def __init__(self, entity_prefab_codes=None, asset_ids=None):
        if asset_ids is None:
            asset_ids = []
        if entity_prefab_codes is None:
            entity_prefab_codes = []

        self.entity_prefab_codes = entity_prefab_codes
        self.asset_ids = asset_ids

    def get_entity_prefab_codes(self):
        return self.entity_prefab_codes

    def get_asset_ids(self):
        return self.asset_ids

    def __str__(self):
        return "PreloadData(entity_prefab_codes=[{}], asset_ids=[{}])" \
            .format(
                ", ".join('\'{}\''.format(val) for val in self.entity_prefab_codes),
                ", ".join('\'{}\''.format(val) for val in self.asset_ids)
            )


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
