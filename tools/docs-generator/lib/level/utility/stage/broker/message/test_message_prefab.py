import unittest

from lib.level.utility.stage.broker.message.message_prefab import MessagePrefab


class TestMessagePrefab(unittest.TestCase):
    def test_message_prefab_to_string(self):
        self.assertEqual(
            str(MessagePrefab(1.1, "ENTRY_KEY", "FACE_ID")),
            "MessagePrefab(time=1.1, translation_entry_key=ENTRY_KEY, face_id=FACE_ID)"
        )


if __name__ == "__main__":
    unittest.main()
