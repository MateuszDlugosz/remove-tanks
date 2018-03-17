package remove.tanks.game.audio.event;

import remove.tanks.game.audio.AudioConfiguration;

/**
 * @author Mateusz Długosz
 */
public final class AudioOptionChangedEvent {
    private final AudioConfiguration.Option option;
    private final int newValue;

    public AudioOptionChangedEvent(AudioConfiguration.Option option, int newValue) {
        this.option = option;
        this.newValue = newValue;
    }

    public AudioConfiguration.Option getOption() {
        return option;
    }

    public int getNewValue() {
        return newValue;
    }
}
