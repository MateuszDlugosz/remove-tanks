package remove.tanks.game.physics.body;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class BodyFactory {
    public List<Body> createBodies(List<BodyPrefab> prefabs, World world) {
        return prefabs.stream()
                .map(p -> createBody(p, world))
                .collect(Collectors.toList());
    }

    public Body createBody(BodyPrefab prefab, World world) {
        try {
            return world.createBody(createBodyDef(prefab));
        } catch (Exception e) {
            throw new BodyCreateException(prefab, e);
        }
    }

    private BodyDef createBodyDef(BodyPrefab prefab) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = prefab.getType();
        bodyDef.active = prefab.isActive();
        bodyDef.awake = prefab.isAwake();
        bodyDef.allowSleep = prefab.isAllowSleep();
        bodyDef.fixedRotation = prefab.isFixedRotation();
        bodyDef.bullet = prefab.isBullet();
        bodyDef.gravityScale = prefab.getGravityScale();
        bodyDef.angle = prefab.getAngle() * MathUtils.degreesToRadians;
        bodyDef.linearDamping = prefab.getLinearDamping();
        bodyDef.angularDamping = prefab.getAngularDamping();
        return bodyDef;
    }
}
