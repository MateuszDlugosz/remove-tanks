class CameraEffectPrefab(object):
    def __str__(self):
        raise NotImplemented("Not implemented yet.")


class ShakeCameraEffectPrefab(CameraEffectPrefab):
    def __init__(self, time, power):
        self.time = float(time)
        self.power = float(power)

    def get_time(self):
        return self.time

    def get_power(self):
        return self.power

    def __str__(self):
        return "ShakeCameraEffectPrefab(time={}, power={})".format(self.time, self.power)
