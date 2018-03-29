import unittest

from lib.graphics.color.color_prefab import *
from lib.physics.light.light_prefab import *
from lib.utility.surface.position.position_prefab import *


class TestLightPrefab(unittest.TestCase):
    def test_point_light_prefab_to_string(self):
        self.assertEqual(
            str(PointLightPrefab(RgbColorPrefab(1, 2, 3), True, PositionPrefab(1, 2), 10)),
            "PointLightPrefab(color_prefab={}, x_ray=True, position_prefab={}, distance=10.0)"
                .format(str(RgbColorPrefab(1, 2, 3)), str(PositionPrefab(1, 2)))
        )

    def test_directional_light_prefab_to_string(self):
        self.assertEqual(
            str(DirectionalLightPrefab(HexColorPrefab("CCAAFFEE"), False, 3)),
            "DirectionalLightPrefab(color_prefab={}, x_ray=False, direction_degree=3.0)"
                .format(str(HexColorPrefab("CCAAFFEE")))
        )

    def test_cone_light_prefab_to_string(self):
        self.assertEqual(
            str(ConeLightPrefab(HexColorPrefab("CCAAFFEE"), True, PositionPrefab(1, 2), 10, 20, 30)),
            "ConeLightPrefab(color_prefab={}, x_ray=True, position_prefab={}, distance=10.0, "
            "direction_degree=20.0, cone_degree=30.0)"
                .format(str(HexColorPrefab("CCAAFFEE")), str(PositionPrefab(1, 2)))
        )


if __name__ == "__main__":
    unittest.main()
