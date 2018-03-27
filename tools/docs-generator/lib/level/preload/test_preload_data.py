import unittest

from lib.level.preload.preload_data import PreloadDataXmlReader, PreloadDataXmlReadException


class TestPreloadDataXmlReader(unittest.TestCase):
    def test_read_from_string_valid(self):
        xml = """
            <preloadData>
                <entityPrefabCodes>
                    <entityPrefabCode>CODE_0</entityPrefabCode>
                    <entityPrefabCode>CODE_1</entityPrefabCode>
                </entityPrefabCodes>
                <assetIds>
                    <assetId>ID_0</assetId>
                    <assetId>ID_1</assetId>
                    <assetId>ID_2</assetId>
                </assetIds>
            </preloadData>
        """
        reader = PreloadDataXmlReader()
        data = reader.read_from_xml(xml)

        self.assertEqual(len(data.get_asset_ids()), 3)
        self.assertEqual(len(data.get_entity_prefab_codes()), 2)

    def test_read_from_string_invalid(self):
        xml = """
            <preloadData>
                <entityPrefabCodes>
                    <entityPrefabCode />
                </entityPrefabCodes>
            </preloadData>
        """
        reader = PreloadDataXmlReader()

        with self.assertRaises(PreloadDataXmlReadException):
            reader.read_from_xml(xml)
