import unittest

from lib.graphics.animation.animation_prefab import *


class TestAnimationPrefab(unittest.TestCase):
    def test_file_animation_prefab_to_string(self):
        self.assertEqual(
            str(FileAnimationPrefab(True, False, ["file0", "file1"], 0.5, "TEST")),
            "FileAnimationPrefab(flip_x=True, flip_y=False, filenames=[file0, file1], "
            "frame_duration=0.5, play_mode=TEST)"
        )

    def test_atlas_animation_prefab_to_string(self):
        self.assertEqual(
            str(AtlasAnimationPrefab(False, True, "AtlasFilenameTest", ["region0", "region1"], 1.1, "TEST")),
            "AtlasAnimationPrefab(flip_x=False, flip_y=True, atlas_filename=AtlasFilenameTest, "
            "region_names=[region0, region1], frame_duration=1.1, play_mode=TEST)"
        )


if __name__ == "__main__":
    unittest.main()
