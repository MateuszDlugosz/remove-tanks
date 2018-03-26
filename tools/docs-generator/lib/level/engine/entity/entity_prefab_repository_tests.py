import os
import unittest

from lib.level.engine.entity.entity_prefab import EntityPrefab
from lib.level.engine.entity.entity_prefab_repository import *

ENTITY_PREFAB_REPOSITORY_TEST_FILENAME = os.path.join(os.path.dirname(__file__), 'test-entity-prefab-repository.xml')


class TestEntityPrefabRepository(unittest.TestCase):
    def test_entity_prefab_repository_valid_call_get(self):
        repository = EntityPrefabRepository()
        repository.set_prefab("a", EntityPrefab([]))

        self.assertIsNot(repository.get_prefab("a"), None)

    def test_entity_prefab_repository_invalid_call_get(self):
        repository = EntityPrefabRepository()

        with self.assertRaises(EntityPrefabNotFoundException):
            repository.get_prefab("unknown_code")


class TestEntityPrefabRepositoryXmlReader(unittest.TestCase):
    def test_entity_prefab_repository_xml_reader_valid(self):
        reader = EntityPrefabRepositoryXmlReader()
        repository = reader.read_from_file(ENTITY_PREFAB_REPOSITORY_TEST_FILENAME)

        self.assertEqual(len(repository.get_all_prefabs()), 2)
        self.assertEqual(repository.get_prefab("TestEntity0"), "test-filename-0")
        self.assertEqual(repository.get_prefab("TestEntity1"), "test-filename-1")


if __name__ == "__main__":
    unittest.main()
