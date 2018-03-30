import os
import unittest

from lib.graphics.texture.texture_atlas_reader import TextureAtlasReader

TEXTURE_ATLAS_TEST_FILENAME = os.path.join(os.path.dirname(__file__), 'test-texture-atlas.pack')


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


if __name__ == "__main__":
    unittest.main()
