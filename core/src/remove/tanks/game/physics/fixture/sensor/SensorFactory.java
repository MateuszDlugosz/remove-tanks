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

    public List<Sensor> createSensors(List<SensorPrototype> prototypes, Body body, Scale scale) {
        return prototypes.stream()
                .map(p -> createSensor(p, body, scale))
                .collect(Collectors.toList());
    }

    public Sensor createSensor(SensorPrototype prototype, Body body, Scale scale) {
        try {
            return new Sensor(
                    prototype.getId(),
                    fixtureFactory.createFixtureAsSensor(
                            prototype.getFixturePrototype(), body, scale
                    )
            );
        } catch (Exception e) {
            throw new SensorCreateException(prototype, e);
        }
    }
}
