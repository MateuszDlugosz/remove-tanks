package remove.tanks.game.utility.scale;

/**
 * @author Mateusz Długosz
 */
public final class MultiplyingScale implements Scale {
    private final float value;

    public MultiplyingScale(float value) {
        this.value = value;
    }

    @Override
    public float scaleValue(float value) {
        return value * this.value;
    }

    @Override
    public float getValue() {
        return this.value;
    }
}
