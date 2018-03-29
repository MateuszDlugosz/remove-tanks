class LightHandlerPrefab(object):
    def __init__(self, prefab_id, light_prefab):
        self.id = prefab_id
        self.light_prefab = light_prefab

    def get_id(self):
        return self.id

    def get_light_prefab(self):
        return self.light_prefab

    def __str__(self):
        return "LightHandlerPrefab(id={}, light_prefab={})"\
            .format(self.id, self.light_prefab)
