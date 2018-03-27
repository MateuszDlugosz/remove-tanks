import xml.etree.ElementTree as EXml


class MessagePrefab(object):
    def __init__(self, time, translation_entry_key, face_id):
        self.time = float(time)
        self.translation_entry_key = str(translation_entry_key)
        self.face_id = str(face_id)

    def get_time(self):
        return self.time

    def get_translation_entry_key(self):
        return self.translation_entry_key

    def get_face_id(self):
        return self.face_id

    def __str__(self):
        return "MessagePrefab(time={}, translation_entry_key={}, face_id={})" \
            .format(self.time, self.translation_entry_key, self.face_id)


class MessagePrefabXmlReader(object):
    MESSAGE_ELEMENT = "message"
    TIME_ELEMENT = "time"
    TRANSLATION_ENTRY_KEY_ELEMENT = "entryKey"
    FACE_ID_ELEMENT = "faceId"

    def read_prefab_from_string(self, xml_string):
        try:
            element = EXml.fromstring(xml_string)
            time = float(element.find(self.TIME_ELEMENT).text.strip())
            translation_entry_key = str(element.find(self.TRANSLATION_ENTRY_KEY_ELEMENT).text.strip())
            face_id = str(element.find(self.FACE_ID_ELEMENT).text.strip())

            return MessagePrefab(time, translation_entry_key, face_id)
        except Exception as e:
            raise MessagePrefabXmlReadException(xml_string, e)


class MessagePrefabXmlReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read message prefab from xml string {}. Cause: {}."

    def __init__(self, xml_string, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(xml_string, cause))
