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


if __name__ == "__main__":
    unittest.main()
