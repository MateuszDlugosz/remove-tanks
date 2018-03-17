package remove.tanks.game.audio;

import com.badlogic.gdx.math.MathUtils;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.event.AudioOptionChangedEvent;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfiguration {
    public enum Option {
        Pan(-100, 100, 0),
        Volume(0, 100, 50);

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

    public AudioConfiguration(Map<Option, Integer> options, EventBus eventBus) {
        this.options = options;
        this.eventBus = eventBus;
    }

    public void setOptionValue(Option option, int value) {
        this.options.put(option, MathUtils.clamp(value, option.getMinValue(), option.getMaxValue()));
        eventBus.post(new AudioOptionChangedEvent(option, value));
    }

    public int getOptionValueAsInt(Option option) {
        return options.get(option);
    }

    public float getOptionValueAsFloat(Option option) {
        return getOptionValueAsInt(option) * 0.01f;
    }
}
