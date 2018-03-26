import xml.etree.ElementTree as EXml

from lib.graphics.color_prefab import ColorPrefabXmlReader
from lib.graphics.shader_program_prefab import ShaderProgramPrefabXmlReader


class EffectPrefab(object):
    pass


class TintEffectPrefab(EffectPrefab):
    def __init__(self, color_prefab):
        self.color_prefab = color_prefab

    def get_color_prefab(self):
        return self.color_prefab

    def __str__(self):
        return "TintEffectPrefab(color_prefab={})".format(str(self.color_prefab))


class AlphaEffectPrefab(EffectPrefab):
    def __init__(self, alpha_value):
        self.alpha_value = int(alpha_value)

    def get_alpha_value(self):
        return self.alpha_value

    def __str__(self):
        return "AlphaEffectPrefab(alpha_value={})".format(self.alpha_value)


class ShaderEffectPrefab(EffectPrefab):
    def __init__(self, shader_program_prefab):
        self.shader_program_prefab = shader_program_prefab

    def get_shader_program_prefab(self):
        return self.shader_program_prefab

    def __str__(self):
        return "ShaderEffectPrefab(shader_program_prefab={})".format(str(self.shader_program_prefab))


class EffectPrefabXmlReader(object):
    EFFECT_ELEMENT = "effect"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE)

            if prefab_type not in self.sub_readers:
                raise EffectPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise EffectPrefabXmlReadException(xml_string, e)


class SubEffectPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubTintEffectPrefabXmlReader(SubEffectPrefabXmlReader):
    def __init__(self, color_prefab_xml_reader):
        self.color_prefab_xml_reader = color_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            color_prefab = self.color_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ColorPrefabXmlReader.COLOR_ELEMENT))
            )
            return TintEffectPrefab(color_prefab)
        except Exception as e:
            raise EffectPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "TintEffect"


class SubAlphaEffectPrefabXmlReader(SubEffectPrefabXmlReader):
    ALPHA_VALUE_ELEMENT = "alphaValue"

    def read_prefab_from_string(self, xml_string):
        try:
            alpha_value = int(EXml.fromstring(xml_string).find(self.ALPHA_VALUE_ELEMENT).text.strip())
            return AlphaEffectPrefab(alpha_value)
        except Exception as e:
            raise EffectPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AlphaEffect"


class SubShaderEffectPrefabXmlReader(SubEffectPrefabXmlReader):
    def __init__(self, shader_program_prefab_xml_reader):
        self.shader_program_prefab_xml_reader = shader_program_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            shader_program_prefab = self.shader_program_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ShaderProgramPrefabXmlReader.SHADER_PROGRAM_ELEMENT))
            )
            return ShaderEffectPrefab(shader_program_prefab)
        except Exception as e:
            raise EffectPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ShaderEffect"


class EffectPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read effect prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class EffectPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Effect prefab reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))