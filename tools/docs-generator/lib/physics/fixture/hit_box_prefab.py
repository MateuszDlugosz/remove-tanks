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
