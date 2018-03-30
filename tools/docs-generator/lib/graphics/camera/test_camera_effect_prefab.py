import unittest

from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab


class TestShakeCameraEffectPrefab(unittest.TestCase):
    def test_camera_effect_prefab_to_string(self):
        self.assertEqual(
            str(ShakeCameraEffectPrefab(10, 20)),
            "ShakeCameraEffectPrefab(time=10.0, power=20.0)"
        )


if __name__ == "__main__":
    unittest.main()
