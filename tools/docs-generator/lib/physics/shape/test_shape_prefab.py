import unittest

from lib.physics.shape.shape_prefab import *
from lib.physics.shape.vertex_prefab import VertexPrefab
from lib.utility.surface.position.position_prefab import PositionPrefab


class TestShapePrefab(unittest.TestCase):
    def test_rectangle_shape_prefab_to_string(self):
        self.assertEqual(
            str(RectangleShapePrefab(PositionPrefab(1, 2), 10, 20)),
            "RectangleShapePrefab(position_prefab={}, width=10.0, height=20.0)"
                .format(str(PositionPrefab(1, 2)))
        )

    def test_circle_shape_prefab_to_string(self):
        self.assertEqual(
            str(CircleShapePrefab(PositionPrefab(1, 2), 10)),
            "CircleShapePrefab(position_prefab={}, radius=10.0)"
                .format(str(PositionPrefab(1, 2)))
        )

    def test_polygon_shape_prefab_to_string(self):
        self.assertEqual(
            str(PolygonShapePrefab(PositionPrefab(1, 2), [VertexPrefab(10, 20), VertexPrefab(30, 40)])),
            "PolygonShapePrefab(position_prefab={}, vertices=[{}, {}])"
                .format(str(PositionPrefab(1, 2)), str(VertexPrefab(x=10.0, y=20.0)), str(VertexPrefab(x=30.0, y=40.0)))
        )

    def test_chain_shape_prefab_to_string(self):
        self.assertEqual(
            str(ChainShapePrefab(PositionPrefab(1, 2), [VertexPrefab(10, 20), VertexPrefab(30, 40)])),
            "ChainShapePrefab(position_prefab={}, vertices=[{}, {}])"
                .format(str(PositionPrefab(1, 2)), str(VertexPrefab(x=10.0, y=20.0)), str(VertexPrefab(x=30.0, y=40.0)))
        )


if __name__ == "__main__":
    unittest.main()
