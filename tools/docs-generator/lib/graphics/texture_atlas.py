class TextureAtlasReader(object):
    ATLAS_PROPERTY_VALUES = ["size", "format", "filter", "repeat"]
    REGION_PROPERTY_VALUES = []

    def read_from_file(self, filename):
        try:
            regions = []
            properties = []
            with open(filename) as file:
                pass
        except Exception as e:
            raise TextureAtlasReadException(filename, e)


class TextureAtlasReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read texture atlas from file {}. Cause: {}."

    def __init__(self, filename, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(filename, cause))


class TextureAtlas(object):
    def __init__(self, properties, regions):
        self.properties = {}
        self.regions = {}
        for a_property in properties:
            self.properties[a_property] = properties[a_property]
        for region in regions:
            self.regions[region.get_name()] = region

    def get_region(self, name):
        if str(name) not in self.regions:
            raise RegionNotFoundException(name)
        return self.regions[str(name)]

    def __str__(self):
        return "TextureAtlas(properties={}, regions={})".format(self.properties, self.regions)


class RegionNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Region named {} not found."

    def __init__(self, name):
        super().__init__(self.MESSAGE_TEMPLATE.format(name))


class Region(object):
    def __init__(self, name, rotate, x, y, width, height, origin_x, origin_y, offset_x, offset_y, index):
        self.name = str(name)
        self.rotate = bool(rotate)
        self.x = int(x)
        self.y = int(y)
        self.width = int(width)
        self.height = int(height)
        self.origin_x = int(origin_x)
        self.origin_y = int(origin_y)
        self.offset_x = int(offset_x)
        self.offset_y = int(offset_y)
        self.index = int(index)

    def get_name(self):
        return self.name

    def get_rotate(self):
        return self.rotate

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def get_origin_x(self):
        return self.origin_x

    def get_origin_y(self):
        return self.origin_y

    def get_offset_x(self):
        return self.offset_x

    def get_offset_y(self):
        return self.offset_y

    def get_index(self):
        return self.index

    def __str__(self):
        return "Region(name={})".format(self.name)

