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
            self.copy_files()
            self.unpack_texture_atlases()
            self.generate_entity_prefabs_pages()
        except Exception as e:
            raise DocsGenerationException(e)

        logging.info("Generation files ended.")

    def copy_files(self):
        logging.info("Copy required files started.")

        for file_to_copy in self.context.get_configuration().get_option("target.directory.files").split(';'):
            source = file_to_copy.split(',')[0].strip()
            target = file_to_copy.split(',')[1].strip()
            logging.info(f"Copy file from {source} to {target}.")
            os.makedirs(os.path.dirname(target), exist_ok=True)
            copyfile(source, target)

        logging.info("Copy required files ended.")

    def unpack_texture_atlases(self):
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


    def generate_entity_prefabs_pages(self):
        logging.info("Generating entity prefabs pages started.")
        storage = self.context.get_component("EntityPrefabStorage")
        repository = self.context.get_component("EntityPrefabRepository")
        entity_html_generator = self.context.get_component("EntityPrefabHtmlGenerator")
        configuration = self.context.get_configuration()

        for code in repository.get_all_prefabs():
            target_filename = configuration.get_option("target.directory") + "/" +\
                              configuration.get_option("target.directory.root") + "/" + \
                              repository.get_prefab(code)\
                                  .replace(configuration.get_option("entity.prefab.filename.start"), "")\
                                  .replace("/", "-")\
                                  .replace(".xml", ".html")
            logging.info(f"Generating entity prefab page {target_filename}.")

            self.generate_html_page(
                entity_html_generator.generate_html(storage.get_entity_prefab(code), code),
                target_filename
            )

        logging.info("Generating entity prefabs pages ended.")

    def generate_html_page(self, html_content, filename):
        footer_html_generator = self.context.get_component("FooterHtmlGenerator")
        menu_html_generator = self.context.get_component("MenuHtmlGenerator")
        header_html_generator = self.context.get_component("HeaderHtmlGenerator")
        html_layout_generator = self.context.get_component("LayoutHtmlGenerator")
        html_generator = self.context.get_component("HtmlGenerator")

        html_string = html_generator.generate_html(html_layout_generator.generate_html(
            header_html_generator.generate_html(),
            menu_html_generator.generate_html(),
            html_content,
            footer_html_generator.generate_html()
        ))

        os.makedirs(os.path.dirname(filename), exist_ok=True)
        with open(filename, "w+") as file:
            file.write(html_string)


class DocsGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate files. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
