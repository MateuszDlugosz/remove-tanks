class WeatherEffectPrefab(object):
    pass


class LightningWeatherEffectPrefab(WeatherEffectPrefab):
    def __init__(self, sound_prefab, color_prefab, sound_channel_name,
                 min_frequency, max_frequency, min_duration, max_duration):
        self.sound_prefab = sound_prefab
        self.color_prefab = color_prefab
        self.sound_channel_name = sound_channel_name
        self.min_frequency = min_frequency
        self.max_frequency = max_frequency
        self.min_duration = min_duration
        self.max_duration = max_duration

    def get_sound_prefab(self):
        return self.sound_prefab

    def get_color_prefab(self):
        return self.color_prefab

    def get_sound_channel_name(self):
        return self.sound_channel_name

    def get_min_frequency(self):
        return self.min_frequency

    def get_max_frequency(self):
        return self.max_frequency

    def get_min_duration(self):
        return self.min_duration

    def get_max_duration(self):
        return self.max_duration

    def __str__(self):
        return "LightningEffectPrefab(sound_prefab={}, color_prefab={}, sound_channel_name={}, min_frequency={}" \
               "max_frequency={}, min_duration={}, max_duration={})"\
            .format(str(self.sound_prefab), str(self.color_prefab), self.sound_channel_name, self.min_frequency,
                    self.max_frequency, self.min_duration, self.max_duration)
