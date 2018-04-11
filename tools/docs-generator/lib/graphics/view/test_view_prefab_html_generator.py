import unittest

from lib.graphics.animation.animation_prefab import FileAnimationPrefab
from lib.graphics.animation.animation_prefab_html_generator import AnimationPrefabHtmlGenerator, \
    SubFileAnimationPrefabHtmlGenerator
from lib.graphics.particles.particle_effect_prefab import FileParticleEffectPrefab
from lib.graphics.particles.particle_effect_prefab_html_generator import ParticleEffectPrefabHtmlGenerator, \
    SubFileParticleEffectPrefabHtmlGenerator
from lib.graphics.sprite.sprite_prefab import FileSpritePrefab
from lib.graphics.sprite.sprite_prefab_html_generator import SpritePrefabHtmlGenerator, SubFileSpritePrefabHtmlGenerator
from lib.graphics.view.view_prefab import SpriteViewPrefab, AnimationViewPrefab, ParticleEffectViewPrefab
from lib.graphics.view.view_prefab_html_generator import SubSpriteViewPrefabHtmlGenerator, \
    SubAnimationViewPrefabHtmlGenerator, SubParticleEffectViewPrefabHtmlGenerator, ViewPrefabHtmlGenerator
from lib.html.html import HtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSubSpriteViewPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpriteViewPrefab("ID", PositionPrefab(0.1, 0.2), FileSpritePrefab(True, False, "filename"))
        html_generator = HtmlGenerator()
        s_html_generator = SubSpriteViewPrefabHtmlGenerator(
            PositionPrefabHtmlGenerator(), SpritePrefabHtmlGenerator([SubFileSpritePrefabHtmlGenerator()]))

        self.assertEqual(
            '<divclass="doc-view"><p>Spriteview</p><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th>'
            '<td>0.1</td></tr><tr><th>Y</th><td>0.2</td></tr></table></div></div><divclass="doc-sprite"><p>Filesprite'
            '</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>Flipy</th><td>False</td></tr><tr><th>Filename'
            '</th><td>filename</td></tr></table></div></div></div>',
            html_generator.generate_html(s_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAnimationViewPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AnimationViewPrefab("ID", PositionPrefab(0.1, 0.2),
                                     FileAnimationPrefab(True, False, ["one", "two"], 0.22, "PlayMODE"))
        html_generator = HtmlGenerator()
        s_html_generator = SubAnimationViewPrefabHtmlGenerator(
            PositionPrefabHtmlGenerator(), AnimationPrefabHtmlGenerator([SubFileAnimationPrefabHtmlGenerator()]))

        self.assertEqual(
            '<divclass="doc-view"><p>Animationview</p><divclass="doc-position"><p>Position</p><div><table><tr><th>X'
            '</th><td>0.1</td></tr><tr><th>Y</th><td>0.2</td></tr></table></div></div><divclass="doc-animation"><p>'
            'Fileanimation</p><div><table><tr><th>Flipx</th><td>True</td></tr><tr><th>Flipy</th><td>False</td></tr>'
            '<tr><th>Playmode</th><td>PlayMODE</td></tr><tr><th>Frameduration</th><td>0.22</td></tr><tr><th>Filenames'
            '</th><td>one,two</td></tr></table></div></div></div>',
            html_generator.generate_html(s_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubParticleEffectViewPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ParticleEffectViewPrefab("ID", PositionPrefab(0.1, 0.2),
                                          FileParticleEffectPrefab(True, False, "test_filename", "test_images_dir"))
        html_generator = HtmlGenerator()
        s_html_generator = SubParticleEffectViewPrefabHtmlGenerator(
            PositionPrefabHtmlGenerator(), ParticleEffectPrefabHtmlGenerator([
                SubFileParticleEffectPrefabHtmlGenerator()]))

        self.assertEqual(
            '<divclass="doc-view"><p>Particleeffectview</p><divclass="doc-position"><p>Position</p><div><table><tr>'
            '<th>X</th><td>0.1</td></tr><tr><th>Y</th><td>0.2</td></tr></table></div></div>'
            '<divclass="doc-particle-effect"><p>Fileparticleeffect</p><div><table><tr><th>Flipx</th><td>True</td></tr>'
            '<tr><th>Flipy</th><td>False</td></tr><tr><th>Filename</th><td>test_filename</td></tr><tr><th>'
            'Imagesdirectory</th><td>test_images_dir</td></tr></table></div></div></div>',
            html_generator.generate_html(s_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestViewPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ParticleEffectViewPrefab("ID", PositionPrefab(0.1, 0.2),
                                          FileParticleEffectPrefab(True, False, "test_filename", "test_images_dir"))
        html_generator = HtmlGenerator()
        s_html_generator = ViewPrefabHtmlGenerator([
            SubParticleEffectViewPrefabHtmlGenerator(
                PositionPrefabHtmlGenerator(), ParticleEffectPrefabHtmlGenerator([
                    SubFileParticleEffectPrefabHtmlGenerator()]))
        ])

        self.assertEqual(
            '<divclass="doc-view"><p>Particleeffectview</p><divclass="doc-position"><p>Position</p><div><table><tr>'
            '<th>X</th><td>0.1</td></tr><tr><th>Y</th><td>0.2</td></tr></table></div></div>'
            '<divclass="doc-particle-effect"><p>Fileparticleeffect</p><div><table><tr><th>Flipx</th><td>True</td></tr>'
            '<tr><th>Flipy</th><td>False</td></tr><tr><th>Filename</th><td>test_filename</td></tr><tr><th>'
            'Imagesdirectory</th><td>test_images_dir</td></tr></table></div></div></div>',
            html_generator.generate_html(s_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


if __name__ == "__main__":
    unittest.main()
