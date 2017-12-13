package remove.tanks.game.level.engine.system.environment.weather.effect.lightning;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundPrototype;
import remove.tanks.game.audio.sound.SoundPrototypeXmlLoader;
import remove.tanks.game.graphic.color.ColorPrototype;
import remove.tanks.game.graphic.color.ColorPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.weather.effect.RegistrableWeatherEffectPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectType;

/**
 * @author Mateusz Długosz
 */
public final class LightningWeatherEffectPrototypeXmlLoader
        implements RegistrableWeatherEffectPrototypeXmlLoader<LightningWeatherEffectPrototype>
{
    private static final String MIN_FREQUENCY_ELEMENT = "minFrequency";
    private static final String MAX_FREQUENCY_ELEMENT = "maxFrequency";
    private static final String MIN_DURATION_ELEMENT = "minDuration";
    private static final String MAX_DURATION_ELEMENT = "maxDuration";

    private final SoundPrototypeXmlLoader soundPrototypeXmlLoader;
    private final ColorPrototypeXmlLoader colorPrototypeXmlLoader;

    public LightningWeatherEffectPrototypeXmlLoader(
            SoundPrototypeXmlLoader soundPrototypeXmlLoader,
            ColorPrototypeXmlLoader colorPrototypeXmlLoader
    ) {
        this.soundPrototypeXmlLoader = soundPrototypeXmlLoader;
        this.colorPrototypeXmlLoader = colorPrototypeXmlLoader;
    }

    @Override
    public LightningWeatherEffectPrototype loadWeatherEffect(XmlReader.Element element) {
        try {
            return new LightningWeatherEffectPrototype(
                    loadSoundPrototype(element),
                    loadColorPrototype(element),
                    loadMinFrequency(element),
                    loadMaxFrequency(element),
                    loadMinDuration(element),
                    loadMaxDuration(element)
            );
        } catch (Exception e) {
            throw new WeatherEffectPrototypeXmlLoadException(element, e);
        }
    }

    private SoundPrototype loadSoundPrototype(XmlReader.Element element) {
        return soundPrototypeXmlLoader.loadSoundPrototype(
                element.getChildByName(SoundPrototypeXmlLoader.SOUND_ELEMENT)
        );
    }

    private ColorPrototype loadColorPrototype(XmlReader.Element element) {
        return colorPrototypeXmlLoader.loadColorPrototype(
                element.getChildByName(ColorPrototypeXmlLoader.COLOR_ELEMENT)
        );
    }

    private float loadMinFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_FREQUENCY_ELEMENT).getText().trim());
    }

    private float loadMaxFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_FREQUENCY_ELEMENT).getText().trim());
    }

    private float loadMinDuration(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_DURATION_ELEMENT).getText().trim());
    }

    private float loadMaxDuration(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_DURATION_ELEMENT).getText().trim());
    }

    @Override
    public WeatherEffectType getLoaderType() {
        return WeatherEffectType.LightningWeatherEffect;
    }
}
