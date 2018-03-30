class PreloadData(object):
    def __init__(self, entity_prefab_codes=None, asset_ids=None):
        if asset_ids is None:
            asset_ids = []
        if entity_prefab_codes is None:
            entity_prefab_codes = []

        self.entity_prefab_codes = entity_prefab_codes
        self.asset_ids = asset_ids

    def get_entity_prefab_codes(self):
        return self.entity_prefab_codes

    def get_asset_ids(self):
        return self.asset_ids

    def __str__(self):
        return "PreloadData(entity_prefab_codes=[{}], asset_ids=[{}])" \
            .format(
                ", ".join('\'{}\''.format(val) for val in self.entity_prefab_codes),
                ", ".join('\'{}\''.format(val) for val in self.asset_ids)
            )
