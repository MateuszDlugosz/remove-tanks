package remove.tanks.game.level.engine.system.hud.stages.message;

import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class Message {
    private final Timer timer;
    private final TranslationEntryKey entryKey;

    public Message(Timer timer, TranslationEntryKey entryKey) {
        this.timer = timer;
        this.entryKey = entryKey;
    }

    public Timer getTimer() {
        return timer;
    }

    public TranslationEntryKey getEntryKey() {
        return entryKey;
    }
}
