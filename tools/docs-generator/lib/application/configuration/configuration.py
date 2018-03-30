class Configuration:
    def __init__(self, options):
        self.options = {}
        for key, value in options.items():
            self.options[key] = value

    def get_option(self, name):
        if str(name) in self.options:
            return self.options[str(name)]
        return None
