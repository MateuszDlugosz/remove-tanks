import unittest

from lib.physics.shape.vertex_prefab import VertexPrefab


class TestVertexPrefab(unittest.TestCase):
    def test_vertex_prefab_to_string(self):
        self.assertEqual(str(VertexPrefab(1, 2)), "VertexPrefab(x=1.0, y=2.0)")


if __name__ == "__main__":
    unittest.main()
