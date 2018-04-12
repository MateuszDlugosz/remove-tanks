package remove.tanks.game.physics.fixture.sensor;

import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.fixture.FixtureFactory;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

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
                    fixtureFactory.createFixtureAsSensor(
                            prefab.getFixturePrefab(), body, scale
                    )
            );
        } catch (Exception e) {
            throw new SensorCreateException(prefab, e);
        }
    }
}
