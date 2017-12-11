package remove.tanks.game.physics.fixture;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import remove.tanks.game.physics.shape.ShapeFactory;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class FixtureFactory {
    private final ShapeFactory shapeFactory;

    public FixtureFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public Fixture createFixture(FixturePrototype prototype, Body body, Scale scale) {
        try {
            return body.createFixture(createFixtureDef(prototype, scale));
        } catch (Exception e) {
            throw new FixtureCreateException(prototype, e);
        }
    }

    public Fixture createFixtureAsHitBox(FixturePrototype prototype, Body body, Scale scale) {
        try {
            FixtureDef fixtureDef = createFixtureDef(prototype, scale);
            fixtureDef.isSensor = false;
            return body.createFixture(fixtureDef);
        } catch (Exception e) {
            throw new FixtureCreateException(prototype, e);
        }
    }

    public Fixture createFixtureAsSensor(FixturePrototype prototype, Body body, Scale scale) {
        try {
            FixtureDef fixtureDef = createFixtureDef(prototype, scale);
            fixtureDef.isSensor = true;
            return body.createFixture(fixtureDef);
        } catch (Exception e) {
            throw new FixtureCreateException(prototype, e);
        }
    }

    private FixtureDef createFixtureDef(FixturePrototype prototype, Scale scale) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor = prototype.isSensor();
        fixtureDef.density = prototype.getDensity();
        fixtureDef.friction = prototype.getFriction();
        fixtureDef.restitution = prototype.getRestitution();
        fixtureDef.shape = shapeFactory.createShape(prototype.getShapePrototype(), scale);
        fixtureDef.filter.categoryBits = prototype.getFilterPrototype().getCategoryBit();
        fixtureDef.filter.maskBits = prototype.getFilterPrototype().getMaskBit();
        return fixtureDef;
    }
}
