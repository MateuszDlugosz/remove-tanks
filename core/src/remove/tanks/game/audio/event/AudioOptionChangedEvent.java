package remove.tanks.game.audio.event;

import remove.tanks.game.audio.AudioConfiguration;

/**
 * @author Mateusz Długosz
 */
public final class AudioOptionChangedEvent {
    private final AudioConfiguration.Option option;

    public AudioOptionChangedEvent(AudioConfiguration.Option option) {
        this.option = option;
    }

    public AudioConfiguration.Option getOption() {
        return option;
    }
}
