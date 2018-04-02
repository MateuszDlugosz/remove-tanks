import unittest

from lib.graphics.sprite.sprite_prefab import FileSpritePrefab, AtlasSpritePrefab
from lib.graphics.sprite.sprite_prefab_html_generator import SubFileSpritePrefabHtmlGenerator, \
    SubAtlasSpritePrefabHtmlGenerator, SpritePrefabHtmlGenerator, SpritePrefabHtmlGenerationException
from lib.html.html import HtmlGenerator


class TestSubFileSpritePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = FileSpritePrefab(True, False, "filename")
        html_generator = HtmlGenerator()
        fa_html_generator = SubFileSpritePrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-sprite"><h6>Filesprite</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy</dt><dd>False</dd>'
            '<dt>Filename</dt><dd>filename</dd></dl></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAtlasSpritePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AtlasSpritePrefab(True, False, "atlas-filename", "region-name")
        html_generator = HtmlGenerator()
        fa_html_generator = SubAtlasSpritePrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-sprite"><h6>Atlassprite</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy</dt><dd>False'
            '</dd><dt>Atlasfilename</dt><dd>atlas-filename</dd><dt>Regionname</dt><dd>region-name</dd>'
            '</dl></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSpritePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = AtlasSpritePrefab(True, False, "atlas-filename", "region-name")
        html_generator = HtmlGenerator()
        a_html_generator = SpritePrefabHtmlGenerator([SubAtlasSpritePrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-sprite"><h6>Atlassprite</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy</dt><dd>False'
            '</dd><dt>Atlasfilename</dt><dd>atlas-filename</dd><dt>Regionname</dt><dd>region-name</dd>'
            '</dl></div>',
            html_generator.generate_html(a_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )

    def test_generate_html_invalid(self):
        prefab = AtlasSpritePrefab(True, False, "atlas-filename", "region-name")
        a_html_generator = SpritePrefabHtmlGenerator([])

        with self.assertRaises(SpritePrefabHtmlGenerationException):
            a_html_generator.generate_html(prefab)


if __name__ == "__main__":
    unittest.main()
