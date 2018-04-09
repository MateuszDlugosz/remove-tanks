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
            '<divclass="doc-sprite"><p>Filesprite</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>Flipy'
            '</th><td>False</td></tr><tr><th>Filename</th><td>filename</td></tr></table></div></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAtlasSpritePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AtlasSpritePrefab(True, False, "atlas-filename", "region-name")
        html_generator = HtmlGenerator()
        fa_html_generator = SubAtlasSpritePrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-sprite"><p>Filesprite</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>Flipy'
            '</th><td>False</td></tr><tr><th>Atlasfilename</th><td>atlas-filename</td></tr><tr><th>Refionname</th>'
            '<td>region-name</td></tr></table></div></div>',
            html_generator.generate_html(fa_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSpritePrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = AtlasSpritePrefab(True, False, "atlas-filename", "region-name")
        html_generator = HtmlGenerator()
        a_html_generator = SpritePrefabHtmlGenerator([SubAtlasSpritePrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-sprite"><p>Filesprite</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>Flipy'
            '</th><td>False</td></tr><tr><th>Atlasfilename</th><td>atlas-filename</td></tr><tr><th>Refionname</th>'
            '<td>region-name</td></tr></table></div></div>',
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
