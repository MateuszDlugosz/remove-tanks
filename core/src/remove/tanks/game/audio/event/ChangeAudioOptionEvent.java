package remove.tanks.game.audio.event;

import remove.tanks.game.audio.AudioOptions;

/**
 * @author Mateusz Długosz
 */
public final class ChangeAudioOptionEvent {
    private final AudioOptions.Option option;
    private final int newValue;

    public ChangeAudioOptionEvent(AudioOptions.Option option, int newValue) {
        this.option = option;
        this.newValue = newValue;
    }

    public AudioOptions.Option getOption() {
        return option;
    }

    public int getNewValue() {
        return newValue;
    }
}
