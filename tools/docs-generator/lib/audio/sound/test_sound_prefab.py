import unittest

from lib.audio.sound.sound_prefab import SoundPrefab


class TestSoundPrefab(unittest.TestCase):
    def test_prefab_to_string(self):
        self.assertEqual(
            str(SoundPrefab("FILENAME")),
            "SoundPrefab(filename=FILENAME)"
        )


if __name__ == "__main__":
    unittest.main()
