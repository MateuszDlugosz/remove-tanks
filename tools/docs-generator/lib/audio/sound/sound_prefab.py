class SoundPrefab(object):
    def __init__(self, filename):
        self.filename = str(filename)

    def get_filename(self):
        return self.filename

    def __str__(self):
        return "SoundPrefab(filename={})".format(self.filename)
