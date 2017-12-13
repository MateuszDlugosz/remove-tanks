package remove.tanks.game.level.engine.system.environment.weather.effect.lightning;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.graphic.color.ColorFactory;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.environment.weather.effect.RegistrableWeatherEffectFactory;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectCreateException;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class LightningWeatherEffectFactory
        implements RegistrableWeatherEffectFactory<LightningWeatherEffect, LightningWeatherEffectPrototype>
{
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
    public LightningWeatherEffect createWeatherEffect(LightningWeatherEffectPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new LightningWeatherEffect(
                    soundFactory.createSound(prototype.getSoundPrototype(), resourceRegistry.getResource(
                            LevelResource.AssetStorage.toString(), AssetStorage.class
                    )),
                    colorFactory.createColor(prototype.getColorPrototype()),
                    prototype.getMinFrequency(),
                    prototype.getMaxFrequency(),
                    prototype.getMinDuration(),
                    prototype.getMaxDuration(),
                    randomNumberGenerator,
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class)
            );
        } catch (Exception e) {
            throw new WeatherEffectCreateException(prototype, e);
        }
    }

    @Override
    public Class<LightningWeatherEffectPrototype> getFactoryType() {
        return LightningWeatherEffectPrototype.class;
    }
}
