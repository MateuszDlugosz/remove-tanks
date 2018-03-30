import unittest

from lib.level.utility.direction.direction_xml_reader import DirectionXmlReader, DirectionXmlReadException


class TestDirectionXmlReader(unittest.TestCase):
    def test_read_direction_from_string_valid(self):
        xml = """
            <direction>Left</direction>
        """
        reader = DirectionXmlReader()

        self.assertEqual("Left", reader.read_direction_from_string(xml))

    def test_read_direction_from_string_invalid(self):
        xml = """
            <direction />
        """
        reader = DirectionXmlReader()

        with self.assertRaises(DirectionXmlReadException):
            reader.read_direction_from_string(xml)

    def test_read_directions_from_string_valid(self):
        xml = """
            <directions>
                <direction>Left</direction>
                <direction>Right</direction>
            </directions>
        """
        reader = DirectionXmlReader()
        directions = reader.read_directions_from_string(xml)

        self.assertEqual("Left", directions[0])
        self.assertEqual("Right", directions[1])

    def test_read_directions_from_string_invalid(self):
        xml = """
            <directions>
                <direction />
            </directions>
        """
        reader = DirectionXmlReader()

        with self.assertRaises(DirectionXmlReadException):
            reader.read_directions_from_string(xml)


if __name__ == "__main__":
    unittest.main()
