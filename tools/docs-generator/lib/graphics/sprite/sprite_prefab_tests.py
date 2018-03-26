import unittest

from lib.graphics.sprite.sprite_prefab import *


class TestSpritePrefab(unittest.TestCase):
    def test_file_sprite_prefab_to_string(self):
        self.assertEqual(
            str(FileSpritePrefab(True, False, "TestFilename")),
            "FileSpritePrefab(flip_x=True, flip_y=False, filename=TestFilename)"
        )

    def test_atlas_sprite_prefab_to_string(self):
        self.assertEqual(
            str(AtlasSpritePrefab(True, False, "TestAtlasFilename", "TestRegionFilename")),
            "AtlasSpritePrefab(flip_x=True, flip_y=False, atlas_filename=TestAtlasFilename, "
            "region_name=TestRegionFilename)"
        )


class TestSpritePrefabXmlReader(unittest.TestCase):
    def test_file_sprite_prefab_xml_reader_valid(self):
        xml = """
            <sprite type="FileSprite" flipX="true" flipY="false">
                <filename>TestFilename</filename>
            </sprite>
        """
        reader = SubFileSpritePrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        print(prefab)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_filename(), "TestFilename")

    def test_file_sprite_prefab_xml_reader_invalid(self):
        xml = """
            <sprite></sprite>
        """
        reader = SubFileSpritePrefabXmlReader()

        with self.assertRaises(SpritePrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_atlas_sprite_prefab_xml_reader_valid(self):
        xml = """
            <sprite type="AtlasSprite" flipX="true" flipY="false">
                <atlasFilename>TestAtlasFilename</atlasFilename>
                <regionName>TestRegionName</regionName>
            </sprite>
        """
        reader = SubAtlasSpritePrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_atlas_filename(), "TestAtlasFilename")
        self.assertEqual(prefab.get_region_name(), "TestRegionName")

    def test_atlas_sprite_prefab_xml_reader_invalid(self):
        xml = """
            <sprite></sprite>
        """
        reader = SubAtlasSpritePrefabXmlReader()

        with self.assertRaises(SpritePrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_sprite_prefab_xml_reader_valid(self):
        xml = """
            <sprite type="AtlasSprite" flipX="true" flipY="false">
                <atlasFilename>TestAtlasFilename</atlasFilename>
                <regionName>TestRegionName</regionName>
            </sprite>
        """
        reader = SpritePrefabXmlReader([SubAtlasSpritePrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_atlas_filename(), "TestAtlasFilename")
        self.assertEqual(prefab.get_region_name(), "TestRegionName")

    def test_sprite_prefab_xml_reader_invalid(self):
        xml = """
            <sprite type="UnknownSpriteType"></sprite>
        """
        reader = SpritePrefabXmlReader([])

        with self.assertRaises(SpritePrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
