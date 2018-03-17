package remove.tanks.game.utility.number.counter;

/**
 * @author Mateusz Długosz
 */
public final class Counter {
    private final int limit;
    private int value;

    public Counter(int limit) {
        this.limit = limit;
        this.value = 0;
    }

    public void update() {
        if (limit < 0) {
            value++;
            return;
        }
        if (value < limit) {
            value++;
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isComplete() {
        return limit >= 0 && value >= limit;
    }
}
