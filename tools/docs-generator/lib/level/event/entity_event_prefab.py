class EntityEventPrefab(object):
    def __str__(self):
        raise NotImplemented("Not implemented yet.")


class SpawnAirplaneEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "SpawnAirplaneEntityEventPrefab()"


class AmmoLevelUpEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "AmmoLevelUpEntityEventPrefab()"


class AddCameraEffectEntityEventPrefab(EntityEventPrefab):
    def __init__(self, camera_effect_prefab):
        self.camera_effect_prefab = camera_effect_prefab

    def get_camera_effect_prefab(self):
        return self.camera_effect_prefab

    def __str__(self):
        return "AddCameraEffectEntityEventPrefab(camera_effect_prefab={})" \
            .format(str(self.camera_effect_prefab))


class CreateEntityEventPrefab(EntityEventPrefab):
    def __init__(self, create_entry_prefabs):
        self.create_entry_prefabs = create_entry_prefabs

    def get_create_entry_prefabs(self):
        return self.create_entry_prefabs

    def __str__(self):
        return "CreateEntityEventPrefab(create_entry_prefabs=[{}])" \
            .format(", ".join('\'{}\''.format(str(val)) for val in self.create_entry_prefabs))


class DestroyEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "DestroyEntityEventPrefab()"


class DestroyEntityByIdEntityEventPrefab(EntityEventPrefab):
    def __init__(self, id):
        self.id = str(id)

    def get_id(self):
        return self.id

    def __str__(self):
        return "DestroyEntityByIdEntityEventPrefab(id={})".format(self.id)


class DestroyFamilyEntityEventPrefab(EntityEventPrefab):
    def __init__(self, entity_family):
        self.entity_family = entity_family

    def get_entity_family(self):
        return self.entity_family

    def __str__(self):
        return "DestroyFamilyEntityEventPrefab(entity_family={})".format(self.entity_family)


class AddLifeEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "AddLifeEntityEventPrefab()"


class AddMessageEntityEventPrefab(EntityEventPrefab):
    def __init__(self, message_prefab):
        self.message_prefab = message_prefab

    def get_message_prefab(self):
        return self.message_prefab

    def __str__(self):
        return "AddMessageEntityEventPrefab(message_prefab={})".format(str(self.message_prefab))


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


class AddPointsEntityEventPrefab(EntityEventPrefab):
    def __init__(self, points):
        self.points = int(points)

    def get_points(self):
        return self.points

    def __str__(self):
        return "AddPointsEntityEventPrefab(points={})".format(self.points)


class IncreasePointsMultiplierEntityEventPrefab(EntityEventPrefab):
    def __str__(self):
        return "IncreasePointsMultiplierEntityEventPrefab()"


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


class ActivateSpawnerEntityEventPrefab(EntityEventPrefab):
    def __init__(self, id):
        self.id = str(id)

    def get_id(self):
        return self.id

    def __str__(self):
        return "ActivateSpawnerEntityEventPrefab(id={})".format(self.id)


class ChangeLevelStateEntityEventPrefab(EntityEventPrefab):
    def __init__(self, level_state):
        self.level_state = str(level_state)

    def get_level_state(self):
        return self.level_state

    def __str__(self):
        return "ChangeLevelStateEntityEventPrefab(level_state={})".format(self.level_state)
