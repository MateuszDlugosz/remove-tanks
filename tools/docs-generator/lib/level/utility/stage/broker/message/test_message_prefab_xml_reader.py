import unittest

from lib.level.utility.stage.broker.message.message_prefab_xml_reader import MessagePrefabXmlReader, \
    MessagePrefabXmlReadException


class TestMessagePrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <message>
                <time>1.2</time>
                <entryKey>ENTRY_KEY</entryKey>
                <faceId>FACE_ID</faceId>
            </message>
        """
        reader = MessagePrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_time(), 1.2)
        self.assertEqual(prefab.get_translation_entry_key(), "ENTRY_KEY")
        self.assertEqual(prefab.get_face_id(), "FACE_ID")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <message />
        """
        reader = MessagePrefabXmlReader()

        with self.assertRaises(MessagePrefabXmlReadException):
            reader.read_prefab_from_string(xml)


if __name__ == "__main__":
    unittest.main()
