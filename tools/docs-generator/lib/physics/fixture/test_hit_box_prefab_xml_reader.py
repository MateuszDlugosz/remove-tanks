import unittest

from lib.physics.filter.filter_prefab_xml_reader import FilterPrefabXmlReader
from lib.physics.fixture.fixture_prefab_xml_reader import FixturePrefabXmlReader
from lib.physics.fixture.hit_box_prefab_xml_reader import HitBoxPrefabXmlReadException, HitBoxPrefabXmlReader
from lib.physics.shape.shape_prefab_xml_reader import ShapePrefabXmlReader, SubCircleShapePrefabXmlReader
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class TestHitBoxPrefabXmlReader(unittest.TestCase):
    def test_hit_box_prefab_xml_reader_valid(self):
        xml = """
            <hitBox id="TestID">
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
            </hitBox>
        """
        reader = HitBoxPrefabXmlReader(
            FixturePrefabXmlReader(
                FilterPrefabXmlReader(),
                ShapePrefabXmlReader([SubCircleShapePrefabXmlReader(PositionPrefabXmlReader())])
            )
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_fixture_prefab().get_shape_prefab().get_position_prefab().get_x(), 10)
        self.assertEqual(prefab.get_fixture_prefab().get_shape_prefab().get_position_prefab().get_y(), 20)
        self.assertEqual(prefab.get_fixture_prefab().get_shape_prefab().get_radius(), 2)
        self.assertEqual(prefab.get_fixture_prefab().get_filter_prefab().get_category_bit(), "CategoryBit")
        self.assertEqual(prefab.get_fixture_prefab().get_filter_prefab().get_mask_bit(), "MaskBit")
        self.assertEqual(prefab.get_fixture_prefab().get_restitution(), 1)
        self.assertEqual(prefab.get_fixture_prefab().get_density(), 5)
        self.assertEqual(prefab.get_fixture_prefab().get_friction(), 8)
        self.assertEqual(prefab.get_fixture_prefab().get_is_sensor(), False)

    def test_hit_box_prefab_xml_reader_invalid(self):
        xml = """
            <hitBox></hitBox>
        """
        reader = HitBoxPrefabXmlReader(
            FixturePrefabXmlReader(
                FilterPrefabXmlReader(),
                ShapePrefabXmlReader([])
            )
        )

        with self.assertRaises(HitBoxPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_hit_box_prefabs_xml_reader_valid(self):
        xml = """
            <hitBoxes>
                <hitBox id="TestID0">
                    <fixture>
                        <shape type="CircleShape">
                            <radius>2</radius>
                            <position>
                                <x>10</x>
                                <y>20</y>
                            </position>
                        </shape>
                        <filter>
                            <categoryBit>CategoryBit0</categoryBit>
                            <maskBit>MaskBit0</maskBit>
                        </filter>
                        <restitution>1</restitution>
                        <density>5</density>
                        <friction>8</friction>
                    </fixture>
                </hitBox>
                <hitBox id="TestID1">
                    <fixture>
                        <shape type="CircleShape">
                            <radius>21</radius>
                            <position>
                                <x>101</x>
                                <y>201</y>
                            </position>
                        </shape>
                        <filter>
                            <categoryBit>CategoryBit1</categoryBit>
                            <maskBit>MaskBit1</maskBit>
                        </filter>
                        <restitution>11</restitution>
                        <density>51</density>
                        <friction>81</friction>
                    </fixture>
                </hitBox>
            </hitBoxes>
        """
        reader = HitBoxPrefabXmlReader(
            FixturePrefabXmlReader(
                FilterPrefabXmlReader(),
                ShapePrefabXmlReader([SubCircleShapePrefabXmlReader(PositionPrefabXmlReader())])
            )
        )
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(prefabs[0].get_id(), "TestID0")
        self.assertEqual(prefabs[0].get_fixture_prefab().get_shape_prefab().get_position_prefab().get_x(), 10)
        self.assertEqual(prefabs[0].get_fixture_prefab().get_shape_prefab().get_position_prefab().get_y(), 20)
        self.assertEqual(prefabs[0].get_fixture_prefab().get_shape_prefab().get_radius(), 2)
        self.assertEqual(prefabs[0].get_fixture_prefab().get_filter_prefab().get_category_bit(), "CategoryBit0")
        self.assertEqual(prefabs[0].get_fixture_prefab().get_filter_prefab().get_mask_bit(), "MaskBit0")
        self.assertEqual(prefabs[0].get_fixture_prefab().get_restitution(), 1)
        self.assertEqual(prefabs[0].get_fixture_prefab().get_density(), 5)
        self.assertEqual(prefabs[0].get_fixture_prefab().get_friction(), 8)
        self.assertEqual(prefabs[0].get_fixture_prefab().get_is_sensor(), False)

        self.assertEqual(prefabs[1].get_id(), "TestID1")
        self.assertEqual(prefabs[1].get_fixture_prefab().get_shape_prefab().get_position_prefab().get_x(), 101)
        self.assertEqual(prefabs[1].get_fixture_prefab().get_shape_prefab().get_position_prefab().get_y(), 201)
        self.assertEqual(prefabs[1].get_fixture_prefab().get_shape_prefab().get_radius(), 21)
        self.assertEqual(prefabs[1].get_fixture_prefab().get_filter_prefab().get_category_bit(), "CategoryBit1")
        self.assertEqual(prefabs[1].get_fixture_prefab().get_filter_prefab().get_mask_bit(), "MaskBit1")
        self.assertEqual(prefabs[1].get_fixture_prefab().get_restitution(), 11)
        self.assertEqual(prefabs[1].get_fixture_prefab().get_density(), 51)
        self.assertEqual(prefabs[1].get_fixture_prefab().get_friction(), 81)
        self.assertEqual(prefabs[1].get_fixture_prefab().get_is_sensor(), False)

    def test_hit_box_prefabs_xml_read_invalid(self):
        xml = """
            <hitBoxes>
                <hitBox></hitBox>
            </hitBoxes>
        """
        reader = HitBoxPrefabXmlReader(
            FixturePrefabXmlReader(
                FilterPrefabXmlReader(),
                ShapePrefabXmlReader([])
            )
        )

        with self.assertRaises(HitBoxPrefabXmlReadException):
            reader.read_prefabs_from_string(xml)


if __name__ == "__main__":
    unittest.main()
