import xml.etree.ElementTree as EXml

from lib.physics.light.light_handler_prefab import LightHandlerPrefab
from lib.physics.light.light_prefab_xml_reader import LightPrefabXmlReader


class LightHandlerPrefabXmlReader(object):
    LIGHT_HANDLER_ELEMENT = "lightHandler"
    LIGHT_HANDLERS_ELEMENT = "lightHandlers"
    ID_ATTRIBUTE = "id"

    def __init__(self, light_prefab_xml_reader):
        self.light_prefab_xml_reader = light_prefab_xml_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            handlers = []
            element = EXml.fromstring(xml_string)
            for child in element.findall(self.LIGHT_HANDLER_ELEMENT):
                handlers.append(self.read_prefab_from_string(EXml.tostring(child)))

            return handlers
        except Exception as e:
            raise LightHandlerPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            light_prefab = self.light_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(LightPrefabXmlReader.LIGHT_ELEMENT))
            )
            prefab_id = element.get(self.ID_ATTRIBUTE).strip()

            return LightHandlerPrefab(prefab_id, light_prefab)
        except Exception as e:
            raise LightHandlerPrefabXmlReadException(xml_string, e)


class LightHandlerPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read light handler prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
