import unittest

from lib.audio.music.music_prefab_xml_reader import MusicPrefabXmlReader, MusicPrefabXmlReadException


class TestMusicPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <music>
                <filename>FILENAME</filename>
            </music>
        """
        reader = MusicPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_filename(), "FILENAME")

    def test_read_prefab_from_string_invalid(self):
        xml = """<music />"""
        reader = MusicPrefabXmlReader()

        with self.assertRaises(MusicPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
