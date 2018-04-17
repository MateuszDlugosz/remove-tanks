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
public final class RemoveWeatherEffectEntityEventExecutor implements SubEventExecutor<RemoveWeatherEffectEntityEvent> {
    @Override
    public void executeEvent(RemoveWeatherEffectEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(WeatherSystem.class))
                    .ifPresent(s -> s.removeWeatherEffect(event.getId()));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<RemoveWeatherEffectEntityEvent> getExecutorType() {
        return RemoveWeatherEffectEntityEvent.class;
    }
}
