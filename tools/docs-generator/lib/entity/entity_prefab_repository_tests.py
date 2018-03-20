import os
import unittest

from lib.entity.entity_prefab_repository import *

ENTITY_PREFAB_REPOSITORY_TEST_FILENAME = os.path.join(os.path.dirname(__file__), 'entity-prefab-repository-test.xml')


class TestEntityPrefabRepositoryXmlReader(unittest.TestCase):
    def test_entity_prefab_repository_xml_reader_valid(self):
        reader = EntityPrefabRepositoryXmlReader()
        repository = reader.read_from_file(ENTITY_PREFAB_REPOSITORY_TEST_FILENAME)

        self.assertEqual(len(repository.get_all_prefabs()), 2)
        self.assertEqual(repository.get_prefab("TestEntity0"), "test-filename-0")
        self.assertEqual(repository.get_prefab("TestEntity1"), "test-filename-1")


if __name__ == "__main__":
    unittest.main()
