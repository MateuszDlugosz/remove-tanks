from lib.utility.string_functions import *


class TextureAtlasReader(object):
    def read_from_file(self, filename):
        try:
            with open(filename) as file:
                content = file.readlines()
                content = [x.strip() for x in content]

            image_filename = content[1]
            size_str = content[2].split(":")
            size = (int(size_str[1].split(",")[0].strip()), int(size_str[1].split(",")[1].strip()))
            format = content[3].split(":")[1].strip()
            filter_str = content[4].split(":")
            filter = (filter_str[1].split(",")[0].strip(), filter_str[1].split(",")[1].strip())
            repeat = content[5].split(":")[1].strip()

            regions = []
            number_of_lines = 0
            lines = []

            for i in range(6, len(content)):
                if number_of_lines is 6:
                    lines.append(content[i])
                    regions.append(self.read_region(lines))
                    lines = []
                    number_of_lines = 0
                else:
                    number_of_lines += 1
                    lines.append(content[i])

            return TextureAtlas(image_filename, size, format, filter, repeat, regions)
        except Exception as e:
            raise TextureAtlasReadException(filename, e)

    def read_region(self, lines):
        try:
            name = lines[0].strip()
            rotate = string_to_boolean(lines[1].split(":")[1].strip())
            position_str = lines[2].split(":")[1].strip()
            position = (int(position_str.split(",")[0].strip()), int(position_str.split(",")[1].strip()))
            size_str = lines[3].split(":")[1].strip()
            size = (int(size_str.split(",")[0].strip()), int(size_str.split(",")[1].strip()))
            origin_str = lines[4].split(":")[1].strip()
            origin = (int(origin_str.split(",")[0].strip()), int(origin_str.split(",")[1].strip()))
            offset_str = lines[5].split(":")[1].strip()
            offset = (int(offset_str.split(",")[0].strip()), int(offset_str.split(",")[1].strip()))
            index = int(lines[6].split(":")[1].strip())

            return Region(name, rotate, position, size, origin, offset, index)
        except Exception as e:
            raise RegionReadException(e)


class TextureAtlasReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read texture atlas from file {}. Cause: {}."

    def __init__(self, filename, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(filename, cause))


class RegionReadException(Exception):
    MESSAGE_TEMPLATE = "Cannot read reagion. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))


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
