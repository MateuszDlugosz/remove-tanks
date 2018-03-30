import unittest

from lib.level.preload.preload_data import PreloadData


class TestPreloadData(unittest.TestCase):
    def test_to_string(self):
        self.assertEqual(
            str(PreloadData(["EPC0", "EPC1"], ["A0", "A1", "A2"])),
            "PreloadData(entity_prefab_codes=['EPC0', 'EPC1'], asset_ids=['A0', 'A1', 'A2'])"
        )


if __name__ == "__main__":
    unittest.main()
