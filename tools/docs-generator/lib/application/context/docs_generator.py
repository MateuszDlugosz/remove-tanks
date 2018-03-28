import logging


class DocsGenerator:
    def __init__(self, context):
        self.context = context

    def get_context(self):
        return self.context

    def generate_docs(self):
        logging.info("Generating docs started.")
        logging.info(f"Docs will be generated in "
                     f"{self.context.get_configuration().get_option('target.directory')} directory.")
        logging.info(f"Docs will be generated based on "
                     f"{self.context.get_configuration().get_option('source.directory')} assets directory.")

        logging.info("Generation docs ended.")


class DocsGeneratorInitializer(object):
    def __init__(self, context_initializer):
        self.context_initializer = context_initializer

    def initialize_docs_generator(self, configuration, context_components_class):
        try:
            return DocsGenerator(self.context_initializer.initialize_context(configuration, context_components_class))
        except Exception as e:
            raise DocsGeneratorInitializeException(e)


class DocsGeneratorInitializeException(Exception):
    MESSAGE_TEMPLATE = "Cannot initialize docs generator. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
