package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public enum ListenerType {
    SpawnCycleListener(100),
    SoundListener(200),
    EnemyDestroyListener(300),
    BonusLootListener(400),
    TriggerListener(500);

    private final int priority;

    ListenerType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
