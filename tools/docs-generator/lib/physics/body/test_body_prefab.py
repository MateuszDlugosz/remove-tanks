import unittest

from lib.physics.body.body_prefab import *


class TestBodyPrefab(unittest.TestCase):
    def test_body_prefab_to_string(self):
        self.assertEqual(
            str(BodyPrefab("StaticBody", True, False, False, True, False, 1, 10, 2, 8)),
            "BodyPrefab(body_type=StaticBody, active=True, allow_sleep=False, awake=False, bullet=True, "
            "fixed_rotation=False, gravity_scale=1.0, angle=10.0, angular_damping=2.0, linear_damping=8.0)"
        )


if __name__ == "__main__":
    unittest.main()
