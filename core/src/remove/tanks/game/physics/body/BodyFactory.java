package remove.tanks.game.physics.body;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Mateusz Długosz
 */
public final class BodyFactory {
    public Body createBody(BodyPrototype prototype, World world) {
        try {
            return world.createBody(createBodyDef(prototype));
        } catch (Exception e) {
            throw new BodyCreateException(prototype, e);
        }
    }

    private BodyDef createBodyDef(BodyPrototype prototype) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = prototype.getType();
        bodyDef.active = prototype.isActive();
        bodyDef.awake = prototype.isAwake();
        bodyDef.allowSleep = prototype.isAllowSleep();
        bodyDef.fixedRotation = prototype.isFixedRotation();
        bodyDef.bullet = prototype.isBullet();
        bodyDef.gravityScale = prototype.getGravityScale();
        bodyDef.angle = prototype.getAngle() * MathUtils.degreesToRadians;
        bodyDef.linearDamping = prototype.getLinearDamping();
        bodyDef.angularDamping = prototype.getAngularDamping();
        return bodyDef;
    }
}
