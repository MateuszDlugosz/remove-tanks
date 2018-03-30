import xml.etree.ElementTree as EXml

from lib.physics.filter.filter_prefab import FilterPrefab


class FilterPrefabXmlReader(object):
    FILTER_ELEMENT = "filter"
    CATEGORY_BIT_ELEMENT = "categoryBit"
    MASK_BIT_ELEMENT = "maskBit"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return FilterPrefab(
                element.find(self.CATEGORY_BIT_ELEMENT).text.strip(),
                element.find(self.MASK_BIT_ELEMENT).text.strip()
            )
        except Exception as e:
            raise FilterPrefabXmlReadException(xml_string, e)


class FilterPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read filter prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))