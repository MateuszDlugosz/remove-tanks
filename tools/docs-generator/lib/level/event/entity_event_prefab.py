import xml.etree.ElementTree as EXml


class EntityEventPrefab(object):
    def __str__(self):
        raise NotImplemented("Not implemented yet.")


class EntityEventPrefabXmlReader(object):
    ENTITY_EVENT_ELEMENT = "entityEvent"
    ENTITY_EVENTS_ELEMENT = "entityEvents"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            prefabs = []
            for element in EXml.fromstring(xml_string).findall(self.ENTITY_EVENT_ELEMENT):
                prefabs.append(self.read_prefab_from_string(EXml.tostring(element)))

            return prefabs
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE).strip()

            if prefab_type not in self.sub_readers:
                raise EntityEventPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)


class EntityEventPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read event prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class EntityEventPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Event prefab xml reader of {} event type not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))


class SubEntityEventPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplemented("Not implemented yet.")

    def get_type(self):
        raise NotImplemented("Not implemented yet.")


class SpawnAirplaneEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "SpawnAirplaneEntityEventPrefab()"


class SubSpawnAirplaneEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return SpawnAirplaneEntityEventPrefab()

    def get_type(self):
        return "SpawnAirplaneEntityEvent"


class AmmoLevelUpEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "AmmoLevelUpEntityEventPrefab()"


class SubAmmoLevelUpEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AmmoLevelUpEntityEventPrefab()

    def get_type(self):
        return "AmmoLevelUpEntityEvent"
