import xml.etree.ElementTree as EXml

from lib.graphics.animation_prefab import AnimationPrefabXmlReader
from lib.graphics.particle_effect_prefab import ParticleEffectPrefabXmlReader
from lib.graphics.sprite_prefab import SpritePrefabXmlReader
from lib.utility.surface.position.position_prefab import PositionPrefabXmlReader, PositionPrefab


class ViewPrefab(object):
    def __init__(self, prefab_id, position_prefab):
        self.id = str(prefab_id)
        self.position_prefab = position_prefab

    def get_id(self):
        return self.id

    def get_position_prefab(self):
        return self.position_prefab


class SpriteViewPrefab(ViewPrefab):
    def __init__(self, prefab_id, position_prefab, sprite_prefab):
        super().__init__(prefab_id, position_prefab)
        self.sprite_prefab = sprite_prefab

    def get_sprite_prefab(self):
        return self.sprite_prefab

    def __str__(self):
        return "SpriteViewPrefab(id={}, position_prefab={}, sprite_prefab={})" \
            .format(self.id, str(self.position_prefab), str(self.sprite_prefab))


class AnimationViewPrefab(ViewPrefab):
    def __init__(self, prefab_id, position_prefab, animation_prefab):
        super().__init__(prefab_id, position_prefab)
        self.animation_prefab = animation_prefab

    def get_animation_prefab(self):
        return self.animation_prefab

    def __str__(self):
        return "AnimationViewPrefab(id={}, position_prefab={}, animation_prefab={})" \
            .format(self.id, str(self.position_prefab), str(self.animation_prefab))


class ParticleEffectViewPrefab(ViewPrefab):
    def __init__(self, prefab_id, position_prefab, particle_effect_prefab):
        super().__init__(prefab_id, position_prefab)
        self.particle_effect_prefab = particle_effect_prefab

    def get_particle_effect_prefab(self):
        return self.particle_effect_prefab

    def __str__(self):
        return "ParticleEffectViewPrefab(id={}, position_prefab={}, particle_effect_prefab={})" \
            .format(self.id, self.position_prefab, str(self.particle_effect_prefab))


class ViewPrefabXmlReader(object):
    VIEW_ELEMENT = "view"
    VIEWS_ELEMENT = "views"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefabs = []

            for child in element.findall(self.VIEW_ELEMENT):
                prefabs.append(self.read_prefab_from_string(EXml.tostring(child)))

            return prefabs
        except Exception as e:
            raise ViewPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE).strip()

            if prefab_type not in self.sub_readers:
                raise ViewPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise ViewPrefabXmlReadException(xml_string, e)


class SubViewPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubSpriteViewPrefabXmlReader(SubViewPrefabXmlReader):
    ID_ATTRIBUTE = "id"

    def __init__(self, position_prefab_xml_reader, sprite_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader
        self.sprite_prefab_xml_reader = sprite_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            id = element.get(self.ID_ATTRIBUTE).strip()
            position_prefab = PositionPrefab(0, 0)

            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            sprite_prefab = self.sprite_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(SpritePrefabXmlReader.SPRITE_ELEMENT))
            )
            return SpriteViewPrefab(id, position_prefab, sprite_prefab)
        except Exception as e:
            raise ViewPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "SpriteView"


class SubAnimationViewPrefabXmlReader(SubViewPrefabXmlReader):
    ID_ATTRIBUTE = "id"

    def __init__(self, position_prefab_xml_reader, animation_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader
        self.animation_preafab_xml_reader = animation_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            id = element.get(self.ID_ATTRIBUTE)
            position_prefab = PositionPrefab(0, 0)

            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            animation_prefab = self.animation_preafab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(AnimationPrefabXmlReader.ANIMATION_ELEMENT))
            )
            return AnimationViewPrefab(id, position_prefab, animation_prefab)
        except Exception as e:
            raise ViewPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "AnimationView"


class SubParticleEffectViewPrefabXmlReader(SubViewPrefabXmlReader):
    ID_ATTRIBUTE = "id"

    def __init__(self, position_prefab_xml_reader, particle_effect_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader
        self.particle_effect_prefab_xml_reader = particle_effect_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            id = element.get(self.ID_ATTRIBUTE)
            position_prefab = PositionPrefab(0, 0)

            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            particle_effect_prefab = self.particle_effect_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ParticleEffectPrefabXmlReader.PARTICLE_EFFECT_FILENAME))
            )
            return ParticleEffectViewPrefab(id, position_prefab, particle_effect_prefab)
        except Exception as e:
            raise ViewPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ParticleEffectView"


class ViewPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read view prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class ViewPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "View prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
