import xml.etree.ElementTree as EXml

from lib.graphics.color.color_prefab_xml_reader import ColorPrefabXmlReader
from lib.physics.light.light_prefab import PointLightPrefab, DirectionalLightPrefab, ConeLightPrefab
from lib.utility.string_functions import string_to_boolean
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class LightPrefabXmlReader(object):
    LIGHT_ELEMENT = "light"
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
                raise LightPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise LightPrefabXmlReadException(xml_string, e)


class SubLightPrefabXmlReader(object):
    def __init__(self, color_prefab_xml_reader):
        self.color_prefab_xml_reader = color_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class SubPointLightPrefabXmlReader(SubLightPrefabXmlReader):
    X_RAY_ELEMENT = "xRay"
    DISTANCE_ELEMENT = "distance"

    def __init__(self, color_prefab_xml_reader, position_prefab_xml_reader):
        super().__init__(color_prefab_xml_reader)
        self.position_prefab_xml_reader = position_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            color_prefab = self.color_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ColorPrefabXmlReader.COLOR_ELEMENT))
            )
            x_ray = string_to_boolean(element.find(self.X_RAY_ELEMENT).text)

            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            distance = float(element.find(self.DISTANCE_ELEMENT).text)

            return PointLightPrefab(color_prefab, x_ray, position_prefab, distance)
        except Exception as e:
            raise LightPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "PointLight"


class SubDirectionalLightPrefabXmlReader(SubLightPrefabXmlReader):
    X_RAY_ELEMENT = "xRay"
    DIRECTION_DEGREE_ELEMENT = "directionDegree"

    def __init__(self, color_prefab_xml_reader):
        super().__init__(color_prefab_xml_reader)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            color_prefab = self.color_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ColorPrefabXmlReader.COLOR_ELEMENT))
            )
            x_ray = string_to_boolean(element.find(self.X_RAY_ELEMENT).text)
            direction_degree = float(element.find(self.DIRECTION_DEGREE_ELEMENT).text)

            return DirectionalLightPrefab(color_prefab, x_ray, direction_degree)
        except Exception as e:
            raise LightPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "DirectionalLight"


class SubConeLightPrefabXmlReader(SubLightPrefabXmlReader):
    X_RAY_ELEMENT = "xRay"
    DIRECTION_DEGREE_ELEMENT = "directionDegree"
    CONE_DEGREE_ELEMENT = "coneDegree"
    DISTANCE_ELEMENT = "distance"

    def __init__(self, color_prefab_xml_reader, position_prefab_xml_reader):
        super().__init__(color_prefab_xml_reader)
        self.position_prefab_xml_reader = position_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            color_prefab = self.color_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ColorPrefabXmlReader.COLOR_ELEMENT))
            )
            x_ray = string_to_boolean(element.find(self.X_RAY_ELEMENT).text)

            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            distance = float(element.find(self.DISTANCE_ELEMENT).text)
            direction_degree = float(element.find(self.DIRECTION_DEGREE_ELEMENT).text)
            cone_degree = float(element.find(self.CONE_DEGREE_ELEMENT).text)

            return ConeLightPrefab(color_prefab, x_ray, position_prefab, distance, direction_degree, cone_degree)
        except Exception as e:
            raise LightPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ConeLight"


class LightPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read light prefab from xml string {}. Cause: {}"

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class LightPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Light prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
