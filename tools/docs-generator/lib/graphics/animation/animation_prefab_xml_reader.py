import xml.etree.ElementTree as EXml

from lib.graphics.animation.animation_prefab import FileAnimationPrefab, AtlasAnimationPrefab
from lib.utility.string_functions import string_to_boolean


class AnimationPrefabXmlReader(object):
    ANIMATION_ELEMENT = "animation"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE).strip()

            if prefab_type not in self.sub_readers:
                raise AnimationPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise AnimationPrefabXmlReadException(xml_string, e)


class SubAnimationPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubAtlasAnimationPrefabXmlReader(SubAnimationPrefabXmlReader):
    FLIP_X_ATTRIBUTE = "flipX"
    FLIP_Y_ATTRIBUTE = "flipY"
    PLAY_MODE_ATTRIBUTE = "playMode"
    ATLAS_FILENAME_ATTRIBUTE = "atlasFilename"
    FRAME_DURATION_ATTRIBUTE = "frameDuration"
    FRAME_ELEMENT = "frame"
    REGION_NAME_ATTRIBUTE = "regionName"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            flip_x = string_to_boolean(element.get(self.FLIP_X_ATTRIBUTE))
            flip_y = string_to_boolean(element.get(self.FLIP_Y_ATTRIBUTE))
            atlas_filename = str(element.get(self.ATLAS_FILENAME_ATTRIBUTE).strip())
            region_names = []
            for child in element.findall(self.FRAME_ELEMENT):
                region_names.append(child.get(self.REGION_NAME_ATTRIBUTE))
            frame_duration = float(element.get(self.FRAME_DURATION_ATTRIBUTE))
            play_mode = str(element.get(self.PLAY_MODE_ATTRIBUTE).strip())
            return AtlasAnimationPrefab(flip_x, flip_y, atlas_filename, region_names, frame_duration, play_mode)
        except Exception as e:
            raise AnimationPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AtlasAnimation"


class SubFileAnimationPrefabXmlReader(SubAnimationPrefabXmlReader):
    FLIP_X_ATTRIBUTE = "flipX"
    FLIP_Y_ATTRIBUTE = "flipY"
    PLAY_MODE_ATTRIBUTE = "playMode"
    FRAME_DURATION_ATTRIBUTE = "frameDuration"
    FRAME_ELEMENT = "frame"
    FILENAME_ATTRIBUTE = "filename"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            flip_x = string_to_boolean(element.get(self.FLIP_X_ATTRIBUTE))
            flip_y = string_to_boolean(element.get(self.FLIP_Y_ATTRIBUTE))
            filenames = []
            for child in element.findall(self.FRAME_ELEMENT):
                filenames.append(child.get(self.FILENAME_ATTRIBUTE))
            frame_duration = float(element.get(self.FRAME_DURATION_ATTRIBUTE))
            play_mode = str(element.get(self.PLAY_MODE_ATTRIBUTE).strip())
            return FileAnimationPrefab(flip_x, flip_y, filenames, frame_duration, play_mode)
        except Exception as e:
            raise AnimationPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "FileAnimation"


class AnimationPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read animation prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class AnimationPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Animation prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
