import unittest

from lib.physics.filter.filter_prefab_xml_reader import FilterPrefabXmlReader
from lib.physics.fixture.fixture_prefab_xml_reader import FixturePrefabXmlReader, FixturePrefabXmlReadException
from lib.physics.shape.shape_prefab_xml_reader import ShapePrefabXmlReader, SubCircleShapePrefabXmlReader
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class TestFixturePrefabXmlReader(unittest.TestCase):
    def test_fixture_prefab_xml_reader_valid(self):
        xml = """
            <fixture>
                <shape type="CircleShape">
                    <radius>2</radius>
                    <position>
                        <x>10</x>
                        <y>20</y>
                    </position>
                </shape>
                <filter>
                    <categoryBit>CategoryBit</categoryBit>
                    <maskBit>MaskBit</maskBit>
                </filter>
                <restitution>1</restitution>
                <density>5</density>
                <friction>8</friction>
            </fixture>
        """
        reader = FixturePrefabXmlReader(
            FilterPrefabXmlReader(),
            ShapePrefabXmlReader([SubCircleShapePrefabXmlReader(PositionPrefabXmlReader())])
        )
        prefab = reader.read_prefab_from_string(xml, True)

        self.assertEqual(prefab.get_shape_prefab().get_position_prefab().get_x(), 10)
        self.assertEqual(prefab.get_shape_prefab().get_position_prefab().get_y(), 20)
        self.assertEqual(prefab.get_shape_prefab().get_radius(), 2)
        self.assertEqual(prefab.get_filter_prefab().get_category_bit(), "CategoryBit")
        self.assertEqual(prefab.get_filter_prefab().get_mask_bit(), "MaskBit")
        self.assertEqual(prefab.get_restitution(), 1)
        self.assertEqual(prefab.get_density(), 5)
        self.assertEqual(prefab.get_friction(), 8)
        self.assertEqual(prefab.get_is_sensor(), True)

    def test_fixture_prefab_xml_reader_invalid(self):
        xml = """
            <fixture></fixture>
        """
        reader = FixturePrefabXmlReader(FilterPrefabXmlReader(), ShapePrefabXmlReader([]))

        with self.assertRaises(FixturePrefabXmlReadException):
            reader.read_prefab_from_string(xml, True)


if __name__ == "__main__":
    unittest.main()
