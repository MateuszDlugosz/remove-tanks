import unittest

from lib.utility.string_functions import *


class TestStringFunctions(unittest.TestCase):
    def test_string_to_boolean(self):
        self.assertTrue(string_to_boolean("true"))
        self.assertTrue(string_to_boolean("True"))
        self.assertFalse(string_to_boolean(""))
        self.assertFalse(string_to_boolean("false"))
        self.assertFalse(string_to_boolean("False"))
        self.assertFalse(string_to_boolean(None))


if __name__ == "__main__":
    unittest.main()
