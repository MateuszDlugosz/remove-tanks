import unittest

from lib.level.utility.create.create_entry_prefab_xml_reader import CreateEntryPrefabXmlReader, \
    CreateEntryPrefabXmlReadException
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class TestCreateEntryPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <createEntry>
                <entityPrefabCode>Test</entityPrefabCode>
                <position>
                    <x>2.2</x>
                    <y>1.2</y>
                </position>
            </createEntry>
        """
        reader = CreateEntryPrefabXmlReader(PositionPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual("Test", prefab.get_prefab_code())
        self.assertEqual(2.2, prefab.get_position_prefab().get_x())
        self.assertEqual(1.2, prefab.get_position_prefab().get_y())

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <createEntry />
        """
        reader = CreateEntryPrefabXmlReader(PositionPrefabXmlReader())

        with self.assertRaises(CreateEntryPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_read_prefabs_from_string_valid(self):
        xml = """
            <createEntries>
                <createEntry>
                    <entityPrefabCode>Test0</entityPrefabCode>
                    <position>
                        <x>2.2</x>
                        <y>1.2</y>
                    </position>
                </createEntry>
                <createEntry>
                    <entityPrefabCode>Test1</entityPrefabCode>
                    <position>
                        <x>4.1</x>
                        <y>2.8</y>
                    </position>
                </createEntry>
            </createEntries>
        """
        reader = CreateEntryPrefabXmlReader(PositionPrefabXmlReader())
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual("Test0", prefabs[0].get_prefab_code())
        self.assertEqual(2.2, prefabs[0].get_position_prefab().get_x())
        self.assertEqual(1.2, prefabs[0].get_position_prefab().get_y())
        self.assertEqual("Test1", prefabs[1].get_prefab_code())
        self.assertEqual(4.1, prefabs[1].get_position_prefab().get_x())
        self.assertEqual(2.8, prefabs[1].get_position_prefab().get_y())

    def test_read_prefabs_from_string_invalid(self):
        xml = """
            <createEntries>
                <createEntry />
            </createEntries>
        """
        reader = CreateEntryPrefabXmlReader(PositionPrefabXmlReader())

        with self.assertRaises(CreateEntryPrefabXmlReadException):
            reader.read_prefabs_from_string(xml)


if __name__ == "__main__":
    unittest.main()
