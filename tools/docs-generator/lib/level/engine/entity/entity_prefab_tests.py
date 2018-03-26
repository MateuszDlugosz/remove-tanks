import unittest

from lib.level.engine.entity.component.component_prefab import SpeedComponentPrefab
from lib.level.engine.entity.entity_prefab import *


class TestEntityPrefab(unittest.TestCase):
    def test_entity_prefab_to_string(self):
        self.assertEqual(
            str(EntityPrefab([SpeedComponentPrefab(9)])),
            "EntityPrefab(component_prefabs=[SpeedComponentPrefab={}])"
                .format(str(SpeedComponentPrefab(9)))
        )


if __name__ == "__main__":
    unittest.main()
