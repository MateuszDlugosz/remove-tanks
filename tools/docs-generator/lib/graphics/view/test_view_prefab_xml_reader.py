import unittest

from lib.graphics.animation.animation_prefab_xml_reader import AnimationPrefabXmlReader, SubFileAnimationPrefabXmlReader
from lib.graphics.particles.particle_effect_prefab_xml_reader import ParticleEffectPrefabXmlReader, \
    SubFileParticleEffectPrefabXmlReader
from lib.graphics.sprite.sprite_prefab_xml_reader import SpritePrefabXmlReader, SubFileSpritePrefabXmlReader
from lib.graphics.view.view_prefab_xml_reader import SubSpriteViewPrefabXmlReader, ViewPrefabXmlReadException, \
    SubAnimationViewPrefabXmlReader, SubParticleEffectViewPrefabXmlReader, ViewPrefabXmlReader
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class TestSubSpriteViewPrefabXmlReader(unittest.TestCase):
    def test_sprite_view_prefab_xml_reader_valid(self):
        xml = """
            <view type="SpriteView" id="TestID">
                <sprite type="FileSprite">
                    <filename>test_filename</filename>
                </sprite>
                <position>
                    <x>10</x>
                    <y>20</y>
                </position>
            </view>
        """
        reader = SubSpriteViewPrefabXmlReader(
            PositionPrefabXmlReader(), SpritePrefabXmlReader([SubFileSpritePrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_position_prefab().get_x(), 10)
        self.assertEqual(prefab.get_position_prefab().get_y(), 20)
        self.assertEqual(prefab.get_sprite_prefab().get_filename(), "test_filename")

    def test_sprite_view_prefab_xml_reader_defaults(self):
        xml = """
            <view type="SpriteView" id="TestID">
                <sprite type="FileSprite">
                    <filename>test_filename</filename>
                </sprite>
            </view>
        """
        reader = SubSpriteViewPrefabXmlReader(
            PositionPrefabXmlReader(), SpritePrefabXmlReader([SubFileSpritePrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_position_prefab().get_x(), 0)
        self.assertEqual(prefab.get_position_prefab().get_y(), 0)
        self.assertEqual(prefab.get_sprite_prefab().get_filename(), "test_filename")

    def test_sprite_view_prefab_xml_reader_invalid(self):
        xml = """
            <view type="SpriteView"></view>
        """
        reader = SubSpriteViewPrefabXmlReader(PositionPrefabXmlReader(), SpritePrefabXmlReader([]))

        with self.assertRaises(ViewPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubAnimationViewPrefabXmlReader(unittest.TestCase):
    def test_animation_view_prefab_xml_reader_valid(self):
        xml = """
            <view type="AnimationView" id="TestID">
                <animation type="FileAnimation" flipX="true" flipY="false" frameDuration="0.2" playMode="TEST">
                    <frame filename="test0" />
                    <frame filename="test1" />
                </animation>
                <position>
                    <x>10</x>
                    <y>20</y>
                </position>
            </view>
        """
        reader = SubAnimationViewPrefabXmlReader(
            PositionPrefabXmlReader(), AnimationPrefabXmlReader([SubFileAnimationPrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_position_prefab().get_x(), 10)
        self.assertEqual(prefab.get_position_prefab().get_y(), 20)
        self.assertEqual(prefab.get_animation_prefab().get_play_mode(), "TEST")
        self.assertTrue(prefab.get_animation_prefab().get_flip_x())
        self.assertFalse(prefab.get_animation_prefab().get_flip_y())
        self.assertEqual(prefab.get_animation_prefab().get_frame_duration(), 0.2)
        self.assertEqual(prefab.get_animation_prefab().get_filenames()[0], "test0")
        self.assertEqual(prefab.get_animation_prefab().get_filenames()[1], "test1")

    def test_animation_view_prefab_xml_reader_defaults(self):
        xml = """
            <view type="AnimationView" id="TestID">
                <animation type="FileAnimation" flipX="true" flipY="false" frameDuration="0.2" playMode="TEST">
                    <frame filename="test0" />
                    <frame filename="test1" />
                </animation>
            </view>
        """
        reader = SubAnimationViewPrefabXmlReader(
            PositionPrefabXmlReader(), AnimationPrefabXmlReader([SubFileAnimationPrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_position_prefab().get_x(), 0)
        self.assertEqual(prefab.get_position_prefab().get_y(), 0)
        self.assertEqual(prefab.get_animation_prefab().get_play_mode(), "TEST")
        self.assertTrue(prefab.get_animation_prefab().get_flip_x())
        self.assertFalse(prefab.get_animation_prefab().get_flip_y())
        self.assertEqual(prefab.get_animation_prefab().get_frame_duration(), 0.2)
        self.assertEqual(prefab.get_animation_prefab().get_filenames()[0], "test0")
        self.assertEqual(prefab.get_animation_prefab().get_filenames()[1], "test1")

    def test_animation_view_prefab_xml_reader_invalid(self):
        xml = """
            <view type="AnimationView"></view>
        """
        reader = SubAnimationViewPrefabXmlReader(PositionPrefabXmlReader(), AnimationPrefabXmlReader([]))

        with self.assertRaises(ViewPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubParticleEffectViewPrefabXmlReader(unittest.TestCase):
    def test_particle_effect_view_prefab_xml_reader_valid(self):
        xml = """
            <view type="ParticleEffectView" id="TestID">
                <particleEffect type="FileParticleEffect" flipX="true" flipY="false">
                    <filename>test_filename</filename>
                    <imagesDirectory>test_images_directory</imagesDirectory>
                </particleEffect>
                <position>
                    <x>10</x>
                    <y>20</y>
                </position>
            </view>
        """
        reader = SubParticleEffectViewPrefabXmlReader(
            PositionPrefabXmlReader(), ParticleEffectPrefabXmlReader([SubFileParticleEffectPrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_position_prefab().get_x(), 10)
        self.assertEqual(prefab.get_position_prefab().get_y(), 20)
        self.assertTrue(prefab.get_particle_effect_prefab().get_flip_x())
        self.assertFalse(prefab.get_particle_effect_prefab().get_flip_y())
        self.assertEqual(prefab.get_particle_effect_prefab().get_filename(), "test_filename")
        self.assertEqual(prefab.get_particle_effect_prefab().get_images_dir(), "test_images_directory")

    def test_particle_effect_view_prefab_xml_reader_defaults(self):
        xml = """
            <view type="ParticleEffectView" id="TestID">
                <particleEffect type="FileParticleEffect" flipX="true" flipY="false">
                    <filename>test_filename</filename>
                    <imagesDirectory>test_images_directory</imagesDirectory>
                </particleEffect>
            </view>
        """
        reader = SubParticleEffectViewPrefabXmlReader(
            PositionPrefabXmlReader(), ParticleEffectPrefabXmlReader([SubFileParticleEffectPrefabXmlReader()]))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_position_prefab().get_x(), 0)
        self.assertEqual(prefab.get_position_prefab().get_y(), 0)
        self.assertTrue(prefab.get_particle_effect_prefab().get_flip_x())
        self.assertFalse(prefab.get_particle_effect_prefab().get_flip_y())
        self.assertEqual(prefab.get_particle_effect_prefab().get_filename(), "test_filename")
        self.assertEqual(prefab.get_particle_effect_prefab().get_images_dir(), "test_images_directory")

    def test_particle_effect_view_prefab_xml_reader_invalid(self):
        xml = """
            <view type="ParticleEffectView"></view>
        """
        reader = SubParticleEffectViewPrefabXmlReader(PositionPrefabXmlReader(), ParticleEffectPrefabXmlReader([]))

        with self.assertRaises(ViewPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestViewPrefabXmlReader(unittest.TestCase):
    def test_view_prefab_xml_reader_valid(self):
        xml = """
            <view type="SpriteView" id="TestID">
                <sprite type="FileSprite">
                    <filename>test_filename</filename>
                </sprite>
                <position>
                    <x>10</x>
                    <y>20</y>
                </position>
            </view>
        """
        reader = ViewPrefabXmlReader([
            SubSpriteViewPrefabXmlReader(
                PositionPrefabXmlReader(),
                SpritePrefabXmlReader([
                    SubFileSpritePrefabXmlReader()
                ])
            )
        ])
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "TestID")
        self.assertEqual(prefab.get_position_prefab().get_x(), 10)
        self.assertEqual(prefab.get_position_prefab().get_y(), 20)
        self.assertEqual(prefab.get_sprite_prefab().get_filename(), "test_filename")

    def test_view_prefab_xml_reader_invalid(self):
        xml = """
            <view type="UnknownViewType">
            </view>
        """
        reader = ViewPrefabXmlReader([])

        with self.assertRaises(ViewPrefabXmlReadException):
            reader.read_prefab_from_string(xml)

    def test_view_prefabs_xml_reader_valid(self):
        xml = """
            <views>
                <view type="SpriteView" id="TestID0">
                    <sprite type="FileSprite">
                        <filename>test_filename</filename>
                    </sprite>
                    <position>
                        <x>10</x>
                        <y>20</y>
                    </position>
                </view>
                <view type="SpriteView" id="TestID1">
                    <sprite type="FileSprite">
                        <filename>test_filename</filename>
                    </sprite>
                    <position>
                        <x>11</x>
                        <y>21</y>
                    </position>
                </view>
            </views>
        """
        reader = ViewPrefabXmlReader([
            SubSpriteViewPrefabXmlReader(
                PositionPrefabXmlReader(),
                SpritePrefabXmlReader([
                    SubFileSpritePrefabXmlReader()
                ])
            )
        ])
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(prefabs[0].get_id(), "TestID0")
        self.assertEqual(prefabs[0].get_position_prefab().get_x(), 10)
        self.assertEqual(prefabs[0].get_position_prefab().get_y(), 20)
        self.assertEqual(prefabs[0].get_sprite_prefab().get_filename(), "test_filename")

        self.assertEqual(prefabs[1].get_id(), "TestID1")
        self.assertEqual(prefabs[1].get_position_prefab().get_x(), 11)
        self.assertEqual(prefabs[1].get_position_prefab().get_y(), 21)
        self.assertEqual(prefabs[1].get_sprite_prefab().get_filename(), "test_filename")

    def test_view_prefabs_xml_reader_invalid(self):
        xml = """
            <views>
                <view type="UnknownViewType"></view>
            </views>
        """
        reader = ViewPrefabXmlReader([])

        with self.assertRaises(ViewPrefabXmlReadException):
            reader.read_prefabs_from_string(xml)


if __name__ == "__main__":
    unittest.main()
