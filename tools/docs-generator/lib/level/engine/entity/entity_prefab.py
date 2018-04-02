class EntityPrefab(object):
    def __init__(self, preload_data, component_prefabs):
        self.preload_data = preload_data
        self.component_prefabs = {}
        for component_prefab in component_prefabs:
            self.component_prefabs[component_prefab.__class__.__name__] = component_prefab

    def get_preload_data(self):
        return self.preload_data

    def get_component(self, type):
        if str(type) in self.component_prefabs:
            return self.component_prefabs[str(type)]
        return None

    def get_all_components(self):
        return self.component_prefabs

    def __str__(self):
        return "EntityPrefab(preload_data={}, component_prefabs=[{}])" \
            .format(
                str(self.preload_data),
                ", ".join('{}={}'.format(key, val) for key, val in self.component_prefabs.items())
            )
