import logging
import os
from shutil import copyfile


class DocsGenerator:
    def __init__(self, context):
        self.context = context

    def get_context(self):
        return self.context

    def generate_docs(self):
        logging.info("Generating files started.")
        logging.info(f"Docs will be generated in "
                     f"{self.context.get_configuration().get_option('target.directory')} directory.")
        logging.info(f"Docs will be generated based on "
                     f"{self.context.get_configuration().get_option('source.directory')} assets directory.")

        try:
            self.initialize_files()
            self.initialize_texture_atlases()
            self.generate_entity_prefabs_pages(self.initialize_entity_codes_filenames_dictionary())
        except Exception as e:
            raise DocsGenerationException(e)

        logging.info("Generation files ended.")

    def initialize_files(self):
        logging.info("Copy required files started.")

        for file_to_copy in self.context.get_configuration().get_option("target.directory.files").split(';'):
            source = file_to_copy.split(',')[0].strip()
            target = file_to_copy.split(',')[1].strip()

            logging.info(f"Copy file from {source} to {target}.")

            os.makedirs(os.path.dirname(target), exist_ok=True)
            copyfile(source, target)

        logging.info("Copy required files ended.")

    def initialize_texture_atlases(self):
        configuration = self.context.get_configuration()
        unpacker = self.context.get_component("TextureAtlasUnpacker")

        for texture_atlas in self.context.get_configuration().get_option("texture.atlases").strip().split(';'):
            target_directory = configuration.get_option("target.directory") + "/" +\
                                      configuration.get_option("target.directory.root") + "/" + \
                                      configuration.get_option("target.directory.images.root") + "/" + \
                                      texture_atlas.split(":")[0].strip()

            pack_filename = texture_atlas.split(":")[1].split(",")[0].strip()
            image_filename = texture_atlas.split(":")[1].split(",")[1].strip()
            os.makedirs(target_directory, exist_ok=True)
            unpacker.unpack_to_directory(target_directory, pack_filename, image_filename)

    def initialize_entity_codes_filenames_dictionary(self):
        logging.info("Generating entity prefabs => filename dict started.")
        repository = self.context.get_component("EntityPrefabRepository")
        configuration = self.context.get_configuration()
        codes_filenames = {}

        for code in repository.get_all_prefabs():
            filename = repository.get_prefab(code) \
                .replace(configuration.get_option("entity.prefab.filename.start"), "") \
                .replace("/", "-") \
                .replace(".xml", ".html")
            codes_filenames[code] = filename

        logging.info("Generating entity prefabs => filename dict ended.")

        return codes_filenames

    def generate_entity_prefabs_pages(self, codes_filenames):
        logging.info("Generating entity prefabs pages started.")
        storage = self.context.get_component("EntityPrefabStorage")
        repository = self.context.get_component("EntityPrefabRepository")
        entity_html_generator = self.context.get_component("EntityPrefabHtmlGenerator")
        configuration = self.context.get_configuration()
        menu_entity_prefabs_html_generator = self.context.get_component("MenuEntityPrefabsHtmlGenerator")
        page_generator = self.context.get_component("PageHtmlGenerator")

        for code in repository.get_all_prefabs():
            filename = repository.get_prefab(code)\
                                  .replace(configuration.get_option("entity.prefab.filename.start"), "")\
                                  .replace("/", "-")\
                                  .replace(".xml", ".html")
            target_filename = configuration.get_option("target.directory") + "/" +\
                              configuration.get_option("target.directory.root") + "/" + \
                              filename
            logging.info(f"Generating entity prefab page {target_filename}.")

            page_generator.generate_html(
                menu_entity_prefabs_html_generator.generate_html(codes_filenames),
                entity_html_generator.generate_html(storage.get_entity_prefab(code), code),
                target_filename
            )

        logging.info("Generating entity prefabs pages ended.")


class DocsGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate files. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
