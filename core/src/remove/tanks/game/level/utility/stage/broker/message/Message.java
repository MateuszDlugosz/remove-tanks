package remove.tanks.game.level.utility.stage.broker.message;

import remove.tanks.game.utility.time.Timer;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class Message {
    private final Timer timer;
    private final String entryKey;
    private final String faceId;

    public Message(Timer timer, String entryKey, String faceId) {
        this.timer = timer;
        this.entryKey = entryKey;
        this.faceId = faceId;
    }

    public Timer getTimer() {
        return timer;
    }

    public String getEntryKey() {
        return entryKey;
    }

    public Optional<String> getFaceId() {
        return Optional.ofNullable(faceId);
    }
}
