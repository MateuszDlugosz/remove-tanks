import unittest

from lib.graphics.particles.particle_effect_prefab import FileParticleEffectPrefab, AtlasParticleEffectPrefab


class TestParticleEffectPrefab(unittest.TestCase):
    def test_file_particle_effect_prefab_to_string(self):
        self.assertEqual(
            str(FileParticleEffectPrefab(True, False, "test_filename", "test_images_dir")),
            "FileParticleEffectPrefab(flip_x=True, flip_y=False, filename=test_filename, images_dir=test_images_dir)"
        )

    def test_atlas_particle_effect_prefab_to_string(self):
        self.assertEqual(
            str(AtlasParticleEffectPrefab(False, True, "test_filename", "test_atlas_filename")),
            "AtlasParticleEffectPrefab(flip_x=False, flip_y=True, filename=test_filename, "
            "atlas_filename=test_atlas_filename)"
        )


if __name__ == "__main__":
    pass
