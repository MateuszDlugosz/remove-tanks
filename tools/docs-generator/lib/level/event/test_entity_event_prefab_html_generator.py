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
    ChangeLevelStateEntityEventPrefab, RandomCreateEntityEventPrefab, RemoveLifeEntityEventPrefab, \
    ClearMessagesEntityEventPrefab, ResetPointsMultiplierEntityEventPrefab, ActivateSystemEntityEventPrefab, \
    DeactivateSystemEntityEventPrefab
from lib.level.event.entity_event_prefab_html_generator import SubSpawnAirplaneEntityEventPrefabHtmlGenerator, \
    SubAmmoLevelUpEntityEventPrefabHtmlGenerator, SubAddCameraEffectEntityEventPrefabHtmlGenerator, \
    SubCreateEntityEventPrefabHtmlGenerator, SubDestroyEntityEventPrefabHtmlGenerator, \
    SubDestroyEntityByIdEntityEventPrefabHtmlGenerator, SubDestroyFamilyEntityEventPrefabHtmlGenerator, \
    SubAddLifeEntityEventPrefabHtmlGenerator, SubAddMessageEntityEventPrefabHtmlGenerator, \
    SubPlayMusicEntityEventPrefabHtmlGenerator, SubAddPointsEntityEventPrefabHtmlGenerator, \
    SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator, SubPlaySoundEntityEventPrefabHtmlGenerator, \
    SubActivateSpawnerEntityEventPrefabHtmlGenerator, SubChangeLevelStateEntityEventPrefabHtmlGenerator, \
    EntityEventPrefabHtmlGenerator, EntityEventPrefabHtmlGenerationException, \
    SubRandomCreateEntityEventPrefabHtmlGenerator, SubEntityEventPrefabHtmlGenerator, \
    SubRemoveLifeEntityEventPrefabHtmlGenerator, SubClearMessagesEntityEventPrefabHtmlGenerator, \
    SubResetPointsMultiplierEntityEventPrefabHtmlGenerator, SubActivateSystemEntityEventPrefabHtmlGenerator, \
    SubDeactivateSystemEntityEventPrefabHtmlGenerator
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
            '<divclass="doc-entity-event"><p>Spawnairplaneentityevent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAmmoLevelUpEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AmmoLevelUpEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAmmoLevelUpEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Ammolevelupentityevent</p></div>',
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
            '<divclass="doc-entity-event"><p>Addcameraeffectentityevent</p><divclass="doc-camera-effect"><p>'
            'Shakecameraeffect</p><div><table><tr><th>Time</th><td>10.0</td></tr><tr><th>Power</th><td>20.0</td>'
            '</tr></table></div></div></div>',
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
            '<divclass="doc-entity-event"><p>Createentityevent</p><div><p>Createentries</p><divclass="doc-create-en'
            'try"><p>Createentry</p><div><table><tr><th>Entityprefabcode</th><td>PREFAB_CODE</td></tr></table></div'
            '><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>10.0</td></tr><tr><th>Y</th><td'
            '>20.0</td></tr></table></div></div></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Destroyentityevent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyEntityByIdEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyEntityByIdEntityEventPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyEntityByIdEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Destroyentitybyidentityevent</p><div><table><tr><th>Id</th><td>ID</td>'
            '</tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubDestroyFamilyEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DestroyFamilyEntityEventPrefab("FAMILY")
        html_generator = HtmlGenerator()
        sub_generator = SubDestroyFamilyEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Destroyfamilyentityevent</p><div><table><tr><th>Family</th><td>FAMILY'
            '</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddLifeEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddLifeEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubAddLifeEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Addlifeentityevent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddMessageEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddMessageEntityEventPrefab(MessagePrefab(10, "ENTRY_KEY", "FACE_ID"))
        html_generator = HtmlGenerator()
        sub_generator = SubAddMessageEntityEventPrefabHtmlGenerator(MessagePrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Addmessageentityevent</p><divclass="doc-message"><p>Message</p><div>'
            '<table><tr><th>Time</th><td>10.0</td></tr><tr><th>Entrykey</th><td>ENTRY_KEY</td></tr><tr><th>Faceid'
            '</th><td>FACE_ID</td></tr></table></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPlayMusicEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PlayMusicEntityEventPrefab(MusicPrefab("music_filename"), "music_channel_name")
        html_generator = HtmlGenerator()
        sub_generator = SubPlayMusicEntityEventPrefabHtmlGenerator(MusicPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Playmusicentityevent</p><div><table><tr><th>Musicchannelname</th><td>'
            'music_channel_name</td></tr></table></div><divclass="doc-music"><p>Music</p><div><table><tr><th>Filename'
            '</th><td>music_filename</td></tr></table></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubAddPointsEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = AddPointsEntityEventPrefab(100)
        html_generator = HtmlGenerator()
        sub_generator = SubAddPointsEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Addpointsentityevent</p><div><table><tr><th>Points</th><td>100</td>'
            '</tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = IncreasePointsMultiplierEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubIncreasePointsMultiplierEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Increasepointsmultiplierentityevent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubPlaySoundEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = PlaySoundEntityEventPrefab(SoundPrefab("sound_filename"), "sound_channel_name")
        html_generator = HtmlGenerator()
        sub_generator = SubPlaySoundEntityEventPrefabHtmlGenerator(SoundPrefabHtmlGenerator())

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Playsoundentityevent</p><div><table><tr><th>Soundchannelname</th>'
            '<td>sound_channel_name</td></tr></table></div><divclass="doc-sound"><p>Sound</p><div><table><tr>'
            '<th>Filename</th><td>sound_filename</td></tr></table></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubActivateSpawnerEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ActivateSpawnerEntityEventPrefab("ID")
        html_generator = HtmlGenerator()
        sub_generator = SubActivateSpawnerEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Activatespawnerentityevent</p><div><table><tr><th>Id</th><td>ID'
            '</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubChangeLevelStateEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ChangeLevelStateEntityEventPrefab("LEVEL_STATE")
        html_generator = HtmlGenerator()
        sub_generator = SubChangeLevelStateEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Changelevelstateentityevent</p><div><table><tr><th>'
            'Levelstate</th><td>LEVEL_STATE</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRandomCreateEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RandomCreateEntityEventPrefab([CreateEntryPrefab("PREFAB_CODE", PositionPrefab(10, 20))])
        html_generator = HtmlGenerator()
        sub_generator = SubRandomCreateEntityEventPrefabHtmlGenerator(
            CreateEntryPrefabHtmlGenerator(PositionPrefabHtmlGenerator())
        )

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Randomcreateentityevent</p><div><p>Createentries</p><divclass="doc-c'
            'reate-entry"><p>Createentry</p><div><table><tr><th>Entityprefabcode</th><td>PREFAB_CODE</td></tr></t'
            'able></div><divclass="doc-position"><p>Position</p><div><table><tr><th>X</th><td>10.0</td></tr><tr><'
            'th>Y</th><td>20.0</td></tr></table></div></div></div></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubRemoveLifeEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = RemoveLifeEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubRemoveLifeEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Removelifeentityevent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubClearMessagesEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ClearMessagesEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubClearMessagesEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Clearmessagesentityevent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestSubResetPointsMultiplierEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ResetPointsMultiplierEntityEventPrefab()
        html_generator = HtmlGenerator()
        sub_generator = SubResetPointsMultiplierEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Resetpointsmultiplierentityevent</p></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestActivateSystemEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = ActivateSystemEntityEventPrefab("name")
        html_generator = HtmlGenerator()
        sub_generator = SubActivateSystemEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Activatesystementityevent</p><div><table><tr><th>Classname</th><td>'
            'name</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestDeactivateSystemEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html(self):
        prefab = DeactivateSystemEntityEventPrefab("name")
        html_generator = HtmlGenerator()
        sub_generator = SubDeactivateSystemEntityEventPrefabHtmlGenerator()

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Deactivatesystementityevent</p><div><table><tr><th>Classname</th><td>'
            'name</td></tr></table></div></div>',
            html_generator.generate_html(sub_generator.generate_html(prefab))
                .replace(" ", "").replace("\n", "")
        )


class TestEntityEventPrefabHtmlGenerator(unittest.TestCase):
    def test_generate_html_valid(self):
        prefab = ChangeLevelStateEntityEventPrefab("LEVEL_STATE")
        html_generator = HtmlGenerator()
        generator = EntityEventPrefabHtmlGenerator([SubChangeLevelStateEntityEventPrefabHtmlGenerator()])

        self.assertEqual(
            '<divclass="doc-entity-event"><p>Changelevelstateentityevent</p><div><table><tr><th>Levelstate</th><td>L'
            'EVEL_STATE</td></tr></table></div></div>',
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
