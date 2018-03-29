import unittest

from lib.utility.surface.position.position_prefab import *


class TestPositionPrefab(unittest.TestCase):
    def test_position_prefab_to_string(self):
        self.assertEqual(str(PositionPrefab(10, 20)), "PositionPrefab(x=10.0, y=20.0)")


if __name__ == "__main__":
    unittest.main()
