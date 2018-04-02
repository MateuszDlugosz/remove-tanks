import unittest

from lib.audio.music.music_prefab import MusicPrefab
from lib.audio.music.music_prefab_html_generator import MusicPrefabHtmlGenerator
from lib.audio.sound.sound_prefab import SoundPrefab
from lib.audio.sound.sound_prefab_html_generator import SoundPrefabHtmlGenerator
from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab
from lib.graphics.camera.camera_effect_prefab_html_generator import CameraEffectPrefabHtmlGenerator, \
    SubShakeCameraEffectPrefabHtmlGenerator
from lib.html.html import HtmlGenerator
from lib.level.event.entity_event_prefab import SpawnAirplaneEntityEventPrefab, AmmoLevelUpEntityEventPrefab, \
    AddCameraEffectEntityEventPrefab, CreateEntityEventPrefab, DestroyEntityEventPrefab, \
    DestroyEntityByIdEntityEventPrefab, DestroyFamilyEntityEventPrefab, AddLifeEntityEventPrefab, \
    AddMessageEntityEventPrefab, PlayMusicEntityEventPrefab, AddPointsEntityEventPrefab, \
    IncreasePointsMultiplierEntityEventPrefab, PlaySoundEntityEventPrefab, ActivateSpawnerEntityEventPrefab, \
    ChangeLevelStateEntityEventPrefab
from lib.level.event.entity_event_prefab_html_generator import SubSpawnAirplaneEntityEventPrefabHtmlGenerator, \
    SubAmmoLevelUpEntityEventPrefabHtmlGenerator, SubAddCameraEffectEntityEventPrefabHtmlGenerator, \
    SubCreateEntityEventPrefabHtmlGenerator, SubDestroyEntityEventPrefabHtmlGenerator, \
    SubDestroyEntityByIdEntityEventPrefabHtmlGenerator, SubDestroyFamilyEntityEventPrefabHtmlGenerator, \
    SubAddLifeEntityEventPrefabHtmlGenerator, SubAddMessageEntityEventPrefabHtmlGenerator, \
    SubPlayMusicEntityEventPrefabHtmlGenerator, SubAddPointsEntityEventPrefabHtmlGenerator, \
    SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator, SubPlaySoundEntityEventPrefabHtmlGenerator, \
    SubActivateSpawnerEntityEventPrefabHtmlGenerator, SubChangeLevelStateEntityEventPrefabHtmlGenerator, \
    EntityEventPrefabHtmlGenerator, EntityEventPrefabHtmlGenerationException
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab
from lib.level.utility.create.create_entry_prefab_html_generator import CreateEntryPrefabHtmlGenerator
from lib.level.utility.stage.broker.message.message_prefab import MessagePrefab
from lib.level.utility.stage.broker.message.message_prefab_html_generator import MessagePrefabHtmlGenerator
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_html_generator import PositionPrefabHtmlGenerator


class TestSubSpawnAirplaneEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = SpawnAirplaneEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubSpawnAirplaneEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Spawnairplaneentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAmmoLevelUpEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AmmoLevelUpEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAmmoLevelUpEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Ammolevelupentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddCameraEffectEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddCameraEffectEntityEventPrefab(ShakeCameraEffectPrefab(10, 20))
        html_generator = HtmlGenerator()
        sub_generator = SubAddCameraEffectEntityEventPrefabHtmlGenerator(
            CameraEffectPrefabHtmlGenerator([SubShakeCameraEffectPrefabHtmlGenerator()])
        )

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Addcameraeffectentityevent</h6><hr/><dl><dt>Cameraeffect'
            '</dt><dd><divclass="doc-camera-effect"><h6>Shakecameraeffect</h6><hr/><dl><dt>Time</dt><dd>'
            '10.0</dd><dt>Power</dt><dd>20.0</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubCreateEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = CreateEntityEventPrefab([CreateEntryPrefab("PREFAB_CODE", PositionPrefab(10, 20))])
        html_generator = HtmlGenerator()
        sub_generator = SubCreateEntityEventPrefabHtmlGenerator(
            CreateEntryPrefabHtmlGenerator(PositionPrefabHtmlGenerator())
        )

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Createentityevent</h6><hr/><dl><dt>Createentries</dt><dd>'
            '<divclass="doc-create-entry"><h6>Createentry</h6><hr/><dl><dt>Position</dt><dd><divclass="doc-position">'
            '<h6>Position</h6><hr/><dl><dt>X</dt><dd>10.0</dd><dt>Y</dt><dd>20.0</dd></dl></div></dd><dt>'
            'Entityprefabcode</dt><dd>PREFAB_CODE</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Destroyentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyEntityByIdEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyEntityByIdEntityEventPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyEntityByIdEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Destroyentitybyidentityevent</h6><hr/><dl><dt>Id</dt>'
            '<dd>ID</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyFamilyEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyFamilyEntityEventPrefab("FAMILY")
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyFamilyEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Destroyfamilyentityevent</h6><hr/><dl><dt>Entityfamily</dt><dd>'
            'FAMILY</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddLifeEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddLifeEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAddLifeEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Addlifeentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddMessageEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddMessageEntityEventPrefab(MessagePrefab(10, "ENTRY_KEY", "FACE_ID"))
        html_generator = HtmlGenerator()
        sub_generator = SubAddMessageEntityEventPrefabHtmlGenerator(MessagePrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Addmessageentityevent</h6><hr/><dl><dt>Message'
            '</dt><dd><divclass="doc-message"><h6>Message</h6><hr/><dl><dt>Time</dt><dd>10.0</dd><dt>'
            'Translationentrykey</dt><dd>ENTRY_KEY</dd><dt>Faceid</dt><dd>FACE_ID</dd></dl></div></dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPlayMusicEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PlayMusicEntityEventPrefab(MusicPrefab("music_filename"), "music_channel_name")
        html_generator = HtmlGenerator()
        sub_generator = SubPlayMusicEntityEventPrefabHtmlGenerator(MusicPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Playmusicentityevent</h6><hr/><dl><dt>Music</dt><dd>'
            '<divclass="doc-music"><h6>Music</h6><hr/><dl><dt>Filename</dt><dd>music_filename</dd></dl>'
            '</div></dd><dt>Musicchannelname</dt><dd>music_channel_name</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddPointsEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddPointsEntityEventPrefab(100)
        html_generator = HtmlGenerator()
        sub_generator = SubAddPointsEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Addpointsentityevent</h6><hr/><dl><dt>Points</dt><dd>100</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = IncreasePointsMultiplierEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Increasepointsmultiplierentityevent</h6><hr/></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPlaySoundEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PlaySoundEntityEventPrefab(SoundPrefab("sound_filename"), "sound_channel_name")
        html_generator = HtmlGenerator()
        sub_generator = SubPlaySoundEntityEventPrefabHtmlGenerator(SoundPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Playsoundentityevent</h6><hr/><dl><dt>Sound</dt><dd>'
            '<divclass="doc-sound"><h6>Sound</h6><hr/><dl><dt>Filename</dt><dd>sound_filename</dd></dl>'
            '</div></dd><dt>Soundchannelname</dt><dd>sound_channel_name</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubActivateSpawnerEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ActivateSpawnerEntityEventPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubActivateSpawnerEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Activatespawnerentityevent</h6><hr/>'
            '<dl><dt>Id</dt><dd>ID</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubChangeLevelStateEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ChangeLevelStateEntityEventPrefab("LEVEL_STATE")
        html_generator = HtmlGenerator()
        sub_generator = SubChangeLevelStateEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Changelevelstateentityevent</h6><hr/><dl><dt>Levelstate</dt><dd>'
            'LEVEL_STATE</dd></dl></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = ChangeLevelStateEntityEventPrefab("LEVEL_STATE")
        html_generator = HtmlGenerator()
        generator = EntityEventPrefabHtmlGenerator([SubChangeLevelStateEntityEventPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-entity-event"><h6>Changelevelstateentityevent</h6><hr/><dl><dt>Levelstate</dt><dd>'
            'LEVEL_STATE</dd></dl></div>',
            html_generator.generate_html(generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )

    def test_generate_html_invalid(self):
        prefab = ChangeLevelStateEntityEventPrefab("LEVEL_STATE")
        html_generator = HtmlGenerator()
        generator = EntityEventPrefabHtmlGenerator([])

        with self.assertRaises(EntityEventPrefabHtmlGenerationException):
            html_generator.generate_html(generator.generate_html(prefab))


if __name__ == "__main__":
    unittest.main()
