import logging


class Context(object):
    def __init__(self, configuration, components):
        self.configuration = configuration
        self.components = {}
        for key, value in components.items():
            self.components[key] = value

    def get_configuration(self):
        return self.configuration

    def get_component(self, component_name):
        if component_name not in self.components:
            raise ContextComponentNotFoundException(component_name)
        return self.components[component_name]


class ContextComponentNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Context component named {} not found."

    def __init__(self, component_name):
        super().__init__(self.MESSAGE_TEMPLATE.format(component_name))


class ContextInitializer(object):
    def initialize_context(self, configuration, context_components_class):
        try:
            logging.info("Context initialization started.")
            logging.info(f"Initializing components from class {context_components_class}.")

            logger = logging.getLogger(__name__)
            components = {}
            for method in self.get_init_methods(context_components_class):
                component = getattr(context_components_class, method)(components, configuration)
                components[component[0]] = component[1]
                logger.info(f"Initializing component {component[0]} from method {method}.")

            logging.info("Context initialization ended.")

            return Context(configuration, components)
        except Exception as e:
            raise ContextInitializationException(e)

    def get_init_methods(self, context_components_class):
        methods = context_components_class.__dict__
        init_methods = []
        for key, value in methods.items():
            if key.startswith("init_"):
                init_methods.append(key)
        return init_methods


class ContextInitializationException(Exception):
    MESSAGE_TEMPLATE = "Cannot initialize context. Cause: {}."

    def __init__(self, cause):
        super().__init__(self.MESSAGE_TEMPLATE.format(cause))
