package remove.tanks.game.level.engine.system.environment;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemFactory
        implements RegistrableEntitySystemFactory<WeatherSystem, WeatherSystemPrototype>
{
    @Override
    public WeatherSystem createEntitySystem(WeatherSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new WeatherSystem(prototype.getPriority(), resourceRegistry.getResource(
                LevelResource.EventBus.toString(), EventBus.class
        ));
    }

    @Override
    public Class<WeatherSystemPrototype> getFactoryType() {
        return WeatherSystemPrototype.class;
    }
}
