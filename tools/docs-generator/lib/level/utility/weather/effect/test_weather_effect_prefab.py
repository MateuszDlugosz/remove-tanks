import unittest

from lib.audio.sound.sound_prefab import SoundPrefab
from lib.graphics.color.color_prefab import HexColorPrefab
from lib.level.utility.weather.effect.weather_effect_prefab import LightningWeatherEffectPrefab


class TestLightningEffectPrefab(unittest.TestCase):
    def test_to_string(self):
        self.assertEqual(
            'LightningEffectPrefab(sound_prefab=SoundPrefab(filename=filename), color_prefab=HexColorPrefab'
            '(hex_value=CCAAFFEE), sound_channel_name=channel_name, min_frequency=1max_frequency=2, min_duration=3,'
            ' max_duration=4)',
            str(LightningWeatherEffectPrefab(
                SoundPrefab("filename"),
                HexColorPrefab("CCAAFFEE"),
                "channel_name",
                1, 2, 3, 4
            ))
        )


if __name__ == "__main__":
    unittest.main()
