import xml.etree.ElementTree as EXml

from lib.graphics.particles.particle_effect_prefab import FileParticleEffectPrefab, AtlasParticleEffectPrefab
from lib.utility.string_functions import string_to_boolean


class ParticleEffectPrefabXmlReader(object):
    PARTICLE_EFFECT_FILENAME = "particleEffect"
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
                raise ParticleEffectPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise ParticleEffectPrefabXmlReadException(xml_string, e)


class SubParticleEffectPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubFileParticleEffectPrefabXmlReader(SubParticleEffectPrefabXmlReader):
    FLIP_X_ATTRIBUTE = "flipX"
    FLIP_Y_ATTRIBUTE = "flipY"
    FILENAME_ELEMENT = "filename"
    IMAGES_DIRECTORY_ELEMENT = "imagesDirectory"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            flip_x = string_to_boolean(element.get(self.FLIP_X_ATTRIBUTE))
            flip_y = string_to_boolean(element.get(self.FLIP_Y_ATTRIBUTE))
            filename = element.find(self.FILENAME_ELEMENT).text.strip()
            images_directory = element.find(self.IMAGES_DIRECTORY_ELEMENT).text.strip()
            return FileParticleEffectPrefab(flip_x, flip_y, filename, images_directory)
        except Exception as e:
            raise ParticleEffectPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "FileParticleEffect"


class SubAtlasParticleEffectPrefabXmlReader(SubParticleEffectPrefabXmlReader):
    FLIP_X_ATTRIBUTE = "flipX"
    FLIP_Y_ATTRIBUTE = "flipY"
    ATLAS_FILENAME_ELEMENT = "atlasFilename"
    FILENAME_ELEMENT = "filename"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            flip_x = string_to_boolean(element.get(self.FLIP_X_ATTRIBUTE))
            flip_y = string_to_boolean(element.get(self.FLIP_Y_ATTRIBUTE))
            filename = element.find(self.FILENAME_ELEMENT).text.strip()
            atlas_filename = element.find(self.ATLAS_FILENAME_ELEMENT).text.strip()
            return AtlasParticleEffectPrefab(flip_x, flip_y, filename, atlas_filename)
        except Exception as e:
            raise ParticleEffectPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AtlasParticleEffect"


class ParticleEffectPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Particle effect prefab reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))


class ParticleEffectPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read particle effect prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
