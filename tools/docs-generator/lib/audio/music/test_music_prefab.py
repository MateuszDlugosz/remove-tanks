import unittest

from lib.audio.music.music_prefab import MusicPrefab


class TestMusicPrefab(unittest.TestCase):
    def test_prefab_to_string(self):
        self.assertEqual(
            str(MusicPrefab("FILENAME")),
            "MusicPrefab(filename=FILENAME)"
        )


if __name__ == "__main__":
    unittest.main()

