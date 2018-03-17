package remove.tanks.game.level.utility.weather;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class WeatherPrefab extends Prefab {
    private final List<WeatherEffectPrefab> effectPrefabs;

    public WeatherPrefab(List<WeatherEffectPrefab> effectPrefabs) {
        this.effectPrefabs = effectPrefabs;
    }

    public List<WeatherEffectPrefab> getEffectPrefabs() {
        return effectPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("effectPrefabs", effectPrefabs)
                .toString();
    }
}
