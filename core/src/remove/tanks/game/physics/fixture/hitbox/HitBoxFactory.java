package remove.tanks.game.physics.fixture.hitbox;

import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.fixture.FixtureFactory;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class HitBoxFactory {
    private final FixtureFactory fixtureFactory;

    public HitBoxFactory(FixtureFactory fixtureFactory) {
        this.fixtureFactory = fixtureFactory;
    }

    public HitBox createHitBox(HitBoxPrefab prefab, Body body, Scale scale) {
        try {
            return new HitBox(
                    prefab.getId(),
                    fixtureFactory.createFixture(prefab.getFixturePrefab(), body, scale, false)
            );
        } catch (Exception e) {
            throw new HitBoxCreateException(prefab, e);
        }
    }
}
