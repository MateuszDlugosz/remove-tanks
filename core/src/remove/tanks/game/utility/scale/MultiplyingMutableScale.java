package remove.tanks.game.utility.scale;

/**
 * @author Mateusz Długosz
 */
public final class MultiplyingMutableScale implements MutableScale {
    private float value;

    public MultiplyingMutableScale(float value) {
        this.value = value;
    }

    @Override
    public float getValue() {
        return value;
    }

    @Override
    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public float scaleValue(float value) {
        return value * this.value;
    }
}
