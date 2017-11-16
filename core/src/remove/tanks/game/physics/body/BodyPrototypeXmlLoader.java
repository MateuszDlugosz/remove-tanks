package remove.tanks.game.physics.body;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class BodyPrototypeXmlLoader {
    public static final String BODY_ELEMENT = "body";

    private static final String BODY_TYPE_ELEMENT = "type";
    private static final String ACTIVE_ELEMENT = "active";
    private static final String AWAKE_ELEMENT = "awake";
    private static final String ALLOW_SLEEP_ELEMENT = "allowSleep";
    private static final String FIXED_ROTATION_ELEMENT = "fixedRotation";
    private static final String BULLET_ELEMENT = "bullet";
    private static final String GRAVITY_SCALE_ELEMENT = "gravityScale";
    private static final String ANGLE_ELEMENT = "angle";
    private static final String LINEAR_DAMPING_ELEMENT = "linearDamping";
    private static final String ANGULAR_DAMPING_ELEMENT = "angularDamping";

    private static final BodyDef.BodyType BODY_TYPE_DEFAULT_VALUE = BodyDef.BodyType.StaticBody;
    private static final boolean ACTIVE_DEFAULT_VALUE = true;
    private static final boolean AWAKE_DEFAULT_VALUE = true;
    private static final boolean ALLOW_SLEEP_DEFAULT_VALUE = true;
    private static final boolean FIXED_ROTATION_DEFAULT_VALUE = true;
    private static final boolean BULLET_DEFAULT_VALUE = false;
    private static final float GRAVITY_SCALE_DEFAULT_VALUE = 1f;
    private static final float ANGLE_DEFAULT_VALUE = 0f;
    private static final float LINEAR_DAMPING_DEFAULT_VALUE = 0f;
    private static final float ANGULAR_DAMPING_DEFAULT_VALUE = 0f;

    public BodyPrototype loadBodyPrototype(XmlReader.Element element) {
        try {
            return new BodyPrototype(
                    loadBodyType(element),
                    loadActive(element),
                    loadAllowSleep(element),
                    loadAwake(element),
                    loadBullet(element),
                    loadFixedRotation(element),
                    loadGravityScale(element),
                    loadAngle(element),
                    loadAngularDamping(element),
                    loadLinearDamping(element)
            );
        } catch (Exception e) {
            throw new BodyPrototypeXmlLoadException(element, e);
        }
    }

    private BodyDef.BodyType loadBodyType(XmlReader.Element element) {
        if (element.getChildByName(BODY_TYPE_ELEMENT) == null) {
            return BODY_TYPE_DEFAULT_VALUE;
        }
        return BodyDef.BodyType.valueOf(element.getChildByName(BODY_TYPE_ELEMENT).getText().trim());
    }

    private boolean loadActive(XmlReader.Element element) {
        if (element.getChildByName(ACTIVE_ELEMENT) == null) {
            return ACTIVE_DEFAULT_VALUE;
        }
        return Boolean.valueOf(element.getChildByName(ACTIVE_ELEMENT).getText().trim());
    }

    private boolean loadAllowSleep(XmlReader.Element element) {
        if (element.getChildByName(ALLOW_SLEEP_ELEMENT) == null) {
            return ALLOW_SLEEP_DEFAULT_VALUE;
        }
        return Boolean.valueOf(element.getChildByName(ALLOW_SLEEP_ELEMENT).getText().trim());
    }

    private boolean loadAwake(XmlReader.Element element) {
        if (element.getChildByName(AWAKE_ELEMENT) == null) {
            return AWAKE_DEFAULT_VALUE;
        }
        return Boolean.valueOf(element.getChildByName(AWAKE_ELEMENT).getText().trim());
    }

    private boolean loadBullet(XmlReader.Element element) {
        if (element.getChildByName(BULLET_ELEMENT) == null) {
            return BULLET_DEFAULT_VALUE;
        }
        return Boolean.valueOf(element.getChildByName(BULLET_ELEMENT).getText().trim());
    }

    private boolean loadFixedRotation(XmlReader.Element element) {
        if (element.getChildByName(FIXED_ROTATION_ELEMENT) == null) {
            return FIXED_ROTATION_DEFAULT_VALUE;
        }
        return Boolean.valueOf(element.getChildByName(FIXED_ROTATION_ELEMENT).getText().trim());
    }

    private float loadGravityScale(XmlReader.Element element) {
        if (element.getChildByName(GRAVITY_SCALE_ELEMENT) == null) {
            return GRAVITY_SCALE_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(GRAVITY_SCALE_ELEMENT).getText().trim());
    }

    private float loadAngle(XmlReader.Element element) {
        if (element.getChildByName(ANGLE_ELEMENT) == null) {
            return ANGLE_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(ANGLE_ELEMENT).getText().trim());
    }

    private float loadAngularDamping(XmlReader.Element element) {
        if (element.getChildByName(ANGULAR_DAMPING_ELEMENT) == null) {
            return ANGULAR_DAMPING_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(ANGULAR_DAMPING_ELEMENT).getText().trim());
    }

    private float loadLinearDamping(XmlReader.Element element) {
        if (element.getChildByName(LINEAR_DAMPING_ELEMENT) == null) {
            return LINEAR_DAMPING_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(LINEAR_DAMPING_ELEMENT).getText().trim());
    }
}
