package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEntityEvent implements EntityEvent {
    private final Entity entity;
    private final WeatherEffect weatherEffect;

    public AddWeatherEffectEntityEvent(Entity entity, WeatherEffect weatherEffect) {
        this.entity = entity;
        this.weatherEffect = weatherEffect;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public WeatherEffect getWeatherEffect() {
        return weatherEffect;
    }
}
