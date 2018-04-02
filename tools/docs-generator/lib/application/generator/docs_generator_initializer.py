from lib.application.generator.docs_generator import DocsGenerator


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
