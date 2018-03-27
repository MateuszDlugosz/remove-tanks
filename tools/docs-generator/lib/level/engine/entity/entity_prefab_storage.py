class EntityPrefabStorage(object):
    def __init__(self, entity_pefabs):
        self.entity_prefabs = {}
        for key, value in entity_pefabs.items():
            self.entity_prefabs[key] = value

    def get_entity_prefab(self, code):
        if code not in self.entity_prefabs:
            raise EntityPrefabNotFoundException(code)
        return self.entity_prefabs[code]


class EntityPrefabNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Entity prefab of code {} not found."

    def __init__(self, code):
        super().__init__(self.MESSAGE_TEMPLATE.format(code))


class EntityPrefabStorageFactory(object):
    def __init__(self, entity_prefab_xml_reader):
        self.entity_prefab_xml_reader = entity_prefab_xml_reader

    def create_entity_prefab_storage(self, entity_prefab_repository, path_prefix):
        try:
            entity_prefabs = {}
            for key, value in entity_prefab_repository.get_all_prefabs().items():
                print(path_prefix + value)
                entity_prefabs[key] = self.entity_prefab_xml_reader.read_prefab_from_file(path_prefix + value)

            return EntityPrefabStorage(entity_prefabs)
        except Exception as e:
            raise EntityPrefabStorageCreateException(e)


class EntityPrefabStorageCreateException(Exception):
    MESSAGE_TEMPLATE = "Cannot create entity prefab storage. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
