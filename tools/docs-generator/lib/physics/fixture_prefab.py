import xml.etree.ElementTree as EXml

from lib.physics.filter_prefab import FilterPrefabXmlReader
from lib.physics.shape_prefab import ShapePrefabXmlReader


class FixturePrefab(object):
    def __init__(self, filter_prefab, shape_prefab, restitution, density, friction, is_sensor):
        self.filter_prefab = filter_prefab
        self.shape_prefab = shape_prefab
        self.restitution = float(restitution)
        self.density = float(density)
        self.friction = float(friction)
        self.is_sensor = bool(is_sensor)

    def get_filter_prefab(self):
        return self.filter_prefab

    def get_shape_prefab(self):
        return self.shape_prefab

    def get_restitution(self):
        return self.restitution

    def get_density(self):
        return self.density

    def get_friction(self):
        return self.friction

    def get_is_sensor(self):
        return self.is_sensor

    def __str__(self):
        return "FixturePrefab(filter_prefab={}, shape_prefab={}, restitution={}, density={}, friction={}, is_sensor={})"\
            .format(self.filter_prefab, self.shape_prefab, self.restitution, self.density, self.friction, self.is_sensor)


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


class HitBoxPrefab(object):
    def __init__(self, prefab_id, fixture_prefab):
        self.id = prefab_id
        self.fixture_prefab = fixture_prefab

    def get_id(self):
        return self.id

    def get_fixture_prefab(self):
        return self.fixture_prefab

    def __str__(self):
        return "HitBoxPrefab(id={}, fixture_prefab={})".format(self.id, self.fixture_prefab)


class HitBoxPrefabXmlReader(object):
    HIT_BOX_ELEMENT = "hitBox"
    HIT_BOXES_ELEMENT = "hitBoxes"
    ID_ATTRIBUTE = "id"

    def __init__(self, fixture_prefab_xml_reader):
        self.fixture_prefab_xml_reader = fixture_prefab_xml_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            prefabs = []
            element = EXml.fromstring(xml_string)
            for child in element.findall(self.HIT_BOX_ELEMENT):
                prefabs.append(
                    self.read_prefab_from_string(EXml.tostring(child))
                )
            return prefabs
        except Exception as e:
            raise HitBoxPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return HitBoxPrefab(
                element.get(self.ID_ATTRIBUTE).strip(),
                self.fixture_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(FixturePrefabXmlReader.FIXTURE_ELEMENT)),
                    False
                )
            )
        except Exception as e:
            raise HitBoxPrefabXmlReadException(xml_string, e)


class HitBoxPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read hit box prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class SensorPrefab(object):
    def __init__(self, prefab_id, fixture_prefab):
        self.id = prefab_id
        self.fixture_prefab = fixture_prefab

    def get_id(self):
        return self.id

    def get_fixture_prefab(self):
        return self.fixture_prefab

    def __str__(self):
        return "SensorPrefab(id={}, fixture_prefab={})"\
            .format(self.id, self.fixture_prefab)


class SensorPrefabXmlReader(object):
    SENSOR_ELEMENT = "sensor"
    SENSORS_ELEMENT = "sensors"
    ID_ATTRIBUTE = "id"

    def __init__(self, fixture_prefab_xml_reader):
        self.fixture_prefab_xml_reader = fixture_prefab_xml_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            prefabs = []
            element = EXml.fromstring(xml_string)
            for child in element.findall(self.SENSOR_ELEMENT):
                prefabs.append(
                    self.read_prefab_from_string(EXml.tostring(child))
                )
            return prefabs
        except Exception as e:
            raise SensorPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            return SensorPrefab(
                element.get(self.ID_ATTRIBUTE).strip(),
                self.fixture_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(FixturePrefabXmlReader.FIXTURE_ELEMENT)),
                    True
                )
            )
        except Exception as e:
            raise SensorPrefabXmlReadException(xml_string, e)


class SensorPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read sensor prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
