import xml.etree.ElementTree as EXml

from lib.utility.string_functions import *


class SpritePrefab(object):
    def __init__(self, flip_x, flip_y):
        self.flip_x = bool(flip_x)
        self.flip_y = bool(flip_y)

    def get_flip_x(self):
        return self.flip_x

    def get_flip_y(self):
        return self.flip_y


class FileSpritePrefab(SpritePrefab):
    def __init__(self, flip_x, flip_y, filename):
        super().__init__(flip_x, flip_y)
        self.filename = str(filename)

    def get_filename(self):
        return self.filename

    def __str__(self):
        return "FileSpritePrefab(flip_x={}, flip_y={}, filename={})" \
                    .format(self.flip_x, self.flip_y, self.filename)


class AtlasSpritePrefab(SpritePrefab):
    def __init__(self, flip_x, flip_y, atlas_filename, region_name):
        super().__init__(flip_x, flip_y)
        self.atlas_filename = str(atlas_filename)
        self.region_name = region_name

    def get_atlas_filename(self):
        return self.atlas_filename

    def get_region_name(self):
        return self.region_name

    def __str__(self):
        return "AtlasSpritePrefab(flip_x={}, flip_y={}, atlas_filename={}, region_name={})" \
                    .format(self.flip_x, self.flip_y, self.atlas_filename, self.region_name)


class SpritePrefabXmlReader(object):
    SPRITE_ELEMENT = "sprite"
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
                raise SpritePrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise SpritePrefabXmlReadException(xml_string, e)


class SubSpritePrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubFileSpritePrefabXmlReader(SubSpritePrefabXmlReader):
    FLIP_X_ATTRIBUTE = "flipX"
    FLIP_Y_ATTRIBUTE = "flipY"
    FILENAME_ELEMENT = "filename"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            filename = element.find(self.FILENAME_ELEMENT).text.strip()
            flip_x = string_to_boolean(element.get(self.FLIP_X_ATTRIBUTE))
            flip_y = string_to_boolean(element.get(self.FLIP_Y_ATTRIBUTE))
            return FileSpritePrefab(flip_x, flip_y, filename)
        except Exception as e:
            raise SpritePrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "FileSprite"


class SubAtlasSpritePrefabXmlReader(SubSpritePrefabXmlReader):
    FLIP_X_ATTRIBUTE = "flipX"
    FLIP_Y_ATTRIBUTE = "flipY"
    ATLAS_FILENAME_ELEMENT = "atlasFilename"
    REGION_NAME_ELEMENT = "regionName"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            atlas_filename = element.find(self.ATLAS_FILENAME_ELEMENT).text.strip()
            region_name = element.find(self.REGION_NAME_ELEMENT).text.strip()
            flip_x = string_to_boolean(element.get(self.FLIP_X_ATTRIBUTE))
            flip_y = string_to_boolean(element.get(self.FLIP_Y_ATTRIBUTE))
            return AtlasSpritePrefab(flip_x, flip_y, atlas_filename, region_name)
        except Exception as e:
            raise SpritePrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AtlasSprite"


class SpritePrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read sprite prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class SpritePrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Sprite prefab reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
