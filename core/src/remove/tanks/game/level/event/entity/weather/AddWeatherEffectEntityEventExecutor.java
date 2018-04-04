package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.system.weather.WeatherSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.event.weather.AddWeatherEffectEvent;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEntityEventExecutor implements SubEventExecutor<AddWeatherEffectEntityEvent> {
    @Override
    public void executeEvent(AddWeatherEffectEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(WeatherSystem.class))
                    .ifPresent(s -> s.addWeatherEffect(event.getWeatherEffect()));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AddWeatherEffectEntityEvent> getExecutorType() {
        return AddWeatherEffectEntityEvent.class;
    }
}
