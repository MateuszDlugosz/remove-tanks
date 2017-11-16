package remove.tanks.game.audio;

import com.badlogic.gdx.math.MathUtils;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.event.AudioOptionsChangedEvent;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AudioOptions {
    public enum Option {
        SoundVolume(0, 100, 20),
        MusicVolume(0, 100, 100),
        Pan(-100, 100, 50);

        private final int minValue;
        private final int maxValue;
        private final int defaultValue;

        Option(int minValue, int maxValue, int defaultValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.defaultValue = defaultValue;
        }

        public int getMinValue() {
            return minValue;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public int getDefaultValue() {
            return defaultValue;
        }
    }

    private final Map<Option, Integer> options;
    private final EventBus eventBus;

    public AudioOptions(Map<Option, Integer> options, EventBus eventBus) {
        this.options = options;
        this.eventBus = eventBus;
    }

    public void setOptionValue(Option option, int value) {
        options.put(option, MathUtils.clamp(value, option.getMinValue(), option.getMaxValue()));
        eventBus.post(new AudioOptionsChangedEvent());
    }

    public float getOptionValueAsFloat(Option option) {
        return options.get(option) * 0.01f;
    }

    public int getOptionValueAsInt(Option option) {
        return options.get(option);
    }
}
