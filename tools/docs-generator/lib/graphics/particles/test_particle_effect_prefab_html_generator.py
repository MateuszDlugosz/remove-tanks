import unittest

from lib.graphics.particles.particle_effect_prefab import FileParticleEffectPrefab, AtlasParticleEffectPrefab
from lib.graphics.particles.particle_effect_prefab_html_generator import SubFileParticleEffectPrefabHtmlGenerator, \
    SubAtlasParticleEffectPrefabHtmlGenerator, ParticleEffectPrefabHtmlGenerator, \
    ParticleEffectPrefabHtmlGenerationException
from lib.html.html import HtmlGenerator


class TestSubFileParticleEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = FileParticleEffectPrefab(True, False, "filename", "images-dir")
        html_generator = HtmlGenerator()
        sub_html_generator = SubFileParticleEffectPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-particle-effect"><p>Fileparticleeffect</p><div><table><tr><th>Flipx</th><td>True</td></tr>'
            '<tr><th>Flipy</th><td>False</td></tr><tr><th>Filename</th><td>filename</td></tr><tr><th>Imagesdirectory'
            '</th><td>images-dir</td></tr></table></div></div>',
            html_generator.generate_html(sub_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAtlasParticleEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AtlasParticleEffectPrefab(True, False, "filename", "atlas-filename")
        html_generator = HtmlGenerator()
        sub_html_generator = SubAtlasParticleEffectPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-particle-effect"><p>Fileparticleeffect</p><div><table><tr><th>Flipx</th><td>True</td></tr>'
            '<tr><th>Flipy</th><td>False</td></tr><tr><th>Filename</th><td>filename</td></tr><tr><th>Atlasfilename'
            '</th><td>atlas-filename</td></tr></table></div></div>',
            html_generator.generate_html(sub_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestParticleEffectPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = AtlasParticleEffectPrefab(True, False, "filename", "atlas-filename")
        html_generator = HtmlGenerator()
        a_html_generator = ParticleEffectPrefabHtmlGenerator([SubAtlasParticleEffectPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-particle-effect"><p>Fileparticleeffect</p><div><table><tr><th>Flipx</th><td>True</td>'
            '</tr><tr><th>Flipy</th><td>False</td></tr><tr><th>Filename</th><td>filename</td></tr><tr><th>'
            'Atlasfilename</th><td>atlas-filename</td></tr></table></div></div>',
            html_generator.generate_html(a_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )

    def test_generate_html_invalid(self):
        prefab = AtlasParticleEffectPrefab(True, False, "filename", "atlas-filename")
        a_html_generator = ParticleEffectPrefabHtmlGenerator([])

        with self.assertRaises(ParticleEffectPrefabHtmlGenerationException):
            a_html_generator.generate_html(prefab)


if __name__ == "__main__":
    unittest.main()
