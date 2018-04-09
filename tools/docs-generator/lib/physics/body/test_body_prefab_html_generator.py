import unittest

from lib.html.html import HtmlGenerator
from lib.physics.body.body_prefab import BodyPrefab
from lib.physics.body.body_prefab_html_generator import BodyPrefabHtmlGenerator


class TestBodyPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = BodyPrefab("StaticBody", True, False, True, True, True, 1, 45, 60, 1)
        html_generator = HtmlGenerator()
        body_prefab_html_generator = BodyPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-body"><p>Body</p><div><table><tr><th>Bodytype</th><td>StaticBody</td></tr><tr><th>Active'
            '</th><td>True</td></tr><tr><th>Awake</th><td>True</td></tr><tr><th>Allowsleep</th><td>False</td></tr><tr>'
            '<th>Fixedrotation</th><td>True</td></tr><tr><th>Bullet</th><td>True</td></tr><tr><th>Gravityscale</th>'
            '<td>1.0</td></tr><tr><th>Angle</th><td>1.0</td></tr><tr><th>Lineardamping</th><td>1.0</td></tr><tr>'
            '<th>Angulardamping</th><td>60.0</td></tr></table></div></div>',
            html_generator.generate_html(body_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
