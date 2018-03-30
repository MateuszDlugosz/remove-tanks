import unittest

from lib.graphics.animation.animation_prefab_xml_reader import AnimationPrefabXmlReader, \
    AnimationPrefabXmlReadException, SubFileAnimationPrefabXmlReader, SubAtlasAnimationPrefabXmlReader


class TestSubAtlasAnimationPrefabXmlReader(unittest.TestCase):
    def test_atlas_animation_prefab_xml_reader_valid(self):
        xml = """
            <animation type="AtlasAnimation" flipX="true" flipY="false" atlasFilename="TestAtlasFilename" 
                       playMode="TEST" frameDuration="1.1">
                <frame regionName="test0" />
                <frame regionName="test1" />
            </animation>
        """
        reader = SubAtlasAnimationPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_atlas_filename(), "TestAtlasFilename")
        self.assertEqual(prefab.get_play_mode(), "TEST")
        self.assertEqual(prefab.get_frame_duration(), 1.1)
        self.assertEqual(prefab.get_region_names()[0], "test0")
        self.assertEqual(prefab.get_region_names()[1], "test1")

    def test_atlas_animation_prefab_xml_reader_invalid(self):
        xml = """
            <animation></animation>
        """
        reader = SubAtlasAnimationPrefabXmlReader()

        with self.assertRaises(AnimationPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubFileAnimationPrefabXmlReader(unittest.TestCase):
    def test_file_animation_prefab_xml_reader_valid(self):
        xml = """
            <animation type="FileAnimation" flipX="true" flipY="false" playMode="TEST" frameDuration="1.1">
                <frame filename="test0" />
                <frame filename="test1" />
            </animation>
        """
        reader = SubFileAnimationPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_play_mode(), "TEST")
        self.assertEqual(prefab.get_frame_duration(), 1.1)
        self.assertEqual(prefab.get_filenames()[0], "test0")
        self.assertEqual(prefab.get_filenames()[1], "test1")

    def test_file_animation_prefab_xml_reader_invalid(self):
        xml = """
            <animation></animation>
        """
        reader = SubFileAnimationPrefabXmlReader()

        with self.assertRaises(AnimationPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestAnimationPrefabXmlReader(unittest.TestCase):
    def test_animation_prefab_xml_reader_valid(self):
        xml = """
            <animation type="FileAnimation" flipX="true" flipY="false" playMode="TEST" frameDuration="1.1">
                <frame filename="test0" />
                <frame filename="test1" />
            </animation>
        """
        reader = AnimationPrefabXmlReader([SubFileAnimationPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_play_mode(), "TEST")
        self.assertEqual(prefab.get_frame_duration(), 1.1)
        self.assertEqual(prefab.get_filenames()[0], "test0")
        self.assertEqual(prefab.get_filenames()[1], "test1")

    def test_animation_prefab_xml_reader_invalid(self):
        xml = """
            <animation type="UnknownAnimationType"></animation>
        """
        reader = AnimationPrefabXmlReader([])

        with self.assertRaises(AnimationPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()