import unittest

from lib.physics.filter.filter_prefab import *
from lib.physics.fixture.fixture_prefab import *
from lib.physics.shape.shape_prefab import *
from lib.utility.surface.position.position_prefab import *


class TestFixturePrefab(unittest.TestCase):
    def test_fixture_prefab_to_string(self):
        self.assertEqual(
            str(
                FixturePrefab(
                    FilterPrefab("CategoryBit", "MaskBit"),
                    CircleShapePrefab(PositionPrefab(1, 2), 5),
                    5,
                    4,
                    3,
                    True
                )
            ),
            "FixturePrefab(filter_prefab={}, shape_prefab={}, restitution=5.0, density=4.0, " \
            "friction=3.0, is_sensor=True)"
                .format(str(FilterPrefab("CategoryBit", "MaskBit")), str(CircleShapePrefab(PositionPrefab(1, 2), 5)))
        )


if __name__ == "__main__":
    unittest.main()
