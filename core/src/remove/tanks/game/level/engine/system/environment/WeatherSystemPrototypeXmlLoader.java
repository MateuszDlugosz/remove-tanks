package remove.tanks.game.level.engine.system.environment;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<WeatherSystemPrototype>
{
    @Override
    public WeatherSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new WeatherSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.WeatherSystem;
    }
}
