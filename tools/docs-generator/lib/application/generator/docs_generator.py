import logging
import os
import pathlib
import shutil


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
            self.generate_entity_prefabs_pages()
        except Exception as e:
            raise DocsGenerationException(e)

        logging.info("Generation files ended.")

    def generate_entity_prefabs_pages(self):
        logging.info("Generating entity prefabs pages started.")
        storage = self.context.get_component("EntityPrefabStorage")
        repository = self.context.get_component("EntityPrefabRepository")
        configuration = self.context.get_configuration()
        source_filename = "{}/{}".format(
            self.context.get_configuration().get_option("files.layouts.directory"),
            self.context.get_configuration().get_option("files.layouts.main.filename")
        )

        for code in repository.get_all_prefabs():
            target_filename = f'{configuration.get_option("target.directory")}/{repository.get_prefab(code)}'\
                .replace(".xml", ".html")
            logging.info(f"Generating entity prefab page {target_filename}.")
            pathlib.Path(os.path.dirname(target_filename)).mkdir(parents=True, exist_ok=True)
            shutil.copy(source_filename, target_filename)

        logging.info("Generating entity prefabs pages ended.")

    def replace_include_tag(self, filename, includes_id, replace_with):
        include_element = f'<include id="{includes_id}" />'
        includes_filename = '{}/{}'.format(
            self.context.get_configuration().get_option("files.includes.directory"),
            self.context.get_configuration().get_option(f"files.includes.{replace_with}.filename")
        )

        with open(filename) as file:
            contents_to_replace = file.read()

        with open(includes_filename) as include:
            contents_to_include = include.read()
            replaced_contents = contents_to_replace.replace(include_element, contents_to_include)

        with open(filename, "w") as file:
            file.write(replaced_contents)


class DocsGeneratorInitializer(object):
    def __init__(self, context_initializer):
        self.context_initializer = context_initializer

    def initialize_docs_generator(self, configuration, context_components_class):
        try:
            return DocsGenerator(self.context_initializer.initialize_context(configuration, context_components_class))
        except Exception as e:
            raise DocsGeneratorInitializeException(e)


class DocsGeneratorInitializeException(Exception):
    MESSAGE_TEMPLATE = "Cannot initialize files generator. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))


class DocsGenerationException(Exception):
    MESSAGE_TEMPLATE = "Cannot generate files. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
