package remove.tanks.game.physics.fixture.sensor;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import remove.tanks.game.physics.fixture.FixtureFactory;
import remove.tanks.game.physics.fixture.FixturePrefab;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class SensorFactory {
    private final FixtureFactory fixtureFactory;

    public SensorFactory(FixtureFactory fixtureFactory) {
        this.fixtureFactory = fixtureFactory;
    }

    public Sensor createSensor(SensorPrefab prefab, Body body, Scale scale) {
        try {
            return new Sensor(
                    prefab.getId(),
                    createFixture(prefab.getFixturePrefab(), body, scale)
            );
        } catch (Exception e) {
            throw new SensorCreateException(prefab, e);
        }
    }

    private Fixture createFixture(FixturePrefab prefab, Body body, Scale scale) {
        return fixtureFactory.createFixture(prefab, body, scale, true);
    }
}
