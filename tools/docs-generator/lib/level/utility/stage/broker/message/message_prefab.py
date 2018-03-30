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
