import unittest

from lib.level.engine.entity.component.component_prefab import SpeedComponentPrefab
from lib.level.engine.entity.entity_prefab import *


class TestEntityPrefab(unittest.TestCase):
    def test_entity_prefab_to_string(self):
        preload_data = PreloadData(["CODE_0", "CODE_1"], ["ID_0", "ID_1"])

        self.assertEqual(
            str(EntityPrefab(preload_data, [SpeedComponentPrefab(9)])),
            "EntityPrefab(preload_data={}, component_prefabs=[SpeedComponentPrefab={}])"
                .format(str(preload_data), str(SpeedComponentPrefab(9)))
        )


if __name__ == "__main__":
    unittest.main()
