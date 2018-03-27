class Context(object):
    def __init__(self, components):
        self.components = {}
        for key, value in components.items():
            self.components[key] = value

    def get_component(self, component_name):
        if component_name not in self.components:
            raise ContextComponentNotFoundException(component_name)
        return self.components[component_name]


class ContextComponentNotFoundException(Exception):
    MESSAGE_TEMPLATE = "Context component named {} not found."

    def __init__(self, component_name):
        super().__init__(self.MESSAGE_TEMPLATE.format(component_name))
