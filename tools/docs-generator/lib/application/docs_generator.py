import logging
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
            self.generate_homepage()
        except Exception as e:
            raise DocsGenerationException(e)

        logging.info("Generation files ended.")

    def generate_homepage(self):
        logging.info("Generating homepage started.")
        shutil.copy(
            self.context.get_configuration().get_option("page.layout.filename"),
            "{}/{}".format(
                self.context.get_configuration().get_option("target.directory"),
                self.context.get_configuration().get_option("generated.page.homepage.filename")
            )
        )
        logging.info("Generating homepage ended.")


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
