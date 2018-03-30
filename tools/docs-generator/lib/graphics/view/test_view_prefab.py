import unittest

from lib.graphics.animation.animation_prefab import FileAnimationPrefab
from lib.graphics.particles.particle_effect_prefab import FileParticleEffectPrefab
from lib.graphics.sprite.sprite_prefab import FileSpritePrefab
from lib.graphics.view.view_prefab import SpriteViewPrefab, AnimationViewPrefab, ParticleEffectViewPrefab
from lib.utility.surface.position.position_prefab import PositionPrefab


class TestViewPrefab(unittest.TestCase):
    def test_sprite_view_prefab_to_string(self):
        self.assertEqual(
            str(SpriteViewPrefab("test_id", PositionPrefab(1, 2), FileSpritePrefab(True, False, "test_filename"))),
            "SpriteViewPrefab(id=test_id, position_prefab={}, sprite_prefab={})"
                .format(str(PositionPrefab(1, 2)), str(FileSpritePrefab(True, False, "test_filename")))
        )

    def test_animation_view_prefab_to_string(self):
        self.assertEqual(
            str(AnimationViewPrefab("test_id", PositionPrefab(1, 2),
                                    FileAnimationPrefab(True, False, ["file0", "file1"], 0.4, "test_play_mode"))),
            "AnimationViewPrefab(id=test_id, position_prefab={}, animation_prefab={})"
                .format(str(PositionPrefab(1, 2)),
                        str(FileAnimationPrefab(True, False, ["file0", "file1"], 0.4, "test_play_mode")))
        )

    def test_particle_effect_view_prefab_to_string(self):
        self.assertEqual(
            str(ParticleEffectViewPrefab("test_id", PositionPrefab(1, 2),
                                         FileParticleEffectPrefab(False, False, "test_filename", "test_images_dir"))),
            "ParticleEffectViewPrefab(id=test_id, position_prefab={}, particle_effect_prefab={})"
                .format(str(PositionPrefab(1, 2)),
                        str(FileParticleEffectPrefab(False, False, "test_filename", "test_images_dir")))
        )


if __name__ == "__main__":
    unittest.main()
