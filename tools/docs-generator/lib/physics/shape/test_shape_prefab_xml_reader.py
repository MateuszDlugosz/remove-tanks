import unittest

from lib.physics.shape.shape_prefab_xml_reader import SubRectangleShapePrefabXmlReader, ShapePrefabXmlReadException, \
    SubCircleShapePrefabXmlReader, SubPolygonShapePrefabXmlReader, SubChainShapePrefabXmlReader, ShapePrefabXmlReader
from lib.physics.shape.vertex_prefab_xml_reader import VertexPrefabXmlReader
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class TestShapePrefabXmlReader(unittest.TestCase):
    def test_rectangle_shape_prefab_xml_reader_valid(self):
        xml = """
            <shape type="RectangleShape">
                <width>10</width>
                <height>20</height>
                <position>
                    <x>1</x>
                    <y>2</y>
                </position>
            </shape>
        """
        reader = SubRectangleShapePrefabXmlReader(PositionPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_width(), 10)
        self.assertEqual(prefab.get_height(), 20)
        self.assertEqual(prefab.get_position_prefab().get_x(), 1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2)

    def test_rectangle_shape_prefab_xml_reader_invalid(self):
        xml = """
            <shape type="RectangleShape">
                <width>10</width>
            </shape>
        """
        reader = SubRectangleShapePrefabXmlReader(PositionPrefabXmlReader())

        with self.assertRaises(ShapePrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_circle_shape_prefab_xml_reader_valid(self):
        xml = """
            <shape type="CircleShape">
                <radius>10</radius>
                <position>
                    <x>1</x>
                    <y>2</y>
                </position>
            </shape>
        """
        reader = SubCircleShapePrefabXmlReader(PositionPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_radius(), 10)
        self.assertEqual(prefab.get_position_prefab().get_x(), 1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2)

    def test_circle_shape_prefab_xml_reader_invalid(self):
        xml = """
            <shape type="CircleShape">
                <radius />
            </shape>
        """
        reader = SubCircleShapePrefabXmlReader(PositionPrefabXmlReader())

        with self.assertRaises(ShapePrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_polygon_shape_prefab_xml_read_valid(self):
        xml = """
            <shape type="PolygonShape">
                <position>
                    <x>1</x>
                    <y>2</y>
                </position>
                <vertices>
                    <vertex x="1" y="2" />
                    <vertex x="3" y="4" />
                </vertices>
            </shape>
        """
        reader = SubPolygonShapePrefabXmlReader(PositionPrefabXmlReader(), VertexPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_position_prefab().get_x(), 1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2)
        self.assertEqual(prefab.get_vertices()[0].get_x(), 1)
        self.assertEqual(prefab.get_vertices()[0].get_y(), 2)
        self.assertEqual(prefab.get_vertices()[1].get_x(), 3)
        self.assertEqual(prefab.get_vertices()[1].get_y(), 4)

    def test_polygon_shape_prefab_xml_read_invalid(self):
        xml = """
            <shape type="PolygonShape'>                 
                <vertices>
                    <vertex x="1" />
                </vertices>                
            </shape>
        """
        reader = SubPolygonShapePrefabXmlReader(PositionPrefabXmlReader(), VertexPrefabXmlReader())

        with self.assertRaises(ShapePrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_chain_shape_prefab_xml_read_valid(self):
        xml = """
            <shape type="ChainShape">
                <position>
                    <x>1</x>
                    <y>2</y>
                </position>
                <vertices>
                    <vertex x="1" y="2" />
                    <vertex x="3" y="4" />
                </vertices>
            </shape>
        """
        reader = SubChainShapePrefabXmlReader(PositionPrefabXmlReader(), VertexPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_position_prefab().get_x(), 1)
        self.assertEqual(prefab.get_position_prefab().get_y(), 2)
        self.assertEqual(prefab.get_vertices()[0].get_x(), 1)
        self.assertEqual(prefab.get_vertices()[0].get_y(), 2)
        self.assertEqual(prefab.get_vertices()[1].get_x(), 3)
        self.assertEqual(prefab.get_vertices()[1].get_y(), 4)

    def test_chain_shape_prefab_xml_read_invalid(self):
        xml = """
            <shape type="ChainShape'>                 
                <vertices>
                    <vertex x="1" />
                </vertices>                
            </shape>
        """
        reader = SubChainShapePrefabXmlReader(PositionPrefabXmlReader(), VertexPrefabXmlReader())

        with self.assertRaises(ShapePrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_shape_prefab_xml_read_valid(self):
        xml = """
            <shape type="CircleShape">
                <radius>10</radius>
                <position>
                    <x>10</x>
                    <y>20</y>
                </position>
            </shape>
        """
        reader = ShapePrefabXmlReader([SubCircleShapePrefabXmlReader(PositionPrefabXmlReader())])
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_radius(), 10)
        self.assertEqual(prefab.get_position_prefab().get_x(), 10)
        self.assertEqual(prefab.get_position_prefab().get_y(), 20)

    def test_shape_prefab_xml_read_invalid(self):
        xml = "<shape type=\"UnknownShapeType\" />"
        reader = ShapePrefabXmlReader([])

        with self.assertRaises(ShapePrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
