package remove.tanks.game.utility.scale;

/**
 * @author Mateusz Długosz
 */
public final class DividingScale implements Scale {
    private final float value;

    public DividingScale(float value) {
        if (value <= 0) {
            throw new InvalidScaleValueException("Scale value must be greater than zero.");
        }
        this.value = value;
    }

    @Override
    public float scaleValue(float value) {
        return value / this.value;
    }

    @Override
    public float getValue() {
        return value;
    }
}
