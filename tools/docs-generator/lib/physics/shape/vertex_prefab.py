class VertexPrefab(object):
    def __init__(self, x, y):
        self.x = float(x)
        self.y = float(y)

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def __str__(self):
        return "VertexPrefab(x={}, y={})".format(self.x, self.y)
