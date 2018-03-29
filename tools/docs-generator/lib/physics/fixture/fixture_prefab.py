class FixturePrefab(object):
    def __init__(self, filter_prefab, shape_prefab, restitution, density, friction, is_sensor):
        self.filter_prefab = filter_prefab
        self.shape_prefab = shape_prefab
        self.restitution = float(restitution)
        self.density = float(density)
        self.friction = float(friction)
        self.is_sensor = bool(is_sensor)

    def get_filter_prefab(self):
        return self.filter_prefab

    def get_shape_prefab(self):
        return self.shape_prefab

    def get_restitution(self):
        return self.restitution

    def get_density(self):
        return self.density

    def get_friction(self):
        return self.friction

    def get_is_sensor(self):
        return self.is_sensor

    def __str__(self):
        return "FixturePrefab(filter_prefab={}, shape_prefab={}, restitution={}, density={}, friction={}, is_sensor={})"\
            .format(self.filter_prefab, self.shape_prefab, self.restitution, self.density, self.friction, self.is_sensor)
