class ShapePrefab(object):
    def __init__(self, position_prefab):
        self.position_prefab = position_prefab

    def get_position_prefab(self):
        return self.position_prefab


class RectangleShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, width, height):
        super().__init__(position_prefab)
        self.width = float(width)
        self.height = float(height)

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def __str__(self):
        return "RectangleShapePrefab(position_prefab={}, width={}, height={})"\
            .format(self.position_prefab, self.width, self.height)


class CircleShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, radius):
        super().__init__(position_prefab)
        self.radius = float(radius)

    def get_radius(self):
        return self.radius

    def __str__(self):
        return "CircleShapePrefab(position_prefab={}, radius={})"\
            .format(self.position_prefab, self.radius)


class PolygonShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, vertices):
        super().__init__(position_prefab)
        self.vertices = vertices

    def get_vertices(self):
        return self.vertices

    def __str__(self):
        return "PolygonShapePrefab(position_prefab={}, vertices=[{}])"\
            .format(self.position_prefab, ", ".join(str(e) for e in self.vertices))


class ChainShapePrefab(ShapePrefab):
    def __init__(self, position_prefab, vertices):
        super().__init__(position_prefab)
        self.vertices = vertices

    def get_vertices(self):
        return self.vertices

    def __str__(self):
        return "ChainShapePrefab(position_prefab={}, vertices=[{}])" \
            .format(self.position_prefab, ", ".join(str(e) for e in self.vertices))
