package remove.tanks.game.physics.fixture.sensor;

import com.google.common.base.MoreObjects;
import remove.tanks.game.physics.fixture.FixturePrototype;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class SensorPrototype implements Serializable {
    private final String id;
    private final FixturePrototype fixturePrototype;

    public SensorPrototype(String id, FixturePrototype fixturePrototype) {
        this.id = id;
        this.fixturePrototype = fixturePrototype;
    }

    public String getId() {
        return id;
    }

    public FixturePrototype getFixturePrototype() {
        return fixturePrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("fixturePrototype", fixturePrototype)
                .toString();
    }
}
