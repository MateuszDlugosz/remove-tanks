class TextureAtlas(object):
    def __init__(self, image_filename, size, format, filter, repeat, regions):
        self.image_filename = image_filename
        self.size = size
        self.format = format
        self.filter = filter
        self.repeat = repeat
        self.regions = {}
        for region in regions:
            self.regions[region.get_name()] = region

    def get_image_filename(self):
        return self.image_filename

    def get_size(self):
        return self.size

    def get_format(self):
        return self.format

    def get_filter(self):
        return self.filter

    def get_repeat(self):
        return self.repeat

    def get_region(self, name):
        if str(name) not in self.regions:
            raise RegionNotFoundException(name)
        return self.regions[str(name)]

    def __str__(self):
        return "TextureAtlas(image_filename={}, size={}, format={}, filter={}, repeat={}, regions=[{}])" \
            .format(self.image_filename, self.size, self.format, self.filter, self.repeat,
                    ", ".join('{}={}'.format(key, val) for key, val in self.regions.items()))


class RegionNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Region named {} not found."

    def __init__(self, name):
        super().__init__(self.MESSAGE_TEMPLATE.format(name))


class Region(object):
    def __init__(self, name, rotate, position, size, origin, offset, index):
        self.name = str(name)
        self.rotate = bool(rotate)
        self.position = position
        self.size = size
        self.origin = origin
        self.offset = offset
        self.index = int(index)

    def get_name(self):
        return self.name

    def get_rotate(self):
        return self.rotate

    def get_size(self):
        return self.size

    def get_position(self):
        return self.position

    def get_origin(self):
        return self.origin

    def get_offset(self):
        return self.offset

    def get_index(self):
        return self.index

    def __str__(self):
        return "Region(name={}, rotate={}, position={}, size={}, origin={}, offset={}, index={})"\
            .format(self.name, self.rotate, self.position, self.size, self.origin, self.offset, self.index)
