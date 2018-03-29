import unittest

from lib.physics.shape.vertex_prefab_xml_reader import VertexPrefabXmlReadException, VertexPrefabXmlReader


class TestVertexPrefabXmlReader(unittest.TestCase):
    def test_read_vertex_prefab_from_string_valid(self):
        xml = """<vertex x="1" y="2" />"""
        reader = VertexPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_x(), 1)
        self.assertEqual(prefab.get_y(), 2)

    def test_read_vertex_prefab_from_string_invalid(self):
        xml = """<vertex x="1" />"""
        reader = VertexPrefabXmlReader()

        with self.assertRaises(VertexPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_read_prefabs_from_string_valid(self):
        xml = """
            <vertices>
              <vertex x="1" y="2" />
              <vertex x="3" y="4" />
            </vertices>
        """
        reader = VertexPrefabXmlReader()
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(prefabs[0].get_x(), 1)
        self.assertEqual(prefabs[0].get_y(), 2)
        self.assertEqual(prefabs[1].get_x(), 3)
        self.assertEqual(prefabs[1].get_y(), 4)

    def test_read_vertex_prefabs_from_string_invalid(self):
        xml = """
            <vertices>
                <vertex x="1" />
            <vertices>
        """
        reader = VertexPrefabXmlReader()

        with self.assertRaises(VertexPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
