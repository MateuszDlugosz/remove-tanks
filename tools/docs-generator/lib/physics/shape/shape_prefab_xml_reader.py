import xml.etree.ElementTree as EXml

from lib.physics.shape.shape_prefab import RectangleShapePrefab, CircleShapePrefab, PolygonShapePrefab
from lib.physics.shape.vertex_prefab_xml_reader import VertexPrefabXmlReader
from lib.utility.surface.position.position_prefab import PositionPrefab
from lib.utility.surface.position.position_prefab_xml_reader import PositionPrefabXmlReader


class ShapePrefabXmlReader(object):
    SHAPE_ELEMENT = "shape"
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
                raise ShapePrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise ShapePrefabXmlReadException(xml_string, e)


class SubShapePrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplemented("Method not implemented yet.")

    def get_type(self):
        raise NotImplemented("Method not implemented yet.")


class SubRectangleShapePrefabXmlReader(SubShapePrefabXmlReader):
    WIDTH_ELEMENT = "width"
    HEIGHT_ELEMENT = "height"

    def __init__(self, position_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )
            return RectangleShapePrefab(
                position_prefab,
                int(element.find(self.WIDTH_ELEMENT).text),
                int(element.find(self.HEIGHT_ELEMENT).text)
            )
        except Exception as e:
            raise ShapePrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "RectangleShape"


class SubCircleShapePrefabXmlReader(SubShapePrefabXmlReader):
    RADIUS_ELEMENT = "radius"

    def __init__(self, position_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )
            return CircleShapePrefab(
                position_prefab,
                int(element.find(self.RADIUS_ELEMENT).text)
            )
        except Exception as e:
            raise ShapePrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "CircleShape"


class SubPolygonShapePrefabXmlReader(SubShapePrefabXmlReader):
    def __init__(self, position_prefab_xml_reader, vertex_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader
        self.vertex_prefab_xml_reader = vertex_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )
            return PolygonShapePrefab(
                position_prefab,
                self.vertex_prefab_xml_reader.read_prefabs_from_string(
                    EXml.tostring(element.find(VertexPrefabXmlReader.VERTICES_ELEMENT))
                )
            )
        except Exception as e:
            raise ShapePrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "PolygonShape"


class SubChainShapePrefabXmlReader(SubShapePrefabXmlReader):
    def __init__(self, position_prefab_xml_reader, vertex_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader
        self.vertex_prefab_xml_reader = vertex_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            if element.find(PositionPrefabXmlReader.POSITION_ELEMENT) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )
            return PolygonShapePrefab(
                position_prefab,
                self.vertex_prefab_xml_reader.read_prefabs_from_string(
                    EXml.tostring(element.find(VertexPrefabXmlReader.VERTICES_ELEMENT))
                )
            )
        except Exception as e:
            raise ShapePrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ChainShape"


class ShapePrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Shape prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))


class ShapePrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read shape prefab from string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
