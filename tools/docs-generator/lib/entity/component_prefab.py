import xml.etree.ElementTree as EXml

from lib.utility.surface.position.position_prefab import PositionPrefab, PositionPrefabXmlReader


class ComponentPrefab(object):
    pass


class ComponentPrefabXmlReader(object):
    COMPONENT_ELEMENT = "component"
    COMPONENTS_ELEMENT = "components"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefabs_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefabs = []

            for child in element.findall(self.COMPONENT_ELEMENT):
                prefabs.append(self.read_prefab_from_string(EXml.tostring(child)))

            return prefabs
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            prefab_type = element.get(self.TYPE_ATTRIBUTE)

            if prefab_type not in self.sub_readers:
                raise ComponentPrefabXmlReaderNotFoundException(prefab_type)
            
            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)


class SubComponentPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplementedError("Not implemented yet.")

    def get_type(self):
        raise NotImplementedError("Not implemented yet.")


class ComponentPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read component prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class ComponentPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Component prefab xml reader of type {} not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))


class SpeedComponentPrefab(ComponentPrefab):
    def __init__(self, speed):
        self.speed = float(speed)

    def get_speed(self):
        return self.speed

    def __str__(self):
        return "SpeedComponentPrefab(speed={})".format(self.speed)


class SubSpeedComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    SPEED_ELEMENT = "speed"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            speed = float(element.find(self.SPEED_ELEMENT).text)
            return SpeedComponentPrefab(speed)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "SpeedComponent"


class CameraTrackComponentPrefab(ComponentPrefab):
    def __init__(self, priority, position_prefab):
        self.priority = priority
        self.position_prefab = position_prefab

    def get_priority(self):
        return self.priority

    def get_position_prefab(self):
        return self.position_prefab

    def __str__(self):
        return "CameraTrackComponent(priority={}, position_prefab={})"\
            .format(self.priority, str(self.position_prefab))


class SubCameraTrackComponentPrefabXmlReader(SubComponentPrefabXmlReader):
    PRIORITY_ELEMENT = "priority"

    def __init__(self, position_prefab_xml_reader):
        self.position_prefab_xml_reader = position_prefab_xml_reader

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            position_prefab = PositionPrefab(0, 0)
            priority = float(element.find(self.PRIORITY_ELEMENT).text)

            if (element.find(PositionPrefabXmlReader.POSITION_ELEMENT)) is not None:
                position_prefab = self.position_prefab_xml_reader.read_prefab_from_string(
                    EXml.tostring(element.find(PositionPrefabXmlReader.POSITION_ELEMENT))
                )

            return CameraTrackComponentPrefab(priority, position_prefab)
        except Exception as e:
            raise ComponentPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "CameraTrackComponent"
