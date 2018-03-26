import unittest

from lib.level.utility.state import StateXmlReader, StateXmlReadException


class TestStateXmlReader(unittest.TestCase):
    def test_read_state_from_string_valid(self):
        xml = """
            <state>TEST</state>
        """
        reader = StateXmlReader()

        self.assertEqual(reader.read_state_from_string(xml), "TEST")

    def test_read_state_from_string_invalid(self):
        xml = """
            <state />
        """
        reader = StateXmlReader()

        with self.assertRaises(StateXmlReadException):
            reader.read_state_from_string(xml)

    def test_read_states_from_string_valid(self):
        xml = """
            <states>
                <state>A</state>
                <state>B</state>
            </states>
        """
        reader = StateXmlReader()
        states = reader.read_states_from_string(xml)

        self.assertEqual(states[0], "A")
        self.assertEqual(states[1], "B")

    def test_read_states_from_string_invalid(self):
        xml = """
            <states>
                <state>A</state>
                <state />
            </states>
        """
        reader = StateXmlReader()

        with self.assertRaises(StateXmlReadException):
            reader.read_states_from_string(xml)
