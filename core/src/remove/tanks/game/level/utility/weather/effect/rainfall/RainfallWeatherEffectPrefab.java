package remove.tanks.game.level.utility.weather.effect.rainfall;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.particle.ParticleEffectPrefab;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RainfallWeatherEffectPrefab extends WeatherEffectPrefab {
    private final String id;
    private final ParticleEffectPrefab particleEffectPrefab;

    public RainfallWeatherEffectPrefab(String id, ParticleEffectPrefab particleEffectPrefab) {
        this.id = id;
        this.particleEffectPrefab = particleEffectPrefab;
    }

    @Override
    public String getId() {
        return id;
    }

    public ParticleEffectPrefab getParticleEffectPrefab() {
        return particleEffectPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("particleEffectPrefab", particleEffectPrefab)
                .toString();
    }
}
