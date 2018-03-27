import os
import unittest
import xml.etree.ElementTree as EXml

from lib.audio.music.music_prefab import MusicPrefab, MusicPrefabXmlReader
from lib.audio.sound.sound_prefab import SoundPrefabXmlReader, SoundPrefab
from lib.graphics.camera.camera_effect_prefab import CameraEffectPrefabXmlReader, SubShakeCameraEffectPrefabXmlReader, \
    ShakeCameraEffectPrefab
from lib.level.event.entity_event_prefab import SpawnAirplaneEntityEventPrefab, AmmoLevelUpEntityEventPrefab, \
    SubSpawnAirplaneEntityEventPrefabXmlReader, SubAmmoLevelUpEntityEventPrefabXmlReader, EntityEventPrefabXmlReader, \
    SubAddCameraEffectEntityEventPrefabXmlReader, AddCameraEffectEntityEventPrefab, CreateEntityEventPrefab, \
    EntityEventPrefabXmlReadException, SubCreateEntityEventPrefabXmlReader, DestroyEntityEventPrefab, \
    SubDestroyEntityEventPrefabXmlReader, DestroyEntityByIdEntityEventPrefab, \
    SubDestroyEntityByIdEntityEventPrefabXmlReader, SubDestroyFamilyEntityEventPrefabXmlReader, \
    DestroyFamilyEntityEventPrefab, AddLifeEntityEventPrefab, SubAddLifeEntityEventPrefabXmlReader, \
    SubAddMessageEntityEventPrefabXmlReader, AddMessageEntityEventPrefab, PlayMusicEntityEventPrefab, \
    SubPlayMusicEntityEventPrefabXmlReader, AddPointsEntityEventPrefab, IncreasePointsMultiplierEntityEventPrefab, \
    SubIncreasePointsMultiplierEntityEventPrefabXmlReader, SubAddPointsEntityEventPrefabXmlReader, \
    SubPlaySoundEntityEventPrefabXmlReader, PlaySoundEntityEventPrefab, SubActivateSpawnerEntityEventPrefabXmlReader, \
    ActivateSpawnerEntityEventPrefab, SubChangeLevelStateEntityEventPrefabXmlReader, ChangeLevelStateEntityEventPrefab
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefab, CreateEntryPrefabXmlReader
from lib.level.utility.stage.broker.message.message_prefab import MessagePrefabXmlReader, MessagePrefab
from lib.utility.surface.position.position_prefab import PositionPrefab, PositionPrefabXmlReader

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


class TestSubSpawnAirplaneEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="SpawnAirplaneEntityEvent" />"""
        reader = SubSpawnAirplaneEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubAmmoLevelUpEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="AmmoLevelUpEntityEvent" />"""
        reader = SubAmmoLevelUpEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubAddCameraEffectEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="AddCameraEffectEntityEvent">
                <cameraEffect type="ShakeCameraEffect">
                    <time>1</time>
                    <power>2.1</power>
                </cameraEffect>
            </entityEvent>
        """
        reader = SubAddCameraEffectEntityEventPrefabXmlReader(
            CameraEffectPrefabXmlReader([SubShakeCameraEffectPrefabXmlReader()])
        )
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_camera_effect_prefab().get_power(), 2.1)
        self.assertEqual(prefab.get_camera_effect_prefab().get_time(), 1)

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="AddCameraEffectEntityEvent" />
        """
        reader = SubAddCameraEffectEntityEventPrefabXmlReader(CameraEffectPrefabXmlReader([]))

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubCreateEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="CreateEntityEvent">
                <createEntries>
                    <createEntry>
                        <entityPrefabCode>CODE_0</entityPrefabCode>
                        <position>
                            <x>0.1</x>
                            <y>2.5</y>
                        </position>
                    </createEntry>
                </createEntries>
            </entityEvent>
        """
        reader = SubCreateEntityEventPrefabXmlReader(CreateEntryPrefabXmlReader(PositionPrefabXmlReader()))
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_create_entry_prefabs()[0].get_position_prefab().get_x(), 0.1)
        self.assertEqual(prefab.get_create_entry_prefabs()[0].get_position_prefab().get_y(), 2.5)
        self.assertEqual(prefab.get_create_entry_prefabs()[0].get_prefab_code(), "CODE_0")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="CreateEntityEvent" />
        """
        reader = SubCreateEntityEventPrefabXmlReader(CreateEntryPrefabXmlReader(PositionPrefabXmlReader()))

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubDestroyEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="DestroyEntityEvent" />"""
        reader = SubDestroyEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubDestroyEntityByIdEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="DestroyEntityByIdEntityEvent">
                <id>IDENTITY</id>
            </entityEvent>
        """
        reader = SubDestroyEntityByIdEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "IDENTITY")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="DestroyEntityByIdEntityEvent" />
        """
        reader = SubDestroyEntityByIdEntityEventPrefabXmlReader()

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubDestroyFamilyEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="DestroyFamilyEntityEvent">
                <entityFamily>ENTITY_FAMILY</entityFamily>
            </entityEvent>
        """
        reader = SubDestroyFamilyEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_entity_family(), "ENTITY_FAMILY")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="DestroyFamilyEntityEvent" />
        """
        reader = SubDestroyFamilyEntityEventPrefabXmlReader()

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubAddLifeEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="AddLifeEntityEvent" />"""
        reader = SubAddLifeEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubAddMessageEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="AddMessageEntityEvent">
                <message>
                    <time>2.3</time>
                    <entryKey>ENTRY_KEY</entryKey>
                    <faceId>FACE_ID</faceId>
                </message>
            </entityEvent>
        """
        reader = SubAddMessageEntityEventPrefabXmlReader(MessagePrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_message_prefab().get_time(), 2.3)
        self.assertEqual(prefab.get_message_prefab().get_translation_entry_key(), "ENTRY_KEY")
        self.assertEqual(prefab.get_message_prefab().get_face_id(), "FACE_ID")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="AddMessageEntityEvent" />
        """
        reader = SubAddMessageEntityEventPrefabXmlReader(MessagePrefabXmlReader())

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubPlayMusicEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="PlayMusicEntityEvent">
                <music>
                    <filename>FILENAME</filename>
                </music>
                <musicChannelName>CHANNEL</musicChannelName>
            </entityEvent>
        """
        reader = SubPlayMusicEntityEventPrefabXmlReader(MusicPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_music_channel_name(), "CHANNEL")
        self.assertEqual(prefab.get_music_prefab().get_filename(), "FILENAME")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="PlayMusicEntityEvent" />
        """
        reader = SubPlayMusicEntityEventPrefabXmlReader(MusicPrefabXmlReader())

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubPlaySoundEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="PlaySoundEntityEvent">
                <sound>
                    <filename>FILENAME</filename>
                </sound>
                <soundChannelName>CHANNEL</soundChannelName>
            </entityEvent>
        """
        reader = SubPlaySoundEntityEventPrefabXmlReader(SoundPrefabXmlReader())
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_sound_channel_name(), "CHANNEL")
        self.assertEqual(prefab.get_sound_prefab().get_filename(), "FILENAME")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="PlaySoundEntityEvent" />
        """
        reader = SubPlaySoundEntityEventPrefabXmlReader(SoundPrefabXmlReader())

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubIncreasePointsMultiplierEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="IncreasePointsMultiplierEntityEvent" />"""
        reader = SubIncreasePointsMultiplierEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)


class TestSubAddPointsEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="AddPointsEntityEvent">
                <points>100</points>
            </entityEvent>
        """
        reader = SubAddPointsEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_points(), 100)

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="AddPointsEntityEvent" />
        """
        reader = SubAddPointsEntityEventPrefabXmlReader()

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubActivateSpawnerEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="ActivateSpawnerEntityEvent">
                <id>SPAWNER_ID</id>
            </entityEvent>
        """
        reader = SubActivateSpawnerEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_id(), "SPAWNER_ID")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="ActivateSpawnerEntityEvent" />
        """
        reader = SubActivateSpawnerEntityEventPrefabXmlReader()

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestSubChangeLevelStateEntityEventPrefab(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """
            <entityEvent type="ChangeLevelStateEntityEvent">
                <levelState>STATE</levelState>
            </entityEvent>
        """
        reader = SubChangeLevelStateEntityEventPrefabXmlReader()
        prefab = reader.read_prefab_from_string(xml)

        self.assertEqual(prefab.get_level_state(), "STATE")

    def test_read_prefab_from_string_invalid(self):
        xml = """
            <entityEvent type="ChangeLevelStateEntityEvent" />
        """
        reader = SubChangeLevelStateEntityEventPrefabXmlReader()

        with self.assertRaises(EntityEventPrefabXmlReadException):
            reader.read_prefab_from_string(xml)


class TestEntityEventPrefabXmlReader(unittest.TestCase):
    def test_read_prefab_from_string_valid(self):
        xml = """<entityEvent type="AmmoLevelUpEntityEvent" />"""
        reader = EntityEventPrefabXmlReader([SubAmmoLevelUpEntityEventPrefabXmlReader()])
        prefab = reader.read_prefab_from_string(xml)

        self.assertIsNotNone(prefab)

    def test_read_prefabs_from_string_valid(self):
        xml = """
            <entityEvents>
                <entityEvent type="AmmoLevelUpEntityEvent" />
                <entityEvent type="AmmoLevelUpEntityEvent" />
            </entityEvents>
        """
        reader = EntityEventPrefabXmlReader([SubAmmoLevelUpEntityEventPrefabXmlReader()])
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(2, len(prefabs))

    def test_read_prefabs_from_string_all_valid(self):
        xml = EXml.tostring(EXml.parse(ENTITY_EVENTS_TEST_FILENAME).getroot())
        reader = EntityEventPrefabXmlReader(
            [
                SubAmmoLevelUpEntityEventPrefabXmlReader(),
                SubSpawnAirplaneEntityEventPrefabXmlReader(),
                SubAddCameraEffectEntityEventPrefabXmlReader(
                    CameraEffectPrefabXmlReader(
                        [
                            SubShakeCameraEffectPrefabXmlReader()
                        ]
                    )
                ),
                SubCreateEntityEventPrefabXmlReader(
                    CreateEntryPrefabXmlReader(
                        PositionPrefabXmlReader()
                    )
                ),
                SubDestroyEntityEventPrefabXmlReader(),
                SubDestroyEntityByIdEntityEventPrefabXmlReader(),
                SubDestroyFamilyEntityEventPrefabXmlReader(),
                SubAddLifeEntityEventPrefabXmlReader(),
                SubAddMessageEntityEventPrefabXmlReader(
                    MessagePrefabXmlReader()
                ),
                SubPlayMusicEntityEventPrefabXmlReader(
                    MusicPrefabXmlReader()
                ),
                SubAddPointsEntityEventPrefabXmlReader(),
                SubIncreasePointsMultiplierEntityEventPrefabXmlReader(),
                SubPlaySoundEntityEventPrefabXmlReader(
                    SoundPrefabXmlReader()
                ),
                SubActivateSpawnerEntityEventPrefabXmlReader(),
                SubChangeLevelStateEntityEventPrefabXmlReader()
            ]
        )
        prefabs = reader.read_prefabs_from_string(xml)

        self.assertEqual(15, len(prefabs))
