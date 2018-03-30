class ParticleEffectPrefab(object):
    def __init__(self, flip_x, flip_y):
        self.flip_x = bool(flip_x)
        self.flip_y = bool(flip_y)

    def get_flip_x(self):
        return self.flip_x

    def get_flip_y(self):
        return self.flip_y


class FileParticleEffectPrefab(ParticleEffectPrefab):
    def __init__(self, flip_x, flip_y, filename, images_dir):
        super().__init__(flip_x, flip_y)
        self.filename = str(filename)
        self.images_dir = str(images_dir)

    def get_filename(self):
        return self.filename

    def get_images_dir(self):
        return self.images_dir

    def __str__(self):
        return "FileParticleEffectPrefab(flip_x={}, flip_y={}, filename={}, images_dir={})" \
                    .format(self.flip_x, self.flip_y, self.filename, self.images_dir)


class AtlasParticleEffectPrefab(ParticleEffectPrefab):
    def __init__(self, flip_x, flip_y, filename, atlas_filename):
        super().__init__(flip_x, flip_y)
        self.filename = str(filename)
        self.atlas_filename = str(atlas_filename)

    def get_filename(self):
        return self.filename

    def get_atlas_filename(self):
        return self.atlas_filename

    def __str__(self):
        return "AtlasParticleEffectPrefab(flip_x={}, flip_y={}, filename={}, atlas_filename={})" \
                    .format(self.flip_x, self.flip_y, self.filename, self.atlas_filename)
