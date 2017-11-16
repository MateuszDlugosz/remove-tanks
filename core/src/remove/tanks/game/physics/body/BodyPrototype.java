package remove.tanks.game.physics.body;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class BodyPrototype implements Serializable {
    private final BodyDef.BodyType type;
    private final boolean active;
    private final boolean allowSleep;
    private final boolean awake;
    private final boolean bullet;
    private final boolean fixedRotation;
    private final float gravityScale;
    private final float angle;
    private final float angularDamping;
    private final float linearDamping;

    public BodyPrototype(
            BodyDef.BodyType type,
            boolean active,
            boolean allowSleep,
            boolean awake,
            boolean bullet,
            boolean fixedRotation,
            float gravityScale,
            float angle,
            float angularDamping,
            float linearDamping
    ) {
        this.type = type;
        this.active = active;
        this.allowSleep = allowSleep;
        this.awake = awake;
        this.bullet = bullet;
        this.fixedRotation = fixedRotation;
        this.gravityScale = gravityScale;
        this.angle = angle;
        this.angularDamping = angularDamping;
        this.linearDamping = linearDamping;
    }

    public BodyDef.BodyType getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAllowSleep() {
        return allowSleep;
    }

    public boolean isAwake() {
        return awake;
    }

    public boolean isBullet() {
        return bullet;
    }

    public boolean isFixedRotation() {
        return fixedRotation;
    }

    public float getGravityScale() {
        return gravityScale;
    }

    public float getAngle() {
        return angle;
    }

    public float getAngularDamping() {
        return angularDamping;
    }

    public float getLinearDamping() {
        return linearDamping;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("getFactoryType", type)
                .add("active", active)
                .add("allowSleep", allowSleep)
                .add("awake", awake)
                .add("bullet", bullet)
                .add("fixedRotation", fixedRotation)
                .add("gravityScale", gravityScale)
                .add("angle", angle)
                .add("angularDamping", angularDamping)
                .add("linearDamping", linearDamping)
                .toString();
    }
}
