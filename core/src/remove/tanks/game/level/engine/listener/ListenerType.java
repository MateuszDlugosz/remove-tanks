package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public enum ListenerType {
    SpawnCycleListener(100),
    SoundListener(200),
    EnemyDestroyListener(300),
    PointsListener(400),
    BonusLootListener(500),
    BonusPickUpListener(600),
    TriggerListener(700);

    private final int priority;

    ListenerType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
