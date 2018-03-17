package remove.tanks.game.graphics.camera.effect.shake;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ShakeCameraEffectPrefab extends CameraEffectPrefab {
    private final float time;
    private final float power;

    public ShakeCameraEffectPrefab(float time, float power) {
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
