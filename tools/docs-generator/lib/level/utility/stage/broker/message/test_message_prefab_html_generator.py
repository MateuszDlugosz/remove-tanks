import unittest

from lib.html.html import HtmlGenerator
from lib.level.utility.stage.broker.message.message_prefab import MessagePrefab
from lib.level.utility.stage.broker.message.message_prefab_html_generator import MessagePrefabHtmlGenerator


class TestMessagePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = MessagePrefab(10, "ENTRY_KEY", "FACE_ID")
        html_generator = HtmlGenerator()
        message_html_generator = MessagePrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-message"><p>Message</p><div><table><tr><th>Time</th><td>10.0</td></tr><tr><th>Entrykey'
            '</th><td>ENTRY_KEY</td></tr><tr><th>Faceid</th><td>FACE_ID</td></tr></table></div></div>',
            html_generator.generate_html(message_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
