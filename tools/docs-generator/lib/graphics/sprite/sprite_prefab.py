class SpritePrefab(object):
    def __init__(self, flip_x, flip_y):
        self.flip_x = bool(flip_x)
        self.flip_y = bool(flip_y)

    def get_flip_x(self):
        return self.flip_x

    def get_flip_y(self):
        return self.flip_y


class FileSpritePrefab(SpritePrefab):
    def __init__(self, flip_x, flip_y, filename):
        super().__init__(flip_x, flip_y)
        self.filename = str(filename)

    def get_filename(self):
        return self.filename

    def __str__(self):
        return "FileSpritePrefab(flip_x={}, flip_y={}, filename={})" \
                    .format(self.flip_x, self.flip_y, self.filename)


class AtlasSpritePrefab(SpritePrefab):
    def __init__(self, flip_x, flip_y, atlas_filename, region_name):
        super().__init__(flip_x, flip_y)
        self.atlas_filename = str(atlas_filename)
        self.region_name = region_name

    def get_atlas_filename(self):
        return self.atlas_filename

    def get_region_name(self):
        return self.region_name

    def __str__(self):
        return "AtlasSpritePrefab(flip_x={}, flip_y={}, atlas_filename={}, region_name={})" \
                    .format(self.flip_x, self.flip_y, self.atlas_filename, self.region_name)
