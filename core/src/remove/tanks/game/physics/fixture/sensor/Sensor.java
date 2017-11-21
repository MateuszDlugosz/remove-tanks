package remove.tanks.game.physics.fixture.sensor;

import com.badlogic.gdx.physics.box2d.Fixture;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Sensor {
    private final String id;
    private final Fixture fixture;
    private final List<Object> contacts;

    public Sensor(String id, Fixture fixture) {
        this.id = id;
        this.fixture = fixture;
        this.contacts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public List<Object> getContacts() {
        return contacts;
    }

    public boolean isContacted() {
        return contacts.size() > 0;
    }

    public void beginContact(Object object) {
        contacts.add(object);
    }

    public void endContact(Object object) {
        contacts.remove(object);
    }
}
