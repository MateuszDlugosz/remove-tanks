import unittest

from lib.graphics.particles.particle_effect_prefab_xml_reader import SubFileParticleEffectPrefabXmlReader, \
    ParticleEffectPrefabXmlReadException, SubAtlasParticleEffectPrefabXmlReader, ParticleEffectPrefabXmlReader


class TestSubFileParticleEffectPrefabXmlReader(unittest.TestCase):
    def test_file_particle_effect_prefab_xml_reader_valid(self):
        xml = """
            <particleEffect type="FileParticleEffect" flipX="true" flipY="false">
                <filename>test_filename</filename>
                <imagesDirectory>test_images_directory</imagesDirectory>
            </particleEffect>
        """
        reader = SubFileParticleEffectPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_filename(), "test_filename")
        self.assertEqual(prefab.get_images_dir(), "test_images_directory")

    def test_file_particle_effect_prefab_xml_reader_invalid(self):
        xml = """
            <particleEffect type="FileParticleEffect"></particleEffect>
        """
        reader = SubFileParticleEffectPrefabXmlReader()

        with self.assertRaises(ParticleEffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubAtlasParticleEffectPrefabXmlReader(unittest.TestCase):
    def test_atlas_particle_effect_prefab_xml_reader_valid(self):
        xml = """
            <particleEffect type="AtlasParticleEffect" flipX="true" flipY="false">
                <atlasFilename>test_atlas_filename</atlasFilename>
                <filename>test_filename</filename>
            </particleEffect>
        """
        reader = SubAtlasParticleEffectPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_filename(), "test_filename")
        self.assertEqual(prefab.get_atlas_filename(), "test_atlas_filename")

    def test_atlas_particle_effect_prefab_xml_reader_invalid(self):
        xml = """
            <particleEffect type="AtlasParticleEffect"></particleEffect>
        """
        reader = SubAtlasParticleEffectPrefabXmlReader()

        with self.assertRaises(ParticleEffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestParticleEffectPrefabXmlReader(unittest.TestCase):
    def test_particle_effect_prefab_xml_reader_valid(self):
        xml = """
            <particleEffect type="FileParticleEffect" flipX="true" flipY="false">
                <filename>test_filename</filename>
                <imagesDirectory>test_images_directory</imagesDirectory>
            </particleEffect>
        """
        reader = ParticleEffectPrefabXmlReader([SubFileParticleEffectPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertTrue(prefab.get_flip_x())
        self.assertFalse(prefab.get_flip_y())
        self.assertEqual(prefab.get_filename(), "test_filename")
        self.assertEqual(prefab.get_images_dir(), "test_images_directory")

    def test_particle_effect_prefab_xml_reader_invalid(self):
        xml = """
            <particleEffect type="UnknownType">
            </particleEffect>
        """
        reader = ParticleEffectPrefabXmlReader([])

        with self.assertRaises(ParticleEffectPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
