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
            '<divclass="doc-view"><h6>Spriteview</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position"><h6>'
            'Position</h6><hr/><dl><dt>X</dt><dd>0.1</dd><dt>Y</dt><dd>0.2</dd></dl></div></dd><dt>Sprite</dt><dd>'
            '<divclass="doc-sprite"><h6>Filesprite</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy</dt><dd>False</dd>'
            '<dt>Filename</dt><dd>filename</dd></dl></div></dd></dl></div>',
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
            '<divclass="doc-view"><h6>Animationview</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position"><h6>'
            'Position</h6><hr/><dl><dt>X</dt><dd>0.1</dd><dt>Y</dt><dd>0.2</dd></dl></div></dd><dt>Animation</dt>'
            '<dd><divclass="doc-animation"><h6>Fileanimation</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>Flipy'
            '</dt><dd>False</dd><dt>Playmode</dt><dd>PlayMODE</dd><dt>Frameduration</dt><dd>0.22</dd><dt>Filenames'
            '</dt><dd>one,two</dd></dl></div></dd></dl></div>',
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
            '<divclass="doc-view"><h6>Atlasview</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position"><h6>'
            'Position</h6><hr/><dl><dt>X</dt><dd>0.1</dd><dt>Y</dt><dd>0.2</dd></dl></div></dd><dt>Particleeffect</dt>'
            '<dd><divclass="doc-particle-effect"><h6>Fileparticleeffect</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>'
            'Flipy</dt><dd>False</dd><dt>Filename</dt><dd>test_filename</dd><dt>Imagesdirectory</dt><dd>'
            'test_images_dir</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(s_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", ""))


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
            '<divclass="doc-view"><h6>Atlasview</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position"><h6>'
            'Position</h6><hr/><dl><dt>X</dt><dd>0.1</dd><dt>Y</dt><dd>0.2</dd></dl></div></dd><dt>Particleeffect</dt>'
            '<dd><divclass="doc-particle-effect"><h6>Fileparticleeffect</h6><hr/><dl><dt>Flipx</dt><dd>True</dd><dt>'
            'Flipy</dt><dd>False</dd><dt>Filename</dt><dd>test_filename</dd><dt>Imagesdirectory</dt><dd>'
            'test_images_dir</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(s_html_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", ""))


if __name__ == "__main__":
    unittest.main()
