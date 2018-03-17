package remove.tanks.game.level.utility.weather.effect.lightning;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class LightningWeatherEffectPrefab extends WeatherEffectPrefab {
    private final SoundPrefab soundPrefab;
    private final ColorPrefab colorPrefab;
    private final SoundChannelName soundChannelName;
    private final float minFrequency;
    private final float maxFrequency;
    private final float minDuration;
    private final float maxDuration;

    public LightningWeatherEffectPrefab(
            SoundPrefab soundPrefab,
            ColorPrefab colorPrefab,
            SoundChannelName soundChannelName,
            float minFrequency,
            float maxFrequency,
            float minDuration,
            float maxDuration
    ) {
        this.soundPrefab = soundPrefab;
        this.colorPrefab = colorPrefab;
        this.soundChannelName = soundChannelName;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
    }

    public SoundPrefab getSoundPrefab() {
        return soundPrefab;
    }

    public ColorPrefab getColorPrefab() {
        return colorPrefab;
    }

    public SoundChannelName getSoundChannelName() {
        return soundChannelName;
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
                .add("soundPrefab", soundPrefab)
                .add("colorPrefab", colorPrefab)
                .add("soundChannelName", soundChannelName)
                .add("minFrequency", minFrequency)
                .add("maxFrequency", maxFrequency)
                .add("minDuration", minDuration)
                .add("maxDuration", maxDuration)
                .toString();
    }
}
