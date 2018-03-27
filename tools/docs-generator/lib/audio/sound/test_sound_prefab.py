import unittest

from lib.audio.sound.sound_prefab import SoundPrefab, SoundPrefabXmlReader, SoundPrefabXmlReadException


class TestSoundPrefab(unittest.TestCase):
    def test_prefab_to_string(self):
        self.assertEqual(
            str(SoundPrefab("FILENAME")),
            "SoundPrefab(filename=FILENAME)"
        )


class TestSoundPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <sound>
                <filename>FILENAME</filename>
            </sound>
        """
        reader = SoundPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_filename(), "FILENAME")

    def test_read_prefab_from_string_invalid(self):
        xml = """<sound />"""
        reader = SoundPrefabXmlReader()

        with self.assertRaises(SoundPrefabXmlReadException):
            reader.read_prefab_from_string(xml)
