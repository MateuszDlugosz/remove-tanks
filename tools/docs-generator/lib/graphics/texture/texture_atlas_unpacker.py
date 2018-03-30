from PIL import Image


class TextureAtlasUnpacker(object):
    def __init__(self, texture_atlas_reader):
        self.texture_atlas_reader = texture_atlas_reader

    def unpack_to_directory(self, target_directory, texture_atlas_filename, image_filename):
        try:
            image = Image.open(image_filename)
            texture_atlas = self.texture_atlas_reader.read_from_file(texture_atlas_filename)

            for region_name, region in texture_atlas.get_regions().items():
                region_image = image.crop((region.get_position()[0], region.get_position()[1],
                                           region.get_position()[0] + region.get_size()[0],
                                           region.get_position()[1] + region.get_size()[1]))
                region_image.save(f"{target_directory}/{region_name}.png")
        except Exception as e:
            raise TextureAtlasUnpackingException(target_directory, e)


class TextureAtlasUnpackingException(Exception):
    MESSAGE_TEMPLATE = "Cannot unpack texture atlas to directory {}. Cause: {}."

    def __init__(self, directory, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(directory, cause))
