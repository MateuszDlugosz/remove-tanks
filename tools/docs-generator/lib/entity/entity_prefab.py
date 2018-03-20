class EntityPrefab(object):
    def __init__(self, component_prefabs):
        self.component_prefabs = {}
        for component_prefab in component_prefabs:
            self.component_prefabs[component_prefab.__class__.__name__] = component_prefab

    def set_component(self, type, component_prefab):
        self.component_prefabs[str(type)] = component_prefab

    def get_component(self, type):
        if str(type) in self.component_prefabs:
            return self.component_prefabs[str(type)]
        return None

    def get_all_components(self):
        return self.component_prefabs
