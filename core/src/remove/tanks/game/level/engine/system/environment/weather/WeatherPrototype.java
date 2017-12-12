package remove.tanks.game.level.engine.system.environment.weather;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototype;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class WeatherPrototype implements Serializable {
    private final List<WeatherEffectPrototype> effectPrototypes;

    public WeatherPrototype(List<WeatherEffectPrototype> effectPrototypes) {
        this.effectPrototypes = effectPrototypes;
    }

    public List<WeatherEffectPrototype> getEffectPrototypes() {
        return effectPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("effectPrototypes", effectPrototypes)
                .toString();
    }
}
