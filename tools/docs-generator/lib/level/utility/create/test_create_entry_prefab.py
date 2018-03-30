import unittest

from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab
from lib.utility.surface.position.position_prefab import PositionPrefab


class TestCreateEntryPrefab(unittest.TestCase):
    def test_create_entry_prefab_to_string(self):
        self.assertEqual(
            str(CreateEntryPrefab("TestPrefabCode", PositionPrefab(2, 4.1))),
            "CreateEntryPrefab(prefab_code=TestPrefabCode, position_prefab={})"
                .format(str(PositionPrefab(2, 4.1)))
        )


if __name__ == "__main__":
    unittest.main()
