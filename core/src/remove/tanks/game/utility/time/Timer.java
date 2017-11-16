package remove.tanks.game.utility.time;

/**
 * @author Mateusz Długosz
 */
public final class Timer {
    private final float completionTime;
    private float time;

    public Timer(float completionTime) {
        if (completionTime < 0) {
            throw new IllegalArgumentException("Completion time cannot be lower than zero.");
        }
        this.completionTime = completionTime;
        this.time = 0;
    }

    public void update(float delta) {
        time += delta;
    }

    public void reset() {
        this.time = 0;
    }

    public boolean isComplete() {
        return time >= completionTime;
    }
}
