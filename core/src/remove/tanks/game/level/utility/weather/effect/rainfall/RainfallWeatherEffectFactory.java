package remove.tanks.game.level.utility.weather.effect.rainfall;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.graphics.particle.ParticleEffectFactory;
import remove.tanks.game.graphics.particle.ParticleEffectPrefab;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.weather.effect.SubWeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectCreateException;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class RainfallWeatherEffectFactory implements SubWeatherEffectFactory<RainfallWeatherEffect, RainfallWeatherEffectPrefab> {
    private final ParticleEffectFactory particleEffectFactory;

    public RainfallWeatherEffectFactory(ParticleEffectFactory particleEffectFactory) {
        this.particleEffectFactory = particleEffectFactory;
    }

    @Override
    public RainfallWeatherEffect createWeatherEffect(RainfallWeatherEffectPrefab prefab, ResourceRegistry registry) {
        try {
            return new RainfallWeatherEffect(
                    prefab.getId(),
                    createParticleEffect(
                            prefab.getParticleEffectPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class),
                            registry.getResource(ResourceType.WorldScaleResource, Scale.class)
                    ),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class),
                    registry.getResource(ResourceType.SpriteBatchResource, SpriteBatch.class)
            );
        } catch (Exception e) {
            throw new WeatherEffectCreateException(prefab, e);
        }
    }

    private ParticleEffect createParticleEffect(ParticleEffectPrefab prefab, AssetStorage assetStorage, Scale scale) {
        return particleEffectFactory.createParticleEffect(prefab, assetStorage, scale);
    }

    @Override
    public Class<RainfallWeatherEffectPrefab> getFactoryType() {
        return RainfallWeatherEffectPrefab.class;
    }
}
