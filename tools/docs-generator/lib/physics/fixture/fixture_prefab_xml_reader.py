import xml.etree.ElementTree as EXml

from lib.physics.filter.filter_prefab_xml_reader import FilterPrefabXmlReader
from lib.physics.fixture.fixture_prefab import FixturePrefab
from lib.physics.shape.shape_prefab_xml_reader import ShapePrefabXmlReader


class FixturePrefabXmlReader(object):
    FIXTURE_ELEMENT = "fixture"
    RESTITUTION_ELEMENT = "restitution"
    DENSITY_ELEMENT = "density"
    FRICTION_ELEMENT = "friction"
    ID_ATTRIBUTE = "id"

    DEFAULT_DENSITY = 0.0
    DEFAULT_FRICTION = 0.0
    DEFAULT_RESTITUTION = 0.0

    def __init__(self, filter_prefab_xml_reader, shape_prefab_xml_reader):
        self.filter_prefab_xml_reader = filter_prefab_xml_reader
        self.shape_prefab_xml_reader = shape_prefab_xml_reader

    def read_prefab_from_string(self, xml_string, is_sensor):
        try:
            element = EXml.fromstring(xml_string)
            filter_prefab = self.filter_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(FilterPrefabXmlReader.FILTER_ELEMENT))
            )
            shape_prefab = self.shape_prefab_xml_reader.read_prefab_from_string(
                EXml.tostring(element.find(ShapePrefabXmlReader.SHAPE_ELEMENT))
            )

            restitution = self.DEFAULT_RESTITUTION
            density = self.DEFAULT_DENSITY
            friction = self.DEFAULT_FRICTION

            if element.find(self.RESTITUTION_ELEMENT) is not None:
                restitution = float(element.find(self.RESTITUTION_ELEMENT).text.strip())

            if element.find(self.DENSITY_ELEMENT) is not None:
                density = float(element.find(self.DENSITY_ELEMENT).text.strip())

            if element.find(self.FRICTION_ELEMENT) is not None:
                friction = float(element.find(self.FRICTION_ELEMENT).text.strip())

            return FixturePrefab(filter_prefab, shape_prefab, restitution, density, friction, is_sensor)
        except Exception as e:
            raise FixturePrefabXmlReadException(xml_string, e)


class FixturePrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read fixture prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
