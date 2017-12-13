package remove.tanks.game.level.engine.system.environment.weather.effect.lightning;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.sound.SoundPrototype;
import remove.tanks.game.graphic.color.ColorPrototype;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototype;

/**
 * @author Mateusz Długosz
 */
public final class LightningWeatherEffectPrototype implements WeatherEffectPrototype {
    private final SoundPrototype soundPrototype;
    private final ColorPrototype colorPrototype;
    private final float minFrequency;
    private final float maxFrequency;
    private final float minDuration;
    private final float maxDuration;

    public LightningWeatherEffectPrototype(
            SoundPrototype soundPrototype,
            ColorPrototype colorPrototype,
            float minFrequency,
            float maxFrequency,
            float minDuration,
            float maxDuration
    ) {
        this.soundPrototype = soundPrototype;
        this.colorPrototype = colorPrototype;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
    }

    public SoundPrototype getSoundPrototype() {
        return soundPrototype;
    }

    public ColorPrototype getColorPrototype() {
        return colorPrototype;
    }

    public float getMinFrequency() {
        return minFrequency;
    }

    public float getMaxFrequency() {
        return maxFrequency;
    }

    public float getMinDuration() {
        return minDuration;
    }

    public float getMaxDuration() {
        return maxDuration;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("soundPrototype", soundPrototype)
                .add("colorPrototype", colorPrototype)
                .add("minFrequency", minFrequency)
                .add("maxFrequency", maxFrequency)
                .add("minDuration", minDuration)
                .add("maxDuration", maxDuration)
                .toString();
    }
}
