import unittest

from lib.utility.properties.properties import *


class TestProperties(unittest.TestCase):
    def test_property_assign(self):
        properties = Properties()
        properties.set_property("one", "1")
        properties.set_property("two", "2")

        self.assertEqual(properties.get_property("one"), "1")
        self.assertEqual(properties.get_property("two"), "2")

    def test_properties_to_string(self):
        properties = Properties()
        properties.set_property("one", "1")
        properties.set_property("two", "2")

        self.assertEqual(
            str(properties),
            "Properties(properties={'one': '1', 'two': '2'})"
        )


if __name__ == "__main__":
    unittest.main()
