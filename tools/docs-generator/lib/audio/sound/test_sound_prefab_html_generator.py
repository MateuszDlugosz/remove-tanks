import unittest

from lib.audio.sound.sound_prefab import SoundPrefab
from lib.audio.sound.sound_prefab_html_generator import SoundPrefabHtmlGenerator
from lib.html.html import HtmlGenerator


class TestSoundPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SoundPrefab("filename")
        html_generator = HtmlGenerator()
        sound_html_generator = SoundPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-sound"><h6>Sound</h6><hr/><dl><dt>Filename</dt><dd>filename</dd></dl></div>',
            html_generator.generate_html(sound_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
