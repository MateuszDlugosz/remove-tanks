import xml.etree.ElementTree as EXml

from lib.graphics.camera.camera_effect_prefab import ShakeCameraEffectPrefab


class CameraEffectPrefabXmlReader(object):
    CAMERA_EFFECT_ELEMENT = "cameraEffect"
    TYPE_ATTRIBUTE = "type"

    def __init__(self, sub_readers):
        self.sub_readers = {}
        for sub_reader in sub_readers:
            self.sub_readers[sub_reader.get_type()] = sub_reader

    def read_prefab_from_string(self, xml_string):
        try:
            prefab_type = EXml.fromstring(xml_string).get(self.TYPE_ATTRIBUTE).strip()

            if prefab_type not in self.sub_readers:
                raise CameraEffectPrefabXmlReaderNotFoundException(prefab_type)

            return self.sub_readers[prefab_type].read_prefab_from_string(xml_string)
        except Exception as e:
            raise CameraEffectPrefabXmlReadException(xml_string, e)


class SubCameraEffectPrefabXmlReader(object):
    def read_prefab_from_string(self, xml_string):
        raise NotImplemented("Not implemented yet.")

    def get_type(self):
        raise NotImplemented("Not implemented yet.")


class SubShakeCameraEffectPrefabXmlReader(SubCameraEffectPrefabXmlReader):
    TIME_ELEMENT = "time"
    POWER_ELEMENT = "power"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            time = float(element.find(self.TIME_ELEMENT).text.strip())
            power = float(element.find(self.POWER_ELEMENT).text.strip())

            return ShakeCameraEffectPrefab(time, power)
        except Exception as e:
            raise CameraEffectPrefabXmlReadException(xml_string, e)

    def get_type(self):
        return "ShakeCameraEffect"


class CameraEffectPrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read camera effect prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))


class CameraEffectPrefabXmlReaderNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Camera effect prefab xml reader of {} type not found."

    def __init__(self, prefab_type):
        super().__init__(self.MESSAGE_TEMPLATE.format(prefab_type))
