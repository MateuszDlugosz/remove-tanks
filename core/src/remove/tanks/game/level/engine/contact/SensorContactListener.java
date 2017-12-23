package remove.tanks.game.level.engine.contact;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.*;
import remove.tanks.game.physics.fixture.sensor.Sensor;

/**
 * @author Mateusz Długosz
 */
public final class SensorContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        if (fixtureA.getUserData() instanceof Sensor && fixtureB.getUserData() instanceof Entity) {
            ((Sensor) fixtureA.getUserData()).beginContact(fixtureB.getUserData());
        }
        if (fixtureB.getUserData() instanceof Sensor && fixtureA.getUserData() instanceof Entity) {
            ((Sensor) fixtureB.getUserData()).beginContact(fixtureA.getUserData());
        }
    }

    @Override
    public void endContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        if (fixtureA.getUserData() instanceof Sensor && fixtureB.getUserData() instanceof Entity) {
            ((Sensor) fixtureA.getUserData()).endContact(fixtureB.getUserData());
        }
        if (fixtureB.getUserData() instanceof Sensor && fixtureA.getUserData() instanceof Entity) {
            ((Sensor) fixtureB.getUserData()).endContact(fixtureA.getUserData());
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {}

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {}
}
