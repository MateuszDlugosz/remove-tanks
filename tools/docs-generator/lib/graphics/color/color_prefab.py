class ColorPrefab(object):
    pass


class RgbColorPrefab(ColorPrefab):
    def __init__(self, r, g, b):
        self.r = float(r)
        self.g = float(g)
        self.b = float(b)

    def get_r(self):
        return self.r

    def get_g(self):
        return self.g

    def get_b(self):
        return self.b

    def __str__(self):
        return "RgbColorPrefab(r={}, g={}, b={})".format(self.r, self.g, self.b)


class RgbaColorPrefab(ColorPrefab):
    def __init__(self, r, g, b, a):
        self.r = float(r)
        self.g = float(g)
        self.b = float(b)
        self.a = float(a)

    def get_r(self):
        return self.r

    def get_g(self):
        return self.g

    def get_b(self):
        return self.b

    def get_a(self):
        return self.a

    def __str__(self):
        return "RgbaColorPrefab(r={}, g={}, b={}, a={})".format(self.r, self.g, self.b, self.a)


class HexColorPrefab(ColorPrefab):
    def __init__(self, hex_value):
        self.hex_value = str(hex_value)

    def get_hex_value(self):
        return self.hex_value

    def __str__(self):
        return "HexColorPrefab(hex_value={})".format(self.hex_value)
