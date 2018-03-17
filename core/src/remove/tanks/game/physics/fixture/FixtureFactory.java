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

    public Fixture createFixture(FixturePrefab prefab, Body body, Scale scale) {
        try {
            return body.createFixture(createFixtureDef(prefab, scale));
        } catch (Exception e) {
            throw new FixtureCreateException(prefab, e);
        }
    }

    public Fixture createFixtureAsHitBox(FixturePrefab prefab, Body body, Scale scale) {
        try {
            FixtureDef fixtureDef = createFixtureDef(prefab, scale);
            fixtureDef.isSensor = false;
            return body.createFixture(fixtureDef);
        } catch (Exception e) {
            throw new FixtureCreateException(prefab, e);
        }
    }

    public Fixture createFixtureAsSensor(FixturePrefab prefab, Body body, Scale scale) {
        try {
            FixtureDef fixtureDef = createFixtureDef(prefab, scale);
            fixtureDef.isSensor = true;
            return body.createFixture(fixtureDef);
        } catch (Exception e) {
            throw new FixtureCreateException(prefab, e);
        }
    }

    private FixtureDef createFixtureDef(FixturePrefab prefab, Scale scale) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor = prefab.isSensor();
        fixtureDef.density = prefab.getDensity();
        fixtureDef.friction = prefab.getFriction();
        fixtureDef.restitution = prefab.getRestitution();
        fixtureDef.shape = shapeFactory.createShape(prefab.getShapePrefab(), scale);
        fixtureDef.filter.categoryBits = prefab.getFilterPrefab().getCategoryBit();
        fixtureDef.filter.maskBits = prefab.getFilterPrefab().getMaskBit();
        return fixtureDef;
    }
}
