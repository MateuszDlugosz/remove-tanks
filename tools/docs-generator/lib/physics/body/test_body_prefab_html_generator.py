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
            '<divclass="doc-body"><h6>Body</h6><hr/><dl><dt>Bodytype</dt><dd>StaticBody</dd><dt>Active</dt>'
            '<dd>True</dd><dt>Awake</dt><dd>True</dd><dt>Allowsleep</dt><dd>False</dd><dt>Fixedrotation</dt><dd>True'
            '</dd><dt>Bullet</dt><dd>True</dd><dt>Gravityscale</dt><dd>1.0</dd><dt>Angle</dt><dd>45.0</dd><dt>'
            'Lineardamping</dt><dd>1.0</dd><dt>Angulardamping</dt><dd>60.0</dd></dl></div>',
            html_generator.generate_html(body_prefab_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
