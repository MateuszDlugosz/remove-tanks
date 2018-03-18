import xml.etree.ElementTree as EXml


class EntityPrefabRepository:
    def __init__(self):
        self.prefabs = {}

    def set_prefab(self, code, filename):
        self.prefabs[str(code)] = str(filename)

    def get_prefab(self, code):
        if str(code) in self.prefabs:
            return self.prefabs[str(code)]
        return None

    def get_all_prefabs(self):
        return self.prefabs


class EntityPrefabRepositoryXmlReader(object):
    ENTITY_PREFAB_FILENAME_ELEMENT = "entityPrefabFilename"
    CODE_ATTRIBUTE = "code"

    def read_from_file(self, filename):
        tree = EXml.parse(str(filename).strip())
        root = tree.getroot()
        repository = EntityPrefabRepository()
        for child in root.findall(self.ENTITY_PREFAB_FILENAME_ELEMENT):
            repository.set_prefab(child.get(self.CODE_ATTRIBUTE).strip(), child.text.strip())
        return repository
