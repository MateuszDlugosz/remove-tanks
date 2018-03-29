import unittest

from lib.physics.filter.filter_prefab_xml_reader import FilterPrefabXmlReader, FilterPrefabXmlReadException


class TestFilterPrefabXmlReader(unittest.TestCase):
    def test_read_filter_prefab_from_string_valid(self):
        xml = """
            <filter>
                <categoryBit>CategoryBit</categoryBit>
                <maskBit>MaskBit</maskBit>
            </filter>
        """
        reader = FilterPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_category_bit(), "CategoryBit")
        self.assertEqual(prefab.get_mask_bit(), "MaskBit")

    def test_read_filter_prefab_from_string_invalid(self):
        xml = """
            <filter>
                <categoryBit>CategoryBit</categoryBit>
            </filter>
        """
        reader = FilterPrefabXmlReader()

        with self.assertRaises(FilterPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
