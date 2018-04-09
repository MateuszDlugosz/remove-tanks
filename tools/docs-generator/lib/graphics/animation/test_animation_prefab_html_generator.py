import unittest

from lib.graphics.animation.animation_prefab import FileAnimationPrefab, AtlasAnimationPrefab
from lib.graphics.animation.animation_prefab_html_generator import SubFileAnimationPrefabHtmlGenerator, \
    SubAtlasAnimationPrefabHtmlGenerator, AnimationPrefabHtmlGenerator, AnimationPrefabHtmlGenerationException
from lib.html.html import HtmlGenerator


class TestSubFileAnimationPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = FileAnimationPrefab(True, False, ["one", "two"], 0.22, "PlayMODE")
        html_generator = HtmlGenerator()
        fa_html_generator = SubFileAnimationPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-animation"><p>Fileanimation</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>'
            'Flipy</th><td>False</td></tr><tr><th>Playmode</th><td>PlayMODE</td></tr><tr><th>Frameduration</th><td>'
            '0.22</td></tr><tr><th>Filenames</th><td>one,two</td></tr></table></div></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAtlasAnimationPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AtlasAnimationPrefab(True, False, "atlas", ["one", "two"], 0.22, "PlayMODE")
        html_generator = HtmlGenerator()
        fa_html_generator = SubAtlasAnimationPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-animation"><p>Fileanimation</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>'
            'Flipy</th><td>False</td></tr><tr><th>Playmode</th><td>PlayMODE</td></tr><tr><th>Frameduration</th><td>'
            '0.22</td></tr><tr><th>Atlasfilename</th><td>atlas</td></tr><tr><th>Regionnames</th><td>one,two</td></tr>'
            '</table></div></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestAnimationPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = AtlasAnimationPrefab(True, False, "atlas", ["one", "two"], 0.22, "PlayMODE")
        html_generator = HtmlGenerator()
        a_html_generator = AnimationPrefabHtmlGenerator([SubAtlasAnimationPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-animation"><p>Fileanimation</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>'
            'Flipy</th><td>False</td></tr><tr><th>Playmode</th><td>PlayMODE</td></tr><tr><th>Frameduration</th><td>'
            '0.22</td></tr><tr><th>Atlasfilename</th><td>atlas</td></tr><tr><th>Regionnames</th><td>one,two</td></tr>'
            '</table></div></div>',
            html_generator.generate_html(a_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )

    def test_generate_html_invalid(self):
        prefab = AtlasAnimationPrefab(True, False, "atlas", ["one", "two"], 0.22, "PlayMODE")
        a_html_generator = AnimationPrefabHtmlGenerator([])

        with self.assertRaises(AnimationPrefabHtmlGenerationException):
            a_html_generator.generate_html(prefab)


if __name__ == "__main__":
    unittest.main()
