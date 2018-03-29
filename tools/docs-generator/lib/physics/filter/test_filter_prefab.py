import unittest

from lib.physics.filter.filter_prefab import *


class TestFilterPrefab(unittest.TestCase):
    def test_filter_prefab_to_string(self):
        self.assertEqual(
            str(FilterPrefab("CategoryBit", "MaskBit")),
            "FilterPrefab(category_bit=CategoryBit, mask_bit=MaskBit)"
        )


if __name__ == "__main__":
    unittest.main()
