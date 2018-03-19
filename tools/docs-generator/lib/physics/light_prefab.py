import xml.etree.ElementTree as EXml

from lib.graphics.color_prefab import ColorPrefabXmlReader
from lib.utility.UtilityFunctions import *
from lib.utility.surface.position.position_prefab import PositionPrefabXmlReader


class LightPrefab(object):
    def __init__(self, color_prefab, x_ray):
        self.color_prefab = color_prefab
        self.x_ray = bool(x_ray)

    def get_color_prefab(self):
        return self.color_prefab

    def get_x_ray(self):
        return self.x_ray


class PointLightPrefab(LightPrefab):
    def __init__(self, color_prefab, x_ray, position_prefab, distance):
        super().__init__(color_prefab, x_ray)
        self.position_prefab = position_prefab
        self.distance = float(distance)

    def get_position_prefab(self):
        return self.position_prefab

    def get_distance(self):
        return self.distance

    def __str__(self):
        return "PointLightPrefab(color_prefab={}, x_ray={}, position_prefab={}, distance={})"\
            .format(self.color_prefab, self.x_ray, self.position_prefab, self.distance)


class DirectionalLightPrefab(LightPrefab):
    def __init__(self, color_prefab, x_ray, direction_degree):
        super().__init__(color_prefab, x_ray)
        self.direction_degree = float(direction_degree)

    def get_direction_degree(self):
        return self.direction_degree

    def __str__(self):
        return "DirectionalLightPrefab(color_prefab={}, x_ray={}, direction_degree={})"\
            .format(self.color_prefab, self.x_ray, self.direction_degree)


class ConeLightPrefab(LightPrefab):
    def __init__(self, color_prefab, x_ray, position_prefab, distance, direction_degree, cone_degree):
        super().__init__(color_prefab, x_ray)
        self.position_prefab = position_prefab
        self.distance = float(distance)
        self.direction_degree = float(direction_degree)
        self.cone_degree = float(cone_degree)

    def get_position_prefab(self):
        return self.position_prefab

    def get_distance(self):
        return self.distance

    def get_direction_degree(self):
        return self.direction_degree

    def get_cone_degree(self):
        return self.cone_degree

    def __str__(self):
        return "ConeLightPrefab(color_prefab={}, x_ray={}, position_prefab={}, distance={}, direction_degree={}, " \
               "cone_degree={})" \
                    .format(self.color_prefab, self.x_ray, self.position_prefab, self.distance,self.direction_degree,
                            self.cone_degree)


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
            color_prefab = self.color_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ColorPrefabXmlReader.COLOR_ELEMENT))
            )
            x_ray = string_to_boolean(element.find(self.X_RAY_ELEMENT).text)
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
            color_prefab = self.color_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ColorPrefabXmlReader.COLOR_ELEMENT))
            )
            x_ray = string_to_boolean(element.find(self.X_RAY_ELEMENT).text)
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


class LightHandlerPrefab(object):
    def __init__(self, prefab_id, light_prefab):
        self.id = prefab_id
        self.light_prefab = light_prefab

    def get_id(self):
        return self.id

    def get_light_prefab(self):
        return self.light_prefab

    def __str__(self):
        return "LightHandlerPrefab(id={}, light_prefab={})"\
            .format(self.id, self.light_prefab)


class LightHandlerPrefabXmlReader(object):
    LIGHT_HANDLER_ELEMENT = "lightHandler"
    LIGHT_HANDLERS_ELEMENT = "lightHandlers"
    ID_ATTRIBUTE = "id"

    def __init__(self, light_prefab_xml_reader):
        self.light_prefab_xml_reader = light_prefab_xml_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            handlers = []
            element = EXml.fromstring(xml_string)
            for child in element.findall(self.LIGHT_HANDLER_ELEMENT):
                handlers.append(self.read_prefab_from_string(EXml.tostring(child)))
            return handlers
        except Exception as e:
            raise LightHandlerPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            light_prefab = self.light_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(LightPrefabXmlReader.LIGHT_ELEMENT))
            )
            prefab_id = element.get(self.ID_ATTRIBUTE).strip()

            return LightHandlerPrefab(prefab_id, light_prefab)
        except Exception as e:
            raise LightHandlerPrefabXmlReadException(xml_string, e)


class LightHandlerPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read light handler prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))