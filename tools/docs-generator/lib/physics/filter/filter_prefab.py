class FilterPrefab(object):
    def __init__(self, category_bit, mask_bit):
        self.category_bit = str(category_bit)
        self.mask_bit = str(mask_bit)

    def get_category_bit(self):
        return self.category_bit

    def get_mask_bit(self):
        return self.mask_bit

    def __str__(self):
        return "FilterPrefab(category_bit={}, mask_bit={})" \
            .format(self.category_bit, self.mask_bit)
