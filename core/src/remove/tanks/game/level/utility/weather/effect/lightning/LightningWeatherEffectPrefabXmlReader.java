package remove.tanks.game.level.utility.weather.effect.lightning;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;
import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.graphics.color.ColorPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.SubWeatherEffectPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefabXmlReadException;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectType;

/**
 * @author Mateusz Długosz
 */
public final class LightningWeatherEffectPrefabXmlReader implements SubWeatherEffectPrefabXmlReader<LightningWeatherEffectPrefab> {
    private static final String SOUND_CHANNEL_NAME_ELEMENT = "soundChannelName";
    private static final String MIN_FREQUENCY_ELEMENT = "minFrequency";
    private static final String MAX_FREQUENCY_ELEMENT = "maxFrequency";
    private static final String MIN_DURATION_ELEMENT = "minDuration";
    private static final String MAX_DURATION_ELEMENT = "maxDuration";

    private final SoundPrefabXmlReader soundPrefabXmlReader;
    private final ColorPrefabXmlReader colorPrefabXmlReader;

    public LightningWeatherEffectPrefabXmlReader(
            SoundPrefabXmlReader soundPrefabXmlReader,
            ColorPrefabXmlReader colorPrefabXmlReader
    ) {
        this.soundPrefabXmlReader = soundPrefabXmlReader;
        this.colorPrefabXmlReader = colorPrefabXmlReader;
    }

    @Override
    public LightningWeatherEffectPrefab readWeatherEffect(XmlReader.Element element) {
        try {
            return new LightningWeatherEffectPrefab(
                    readSoundPrefab(element),
                    readColorPrefab(element),
                    readSoundChannelName(element),
                    readMinFrequency(element),
                    readMaxFrequency(element),
                    readMinDuration(element),
                    readMaxDuration(element)
            );
        } catch (Exception e) {
            throw new WeatherEffectPrefabXmlReadException(element, e);
        }
    }

    private SoundPrefab readSoundPrefab(XmlReader.Element element) {
        return soundPrefabXmlReader.readSoundPrefab(
                element.getChildByName(SoundPrefabXmlReader.SOUND_ELEMENT)
        );
    }

    private ColorPrefab readColorPrefab(XmlReader.Element element) {
        return colorPrefabXmlReader.readColorPrefab(
                element.getChildByName(ColorPrefabXmlReader.COLOR_ELEMENT)
        );
    }

    private SoundChannelName readSoundChannelName(XmlReader.Element element) {
        return SoundChannelName.valueOf(element.getChildByName(SOUND_CHANNEL_NAME_ELEMENT).getText().trim());
    }

    private float readMinFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_FREQUENCY_ELEMENT).getText().trim());
    }

    private float readMaxFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_FREQUENCY_ELEMENT).getText().trim());
    }

    private float readMinDuration(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_DURATION_ELEMENT).getText().trim());
    }

    private float readMaxDuration(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_DURATION_ELEMENT).getText().trim());
    }

    @Override
    public WeatherEffectType getReaderType() {
        return WeatherEffectType.LightningWeatherEffect;
    }
}
