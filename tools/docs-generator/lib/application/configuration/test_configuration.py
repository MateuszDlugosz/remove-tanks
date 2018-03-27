import os
import unittest

from lib.application.configuration.configuration import ConfigurationXmlReader, ConfigurationXmlReadException

CONFIGURATION_TEST_FILENAME = os.path.join(os.path.dirname(__file__), 'test-configuration.xml')


class TestConfigurationXmlReader(unittest.TestCase):
    def test_read_from_file_valid(self):
        reader = ConfigurationXmlReader()
        config = reader.read_from_file(CONFIGURATION_TEST_FILENAME)

        self.assertEqual(config.get_option("TEST0"), "test0")
        self.assertEqual(config.get_option("TEST1"), "test1")

    def test_read_from_file_invalid(self):
        with self.assertRaises(ConfigurationXmlReadException):
            ConfigurationXmlReader().read_from_file("not-existed-file.xml")
