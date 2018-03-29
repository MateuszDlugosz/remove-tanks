class Properties(object):
    def __init__(self):
        self.properties = {}

    def set_property(self, name, value):
        self.properties[str(name)] = str(value)

    def get_property(self, name):
        if str(name) in self.properties:
            return self.properties[str(name)]
        return None

    def get_properties(self):
        return self.properties

    def __str__(self):
        return "Properties(properties={})".format(self.properties)
