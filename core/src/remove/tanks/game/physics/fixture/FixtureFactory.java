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

    public Fixture createFixture(FixturePrefab prefab, Body body, Scale scale, boolean isSensor) {
        try {
            return body.createFixture(createFixtureDef(prefab, scale, isSensor));
        } catch (Exception e) {
            throw new FixtureCreateException(prefab, e);
        }
    }

    private FixtureDef createFixtureDef(FixturePrefab prefab, Scale scale, boolean isSensor) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor = isSensor;
        fixtureDef.density = prefab.getDensity();
        fixtureDef.friction = prefab.getFriction();
        fixtureDef.restitution = prefab.getRestitution();
        fixtureDef.shape = shapeFactory.createShape(prefab.getShapePrefab(), scale);
        fixtureDef.filter.categoryBits = prefab.getFilterPrefab().getCategoryBit();
        fixtureDef.filter.maskBits = prefab.getFilterPrefab().getMaskBit();
        return fixtureDef;
    }
}
