import os
import unittest

from lib.level.engine.entity.component.component_prefab_xml_reader import ComponentPrefabXmlReader, \
    SubObstacleRenderLayerComponentPrefabXmlReader
from lib.level.engine.entity.entity_prefab_xml_reader import EntityPrefabXmlReader
from lib.level.preload.preload_data_xml_reader import PreloadDataXmlReader

ENTITY_PREFAB_TEST_FILENAME = os.path.join(os.path.dirname(__file__), 'test-entity-prefab.xml')


class TestEntityPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_xml(self):
        xml_reader = EntityPrefabXmlReader(
            PreloadDataXmlReader(),
            ComponentPrefabXmlReader([
                SubObstacleRenderLayerComponentPrefabXmlReader()
            ])
        )
        prefab = xml_reader.read_prefab_from_file(ENTITY_PREFAB_TEST_FILENAME)

        self.assertEqual(len(prefab.get_preload_data().get_asset_ids()), 3)
        self.assertEqual(len(prefab.get_preload_data().get_entity_prefab_codes()), 2)
        self.assertEqual(len(prefab.get_all_components()), 1)


if __name__ == "__main__":
    unittest.main()
