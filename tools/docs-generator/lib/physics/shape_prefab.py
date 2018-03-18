import xml.etree.ElementTree as EXml

from lib.utility.surface.position.position_prefab import PositionPrefabXmlReader, PositionPrefab


class ShapePrefab(object):
    def __init__(self, position_prefab):
        self.position_prefab = position_prefab

    def get_position_prefab(self):
        return self.position_prefab


class RectangleShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, width, height):
        super().__init__(position_prefab)
        self.width = width
        self.height = height

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def __str__(self):
        return "RectangleShapePrefab(position_prefab={}, width={}, height={})"\
            .format(self.position_prefab, self.width, self.height)


class CircleShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, radius):
        super().__init__(position_prefab)
        self.radius = radius

    def get_radius(self):
        return self.radius

    def __str__(self):
        return "CircleShapePrefab(position_prefab={}, radius={})"\
            .format(self.position_prefab, self.radius)


class PolygonShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, vertices):
        super().__init__(position_prefab)
        self.vertices = vertices

    def get_vertices(self):
        return self.vertices

    def __str__(self):
        return "PolygonShapePrefab(position_prefab={}, vertices=[{}])"\
            .format(self.position_prefab, ", ".join(str(e) for e in self.vertices))


class ChainShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, vertices):
        super().__init__(position_prefab)
        self.vertices = vertices

    def get_vertices(self):
        return self.vertices

    def __str__(self):
        return "ChainShapePrefab(position_prefab={}, vertices=[{}])" \
            .format(self.position_prefab, ", ".join(str(e) for e in self.vertices))


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


class ShapePrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Shape prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))


class ShapePrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read shape prefab from string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


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


class VertexPrefab(object):
    def __init__(self, x, y):
        self.x = float(x)
        self.y = float(y)

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def __str__(self):
        return "VertexPrefab(x={}, y={})".format(self.x, self.y)


class VertexPrefabXmlReader(object):
    VERTICES_ELEMENT = "vertices"
    VERTEX_ELEMENT = "vertex"
    X_ATTRIBUTE = "x"
    Y_ATTRIBUTE = "y"

    def read_prefabs_from_string(self, xml_string):
        vertices = []
        element = EXml.fromstring(xml_string)
        for vertex in element.findall(self.VERTEX_ELEMENT):
            vertices.append(
                self.read_prefab_from_string(EXml.tostring(vertex))
            )
        return vertices

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return VertexPrefab(
                float(element.get(self.X_ATTRIBUTE)),
                float(element.get(self.Y_ATTRIBUTE))
            )
        except Exception as e:
            raise VertexPrefabXmlReadException(xml_string, e)


class VertexPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read vertex prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
