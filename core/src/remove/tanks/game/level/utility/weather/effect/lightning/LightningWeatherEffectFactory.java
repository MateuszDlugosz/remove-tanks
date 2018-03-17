package remove.tanks.game.level.utility.weather.effect.lightning;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.graphics.color.ColorFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.weather.effect.SubWeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectCreateException;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class LightningWeatherEffectFactory implements SubWeatherEffectFactory<LightningWeatherEffect, LightningWeatherEffectPrefab> {
    private final SoundFactory soundFactory;
    private final ColorFactory colorFactory;
    private final RandomNumberGenerator randomNumberGenerator;

    public LightningWeatherEffectFactory(
            SoundFactory soundFactory,
            ColorFactory colorFactory,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.soundFactory = soundFactory;
        this.colorFactory = colorFactory;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public LightningWeatherEffect createWeatherEffect(LightningWeatherEffectPrefab prefab, ResourceRegistry resourceRegistry) {
        try {
            return new LightningWeatherEffect(
                    soundFactory.createSound(prefab.getSoundPrefab(), resourceRegistry.getResource(
                            ResourceType.AssetStorageResource, AssetStorage.class)),
                    prefab.getSoundChannelName(),
                    colorFactory.createColor(prefab.getColorPrefab()),
                    prefab.getMinFrequency(),
                    prefab.getMaxFrequency(),
                    prefab.getMinDuration(),
                    prefab.getMaxDuration(),
                    randomNumberGenerator,
                    resourceRegistry.getResource(ResourceType.EventBusResource, EventBus.class)
            );
        } catch (Exception e) {
            throw new WeatherEffectCreateException(prefab, e);
        }
    }

    @Override
    public Class<LightningWeatherEffectPrefab> getFactoryType() {
        return LightningWeatherEffectPrefab.class;
    }
}
