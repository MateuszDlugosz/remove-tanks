package remove.tanks.game.utility.time;

/**
 * @author Mateusz Długosz
 */
public final class Timer {
    private final float completionTime;
    private float time;

    public Timer(float completionTime) {
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
        return !(time < 0) && time >= completionTime;
    }

    public float getTime() {
        return time;
    }

    public float getCompletionTime() {
        return completionTime;
    }
}
