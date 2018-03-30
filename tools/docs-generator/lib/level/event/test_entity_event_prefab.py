import os
import unittest

from lib.audio.music.music_prefab import MusicPrefab
from lib.audio.sound.sound_prefab import SoundPrefab
from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab
from lib.level.event.entity_event_prefab import ChangeLevelStateEntityEventPrefab, ActivateSpawnerEntityEventPrefab, \
    IncreasePointsMultiplierEntityEventPrefab, AddPointsEntityEventPrefab, PlaySoundEntityEventPrefab, \
    PlayMusicEntityEventPrefab, AddMessageEntityEventPrefab, AddLifeEntityEventPrefab, DestroyFamilyEntityEventPrefab, \
    DestroyEntityByIdEntityEventPrefab, DestroyEntityEventPrefab, CreateEntityEventPrefab, \
    AddCameraEffectEntityEventPrefab, AmmoLevelUpEntityEventPrefab, SpawnAirplaneEntityEventPrefab
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab
from lib.level.utility.stage.broker.message.message_prefab import MessagePrefab
from lib.utility.surface.position.position_prefab import PositionPrefab

ENTITY_EVENTS_TEST_FILENAME = os.path.join(
    os.path.dirname(__file__), 'test-entity-events-prefabs-all.xml')


class TestSpawnAirplaneEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(SpawnAirplaneEntityEventPrefab()),
            "SpawnAirplaneEntityEventPrefab()"
        )


class TestAmmoLevelUpEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(AmmoLevelUpEntityEventPrefab()),
            "AmmoLevelUpEntityEventPrefab()"
        )


class TestAddCameraEffectEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(AddCameraEffectEntityEventPrefab(ShakeCameraEffectPrefab(1.1, 2.2))),
            "AddCameraEffectEntityEventPrefab(camera_effect_prefab={})"
                .format(ShakeCameraEffectPrefab(1.1, 2.2))
        )


class TestCreateEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        create_entry_prefabs = [CreateEntryPrefab("CODE0", PositionPrefab(1.1, 2.2)),
                                CreateEntryPrefab("CODE1", PositionPrefab(3.3, 4.4))]

        self.assertEqual(
            str(CreateEntityEventPrefab(create_entry_prefabs)),
            "CreateEntityEventPrefab(create_entry_prefabs=[{}])"
                .format(", ".join('\'{}\''.format(str(val)) for val in create_entry_prefabs))
        )


class TestDestroyEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(DestroyEntityEventPrefab()),
            "DestroyEntityEventPrefab()"
        )


class TestDestroyEntityByIdEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(DestroyEntityByIdEntityEventPrefab("IDENTITY")),
            "DestroyEntityByIdEntityEventPrefab(id=IDENTITY)"
        )


class TestDestroyFamilyEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(DestroyFamilyEntityEventPrefab("ENTITY_FAMILY")),
            "DestroyFamilyEntityEventPrefab(entity_family=ENTITY_FAMILY)"
        )


class TestAddLifeEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(AddLifeEntityEventPrefab()),
            "AddLifeEntityEventPrefab()"
        )


class TestAddMessageEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(AddMessageEntityEventPrefab(MessagePrefab(1.1, "ENTRY_KEY", "FACE_ID"))),
            "AddMessageEntityEventPrefab(message_prefab={})".format(str(MessagePrefab(1.1, "ENTRY_KEY", "FACE_ID")))
        )


class TestPlayMusicEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(PlayMusicEntityEventPrefab(MusicPrefab("FILENAME"), "CHANNEL")),
            "PlayMusicEntityEventPrefab(music_prefab={}, music_channel_name=CHANNEL)"
                .format(str(MusicPrefab("FILENAME")))
        )


class TestPlaySoundEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(PlaySoundEntityEventPrefab(SoundPrefab("FILENAME"), "CHANNEL")),
            "PlaySoundEntityEventPrefab(sound_prefab={}, sound_channel_name=CHANNEL)"
                .format(str(SoundPrefab("FILENAME")))
        )


class TestAddPointsEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(AddPointsEntityEventPrefab(10)),
            "AddPointsEntityEventPrefab(points=10)"
        )


class TestIncreasePointsMultiplierEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(IncreasePointsMultiplierEntityEventPrefab()),
            "IncreasePointsMultiplierEntityEventPrefab()"
        )


class TestActivateSpawnerEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(ActivateSpawnerEntityEventPrefab("ID")),
            "ActivateSpawnerEntityEventPrefab(id=ID)"
        )


class TestChangeLevelStateEntityEventPrefab(unittest.TestCase):
    def test_entity_event_prefab_to_string(self):
        self.assertEqual(
            str(ChangeLevelStateEntityEventPrefab("STATE")),
            "ChangeLevelStateEntityEventPrefab(level_state=STATE)"
        )


if __name__ == "__main__":
    unittest.main()
