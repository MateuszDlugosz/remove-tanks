import os
import unittest

from lib.graphics.texture.texture_atlas import *

TEXTURE_ATLAS_TEST_FILENAME = os.path.join(os.path.dirname(__file__), 'texture-atlas-test.pack')


class TestTextureAtlas(unittest.TestCase):
    def test_texture_atlas_to_string(self):
        self.assertEqual(
            str(TextureAtlas("test_image_filename", (10, 20), "RGBA8888", ("Nearest", "Nearest"), "none", [
                Region("test_name", False, (1, 2), (100, 200), (4, 5), (10, 20), -1)
            ])),
            "TextureAtlas(image_filename=test_image_filename, size=(10, 20), "
            "format=RGBA8888, filter=('Nearest', 'Nearest'), repeat=none, "
            "regions=[test_name=Region(name=test_name, rotate=False, position=(1, 2), size=(100, 200), origin=(4, 5), "
            "offset=(10, 20), index=-1)])"
        )

    def test_texture_atlas_get_region_invalid_name(self):
        atlas = TextureAtlas("test_image_filename", (10, 20), "RGBA8888", ("Nearest", "Nearest"), "none",
                             [Region("test_name", False, (1, 2), (100, 200), (4, 5), (10, 20), -1)])

        with self.assertRaises(RegionNotFoundException):
            atlas.get_region("unknown_region")


class TestTextureAtlasReader(unittest.TestCase):
    def test_texture_atlas_reader_valid(self):
        reader = TextureAtlasReader()
        atlas = reader.read_from_file(TEXTURE_ATLAS_TEST_FILENAME)

        self.assertEqual(atlas.get_image_filename(), "test_filename.png")
        self.assertEqual(atlas.get_size()[0], 1024)
        self.assertEqual(atlas.get_size()[1], 512)
        self.assertEqual(atlas.get_format(), "RGBA8888")
        self.assertEqual(atlas.get_filter()[0], "Nearest")
        self.assertEqual(atlas.get_filter()[1], "Nearest")
        self.assertEqual(atlas.get_repeat(), "none")
        self.assertEqual(atlas.get_region("test_region_name").get_name(), "test_region_name")
        self.assertFalse(atlas.get_region("test_region_name").get_rotate())
        self.assertEqual(atlas.get_region("test_region_name").get_position()[0], 100)
        self.assertEqual(atlas.get_region("test_region_name").get_position()[1], 200)
        self.assertEqual(atlas.get_region("test_region_name").get_size()[0], 16)
        self.assertEqual(atlas.get_region("test_region_name").get_size()[1], 17)
        self.assertEqual(atlas.get_region("test_region_name").get_origin()[0], 18)
        self.assertEqual(atlas.get_region("test_region_name").get_origin()[1], 19)
        self.assertEqual(atlas.get_region("test_region_name").get_offset()[0], 0)
        self.assertEqual(atlas.get_region("test_region_name").get_offset()[1], 0)
        self.assertEqual(atlas.get_region("test_region_name").get_index(), -1)


class TestRegion(unittest.TestCase):
    def test_region_to_string(self):
        self.assertEqual(
            str(Region("test_name", False, (1, 2), (100, 200), (4, 5), (10, 20), -1)),
            "Region(name=test_name, rotate=False, position=(1, 2), size=(100, 200), "
            "origin=(4, 5), offset=(10, 20), index=-1)"
        )


if __name__ == "__main__":
    pass
