package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public enum ListenerType {
    SpawnCycleListener(100),
    SoundListener(200),
    BonusLootListener(300),
    TriggerListener(400);

    private final int priority;

    ListenerType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
