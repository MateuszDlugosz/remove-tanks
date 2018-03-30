import unittest

from lib.graphics.texture.texture_atlas import *


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


class TestRegion(unittest.TestCase):
    def test_region_to_string(self):
        self.assertEqual(
            str(Region("test_name", False, (1, 2), (100, 200), (4, 5), (10, 20), -1)),
            "Region(name=test_name, rotate=False, position=(1, 2), size=(100, 200), "
            "origin=(4, 5), offset=(10, 20), index=-1)"
        )


if __name__ == "__main__":
    pass
