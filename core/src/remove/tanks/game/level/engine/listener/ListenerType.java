package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public enum ListenerType {
    CreateTriggerListener(10000),
    DestroyTriggerListener(10000),
    HitTriggerListener(10000),
    EnemyDestroyListener(10500),
    LeaveBonusListener(11000);

    private final int priority;

    ListenerType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
