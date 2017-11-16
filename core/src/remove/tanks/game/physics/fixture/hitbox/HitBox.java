package remove.tanks.game.physics.fixture.hitbox;

import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * @author Mateusz Długosz
 */
public final class HitBox {
    private final String id;
    private final Fixture fixture;

    public HitBox(String id, Fixture fixture) {
        this.id = id;
        this.fixture = fixture;
    }

    public String getId() {
        return id;
    }

    public Fixture getFixture() {
        return fixture;
    }
}
