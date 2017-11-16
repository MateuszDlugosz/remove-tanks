package remove.tanks.game.utility.counter;

/**
 * @author Mateusz Długosz
 */
public final class Counter {
    private final int limit;
    private int value;

    public Counter(int limit) {
        this.limit = limit;
        if (limit < 0) {
            this.value = limit;
        } else {
            this.value = 0;
        }
    }

    public void update() {
        if (limit < 0) {
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
