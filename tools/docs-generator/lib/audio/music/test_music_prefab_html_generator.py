import unittest

from lib.audio.music.music_prefab import MusicPrefab
from lib.audio.music.music_prefab_html_generator import MusicPrefabHtmlGenerator
from lib.html.html import HtmlGenerator


class TestMusicPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = MusicPrefab("filename")
        html_generator = HtmlGenerator()
        music_html_generator = MusicPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-music"><p>Music</p><div><table><tr><th>Filename</th><td>filename</td></tr></table>'
            '</div></div>',
            html_generator.generate_html(music_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
