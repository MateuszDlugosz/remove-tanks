import unittest

from lib.physics.filter.filter_prefab import FilterPrefab
from lib.physics.fixture.fixture_prefab import FixturePrefab
from lib.physics.fixture.sensor_prefab import SensorPrefab
from lib.physics.shape.shape_prefab import CircleShapePrefab
from lib.utility.surface.position.position_prefab import PositionPrefab


class TestSensorPrefab(unittest.TestCase):
    def test_sensor_prefab_to_string(self):
        self.assertEqual(
            str(
                SensorPrefab(
                    "TestID",
                    FixturePrefab(
                        FilterPrefab("CategoryBit", "MaskBit"),
                        CircleShapePrefab(
                            PositionPrefab(1, 2),
                            5
                        ),
                        5,
                        4,
                        3,
                        True
                    )
                )
            ),
            "SensorPrefab(id=TestID, fixture_prefab=FixturePrefab("
            "filter_prefab=FilterPrefab(category_bit=CategoryBit, mask_bit=MaskBit), "
            "shape_prefab=CircleShapePrefab(position_prefab=PositionPrefab(x=1.0, y=2.0), radius=5.0), "
            "restitution=5.0, density=4.0, friction=3.0, is_sensor=True))"
        )


if __name__ == "__main__":
    unittest.main()
