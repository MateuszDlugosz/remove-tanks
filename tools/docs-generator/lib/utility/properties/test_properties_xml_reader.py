import unittest

from lib.utility.properties.properties_xml_reader import PropertiesXmlReader, PropertiesXmlReadException


class TestPropertiesXmlReader(unittest.TestCase):
    def test_read_properties_from_string_valid(self):
        xml = """
            <properties>
                <property name="one">1</property>
                <property name="two">2</property>
            </properties>
        """
        properties = PropertiesXmlReader().read_properties_from_string(xml)

        self.assertEqual(properties.get_property("one"), "1")
        self.assertEqual(properties.get_property("two"), "2")

    def test_read_properties_from_string_invalid(self):
        xml = """
            <properties>
                <property>1</property>
            </properties>
        """

        with self.assertRaises(PropertiesXmlReadException):
            PropertiesXmlReader().read_properties_from_string(xml)


if __name__ == "__main__":
    unittest.main()
