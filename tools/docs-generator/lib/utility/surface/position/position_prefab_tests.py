import unittest

from lib.utility.surface.position.position_prefab import *


class PositionPrefabTest(unittest.TestCase):
    def test_position_prefab_to_string(self):
        self.assertEqual(str(PositionPrefab(10, 20)), "PositionPrefab(x=10.0, y=20.0)")


class PositionPrefabXmlReaderTest(unittest.TestCase):
    def test_read_position_prefab_from_string_valid(self):
        self.assertEqual(
            str(PositionPrefabXmlReader().read_prefab_from_string("<position><x>10</x><y>11</y></position>")),
            "PositionPrefab(x=10.0, y=11.0)"
        )
        self.assertEqual(
            str(PositionPrefabXmlReader().read_prefab_from_string("<position><x>10.6</x><y>11.11</y></position>")),
            "PositionPrefab(x=10.6, y=11.11)"
        )

    def test_read_position_prefab_from_string_invalid(self):
        xml = "<position><x>1</x></position>"
        reader = PositionPrefabXmlReader()

        with self.assertRaises(PositionPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
