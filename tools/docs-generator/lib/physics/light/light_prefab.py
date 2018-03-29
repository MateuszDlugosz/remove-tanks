class LightPrefab(object):
    def __init__(self, color_prefab, x_ray):
        self.color_prefab = color_prefab
        self.x_ray = bool(x_ray)

    def get_color_prefab(self):
        return self.color_prefab

    def get_x_ray(self):
        return self.x_ray


class PointLightPrefab(LightPrefab):
    def __init__(self, color_prefab, x_ray, position_prefab, distance):
        super().__init__(color_prefab, x_ray)
        self.position_prefab = position_prefab
        self.distance = float(distance)

    def get_position_prefab(self):
        return self.position_prefab

    def get_distance(self):
        return self.distance

    def __str__(self):
        return "PointLightPrefab(color_prefab={}, x_ray={}, position_prefab={}, distance={})"\
            .format(self.color_prefab, self.x_ray, self.position_prefab, self.distance)


class DirectionalLightPrefab(LightPrefab):
    def __init__(self, color_prefab, x_ray, direction_degree):
        super().__init__(color_prefab, x_ray)
        self.direction_degree = float(direction_degree)

    def get_direction_degree(self):
        return self.direction_degree

    def __str__(self):
        return "DirectionalLightPrefab(color_prefab={}, x_ray={}, direction_degree={})"\
            .format(self.color_prefab, self.x_ray, self.direction_degree)


class ConeLightPrefab(LightPrefab):
    def __init__(self, color_prefab, x_ray, position_prefab, distance, direction_degree, cone_degree):
        super().__init__(color_prefab, x_ray)
        self.position_prefab = position_prefab
        self.distance = float(distance)
        self.direction_degree = float(direction_degree)
        self.cone_degree = float(cone_degree)

    def get_position_prefab(self):
        return self.position_prefab

    def get_distance(self):
        return self.distance

    def get_direction_degree(self):
        return self.direction_degree

    def get_cone_degree(self):
        return self.cone_degree

    def __str__(self):
        return "ConeLightPrefab(color_prefab={}, x_ray={}, position_prefab={}, distance={}, direction_degree={}, " \
               "cone_degree={})" \
                    .format(self.color_prefab, self.x_ray, self.position_prefab, self.distance,self.direction_degree,
                            self.cone_degree)
