package remove.tanks.game.level.engine.system.environment.weather.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectPrototypeXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Can not load weather effect prototype from element %s.";

    public WeatherEffectPrototypeXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
