package remove.tanks.game.graphic.camera.effect.shake;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.camera.effect.CameraEffectPrototype;

/**
 * @author Mateusz Długosz
 */
public final class ShakeCameraEffectPrototype implements CameraEffectPrototype {
    private final float time;
    private final float power;

    public ShakeCameraEffectPrototype(float time, float power) {
        this.time = time;
        this.power = power;
    }

    public float getTime() {
        return time;
    }

    public float getPower() {
        return power;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("power", power)
                .toString();
    }
}
