import xml.etree.ElementTree as EXml


class EntityPrefabRepository:
    def __init__(self):
        self.prefabs = {}

    def set_prefab(self, code, filename):
        self.prefabs[str(code)] = str(filename)

    def get_prefab(self, code):
        if str(code) not in self.prefabs:
            raise EntityPrefabNotFoundException(str(code))
        return self.prefabs[str(code)]

    def get_all_prefabs(self):
        return self.prefabs

    def __str__(self):
        return "EntityPrefabRepository(prefabs={})"\
            .format(", ".join('{}={}'.format(key, val) for key, val in self.prefabs.items()))


class EntityPrefabRepositoryXmlReader(object):
    ENTITY_PREFAB_FILENAME_ELEMENT = "entityPrefabFilename"
    CODE_ATTRIBUTE = "code"

    def read_from_file(self, filename):
        try:
            tree = EXml.parse(str(filename).strip())
            root = tree.getroot()
            repository = EntityPrefabRepository()
            for child in root.findall(self.ENTITY_PREFAB_FILENAME_ELEMENT):
                repository.set_prefab(child.get(self.CODE_ATTRIBUTE).strip(), child.text.strip())
            return repository
        except Exception:
            raise EntityPrefabRepositoryXmlReadException(filename)


class EntityPrefabRepositoryXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read level prefab repository from file {}."

    def __init__(self, filename):
        super().__init__(self.MESSAGE_TEMPLATE.format(filename))


class EntityPrefabNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Entity prefab of code {} not found."

    def __init__(self, code):
        super().__init__(self.MESSAGE_TEMPLATE.format(code))
