import xml.etree.ElementTree as EXml

from lib.audio.music.music_prefab import MusicPrefabXmlReader
from lib.audio.sound.sound_prefab import SoundPrefabXmlReader
from lib.graphics.camera.camera_effect_prefab import CameraEffectPrefabXmlReader
from lib.level.utility.create.create_entry_prefab import CreateEntryPrefabXmlReader
from lib.level.utility.stage.broker.message.message_prefab import MessagePrefabXmlReader


class EntityEventPrefab(object):
    def __str__(self):
        raise NotImplemented("Not implemented yet.")


class EntityEventPrefabXmlReader(object):
    ENTITY_EVENT_ELEMENT = "entityEvent"
    ENTITY_EVENTS_ELEMENT = "entityEvents"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            prefabs = []
            for element in EXml.fromstring(xml_string).findall(self.ENTITY_EVENT_ELEMENT):
                prefabs.append(self.read_prefab_from_string(EXml.tostring(element)))

            return prefabs
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE).strip()

            if prefab_type not in self.sub_readers:
                raise EntityEventPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)


class EntityEventPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read event prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class EntityEventPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Event prefab xml reader of {} event type not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))


class SubEntityEventPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplemented("Not implemented yet.")

    def get_type(self):
        raise NotImplemented("Not implemented yet.")


class SpawnAirplaneEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "SpawnAirplaneEntityEventPrefab()"


class SubSpawnAirplaneEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return SpawnAirplaneEntityEventPrefab()

    def get_type(self):
        return "SpawnAirplaneEntityEvent"


class AmmoLevelUpEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "AmmoLevelUpEntityEventPrefab()"


class SubAmmoLevelUpEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AmmoLevelUpEntityEventPrefab()

    def get_type(self):
        return "AmmoLevelUpEntityEvent"


class AddCameraEffectEntityEventPrefab(EntityEventPrefab):
    def __init__(self, camera_effect_prefab):
        self.camera_effect_prefab = camera_effect_prefab

    def get_camera_effect_prefab(self):
        return self.camera_effect_prefab

    def __str__(self):
        return "AddCameraEffectEntityEventPrefab(camera_effect_prefab={})" \
            .format(str(self.camera_effect_prefab))


class SubAddCameraEffectEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def __init__(self, camera_effect_prefab_xml_reader):
        self.camera_effect_prefab_xml_reader = camera_effect_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            camera_effect_prefab = self.camera_effect_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(CameraEffectPrefabXmlReader.CAMERA_EFFECT_ELEMENT))
            )

            return AddCameraEffectEntityEventPrefab(camera_effect_prefab)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AddCameraEffectEntityEvent"


class CreateEntityEventPrefab(EntityEventPrefab):
    def __init__(self, create_entry_prefabs):
        self.create_entry_prefabs = create_entry_prefabs

    def get_create_entry_prefabs(self):
        return self.create_entry_prefabs

    def __str__(self):
        return "CreateEntityEventPrefab(create_entry_prefabs=[{}])" \
            .format(", ".join('\'{}\''.format(str(val)) for val in self.create_entry_prefabs))


class SubCreateEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def __init__(self, create_entry_prefab_xml_reader):
        self.create_entry_prefab_xml_reader = create_entry_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            create_entry_prefabs = self.create_entry_prefab_xml_reader.read_prefabs_from_string(
                EXml.tostring(element.find(CreateEntryPrefabXmlReader.CREATE_ENTRIES_ELEMENT))
            )

            return CreateEntityEventPrefab(create_entry_prefabs)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "CreateEntityEvent"


class DestroyEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "DestroyEntityEventPrefab()"


class SubDestroyEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return DestroyEntityEventPrefab()

    def get_type(self):
        return "DestroyEntityEvent"


class DestroyEntityByIdEntityEventPrefab(EntityEventPrefab):
    def __init__(self, id):
        self.id = str(id)

    def get_id(self):
        return self.id

    def __str__(self):
        return "DestroyEntityByIdEntityEventPrefab(id={})".format(self.id)


class SubDestroyEntityByIdEntityEventPrefabXmlReader(SubDestroyEntityEventPrefabXmlReader):
    ID_ELEMENT = "id"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            id = element.find(self.ID_ELEMENT).text.strip()

            return DestroyEntityByIdEntityEventPrefab(id)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "DestroyEntityByIdEntityEvent"


class DestroyFamilyEntityEventPrefab(EntityEventPrefab):
    def __init__(self, entity_family):
        self.entity_family = entity_family

    def get_entity_family(self):
        return self.entity_family

    def __str__(self):
        return "DestroyFamilyEntityEventPrefab(entity_family={})".format(self.entity_family)


class SubDestroyFamilyEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    ENTITY_FAMILY = "entityFamily"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            entity_family = element.find(self.ENTITY_FAMILY).text.strip()

            return DestroyFamilyEntityEventPrefab(entity_family)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "DestroyFamilyEntityEvent"


class AddLifeEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "AddLifeEntityEventPrefab()"


class SubAddLifeEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return AddLifeEntityEventPrefab()

    def get_type(self):
        return "AddLifeEntityEvent"


class AddMessageEntityEventPrefab(EntityEventPrefab):
    def __init__(self, message_prefab):
        self.message_prefab = message_prefab

    def get_message_prefab(self):
        return self.message_prefab

    def __str__(self):
        return "AddMessageEntityEventPrefab(message_prefab={})".format(str(self.message_prefab))


class SubAddMessageEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def __init__(self, message_prefab_xml_reader):
        self.message_prefab_xml_reader = message_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            message_prefab = self.message_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(MessagePrefabXmlReader.MESSAGE_ELEMENT))
            )

            return AddMessageEntityEventPrefab(message_prefab)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AddMessageEntityEvent"


class PlayMusicEntityEventPrefab(EntityEventPrefab):
    def __init__(self, music_prefab, music_channel_name):
        self.music_prefab = music_prefab
        self.music_channel_name = music_channel_name

    def get_music_prefab(self):
        return self.music_prefab

    def get_music_channel_name(self):
        return self.music_channel_name

    def __str__(self):
        return "PlayMusicEntityEventPrefab(music_prefab={}, music_channel_name={})" \
            .format(str(self.music_prefab), self.music_channel_name)


class SubPlayMusicEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    MUSIC_CHANNEL_NAME_ELEMENT = "musicChannelName"

    def __init__(self, music_prefab_xml_reader):
        self.music_prefab_xml_reader = music_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            music_prefab = self.music_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(MusicPrefabXmlReader.MUSIC_ELEMENT))
            )
            music_channel_name = element.find(self.MUSIC_CHANNEL_NAME_ELEMENT).text.strip()

            return PlayMusicEntityEventPrefab(music_prefab, music_channel_name)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "PlayMusicEntityEvent"


class AddPointsEntityEventPrefab(EntityEventPrefab):
    def __init__(self, points):
        self.points = int(points)

    def get_points(self):
        return self.points

    def __str__(self):
        return "AddPointsEntityEventPrefab(points={})".format(self.points)


class SubAddPointsEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    POINTS_ELEMENT = "points"

    def read_prefab_from_string(self, xml_string):
        try:
            points = int(EXml.fromstring(xml_string).find(self.POINTS_ELEMENT).text.strip())

            return AddPointsEntityEventPrefab(points)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AddPointsEntityEvent"


class IncreasePointsMultiplierEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "IncreasePointsMultiplierEntityEventPrefab()"


class SubIncreasePointsMultiplierEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    def read_prefab_from_string(self, xml_string):
        return IncreasePointsMultiplierEntityEventPrefab()

    def get_type(self):
        return "IncreasePointsMultiplierEntityEvent"


class PlaySoundEntityEventPrefab(EntityEventPrefab):
    def __init__(self, sound_prefab, sound_channel_name):
        self.sound_prefab = sound_prefab
        self.sound_channel_name = sound_channel_name

    def get_sound_prefab(self):
        return self.sound_prefab

    def get_sound_channel_name(self):
        return self.sound_channel_name

    def __str__(self):
        return "PlaySoundEntityEventPrefab(sound_prefab={}, sound_channel_name={})" \
            .format(str(self.sound_prefab), self.sound_channel_name)


class SubPlaySoundEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    SOUND_CHANNEL_NAME_ELEMENT = "soundChannelName"

    def __init__(self, sound_prefab_xml_reader):
        self.sound_prefab_xml_reader = sound_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            sound_prefab = self.sound_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(SoundPrefabXmlReader.SOUND_ELEMENT))
            )
            sound_channel_name = element.find(self.SOUND_CHANNEL_NAME_ELEMENT).text.strip()

            return PlaySoundEntityEventPrefab(sound_prefab, sound_channel_name)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "PlaySoundEntityEvent"


class ActivateSpawnerEntityEventPrefab(EntityEventPrefab):
    def __init__(self, id):
        self.id = str(id)

    def get_id(self):
        return self.id

    def __str__(self):
        return "ActivateSpawnerEntityEventPrefab(id={})".format(self.id)


class SubActivateSpawnerEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    ID_ELEMENT = "id"

    def read_prefab_from_string(self, xml_string):
        try:
            id = EXml.fromstring(xml_string).find(self.ID_ELEMENT).text.strip()

            return ActivateSpawnerEntityEventPrefab(id)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ActivateSpawnerEntityEvent"


class ChangeLevelStateEntityEventPrefab(EntityEventPrefab):
    def __init__(self, level_state):
        self.level_state = str(level_state)

    def get_level_state(self):
        return self.level_state

    def __str__(self):
        return "ChangeLevelStateEntityEventPrefab(level_state={})".format(self.level_state)


class SubChangeLevelStateEntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader):
    LEVEL_STATE_ELEMENT = "levelState"

    def read_prefab_from_string(self, xml_string):
        try:
            level_state = EXml.fromstring(xml_string).find(self.LEVEL_STATE_ELEMENT).text.strip()

            return ChangeLevelStateEntityEventPrefab(level_state)
        except Exception as e:
            raise EntityEventPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ChangeLevelStateEntityEvent"
