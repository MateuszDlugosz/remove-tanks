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
            '<divclass="doc-animation"><h6>Fileanimation</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy</dt><dd>'
            'False</dd><dt>Playmode</dt><dd>PlayMODE</dd><dt>Frameduration</dt><dd>0.22</dd><dt>Filenames</dt><dd>'
            'one,two</dd></dl></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAtlasAnimationPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AtlasAnimationPrefab(True, False, "atlas", ["one", "two"], 0.22, "PlayMODE")
        html_generator = HtmlGenerator()
        fa_html_generator = SubAtlasAnimationPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-animation"><h6>Atlasanimation</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy</dt>'
            '<dd>False</dd><dt>Playmode</dt><dd>PlayMODE</dd><dt>Frameduration</dt><dd>0.22</dd><dt>Atlasfilename'
            '</dt><dd>atlas</dd><dt>Regionnames</dt><dd>one,two</dd></dl></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestAnimationPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = AtlasAnimationPrefab(True, False, "atlas", ["one", "two"], 0.22, "PlayMODE")
        html_generator = HtmlGenerator()
        a_html_generator = AnimationPrefabHtmlGenerator([SubAtlasAnimationPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-animation"><h6>Atlasanimation</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy</dt>'
            '<dd>False</dd><dt>Playmode</dt><dd>PlayMODE</dd><dt>Frameduration</dt><dd>0.22</dd><dt>Atlasfilename'
            '</dt><dd>atlas</dd><dt>Regionnames</dt><dd>one,two</dd></dl></div>',
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
