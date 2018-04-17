package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.system.weather.WeatherSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEntityEventExecutor implements SubEventExecutor<ClearWeatherEffectsEntityEvent> {
    @Override
    public void executeEvent(ClearWeatherEffectsEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(WeatherSystem.class))
                    .ifPresent(WeatherSystem::clearWeatherEffects);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<ClearWeatherEffectsEntityEvent> getExecutorType() {
        return ClearWeatherEffectsEntityEvent.class;
    }
}
