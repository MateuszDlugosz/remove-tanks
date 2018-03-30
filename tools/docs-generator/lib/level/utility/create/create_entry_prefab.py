class CreateEntryPrefab(object):
    def __init__(self, prefab_code, position_prefab):
        self.prefab_code = str(prefab_code)
        self.position_prefab = position_prefab

    def get_prefab_code(self):
        return self.prefab_code

    def get_position_prefab(self):
        return self.position_prefab

    def __str__(self):
        return "CreateEntryPrefab(prefab_code={}, position_prefab={})" \
            .format(self.prefab_code, str(self.position_prefab))
