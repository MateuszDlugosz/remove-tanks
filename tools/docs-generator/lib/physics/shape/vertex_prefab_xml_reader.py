import xml.etree.ElementTree as EXml

from lib.physics.shape.vertex_prefab import VertexPrefab


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
