package remove.tanks.game.level.engine.system.hud.stages.broker.message;

import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.utility.time.Timer;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class Message {
    private final Timer timer;
    private final TranslationEntryKey entryKey;
    private final String faceId;

    public Message(Timer timer, TranslationEntryKey entryKey, String faceId) {
        this.timer = timer;
        this.entryKey = entryKey;
        this.faceId = faceId;
    }

    public Timer getTimer() {
        return timer;
    }

    public TranslationEntryKey getEntryKey() {
        return entryKey;
    }

    public Optional<String> getFaceId() {
        return Optional.ofNullable(faceId);
    }
}
