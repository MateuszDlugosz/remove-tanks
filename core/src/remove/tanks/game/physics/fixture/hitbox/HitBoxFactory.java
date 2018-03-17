package remove.tanks.game.physics.fixture.hitbox;

import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.fixture.FixtureFactory;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class HitBoxFactory {
    private final FixtureFactory fixtureFactory;

    public HitBoxFactory(FixtureFactory fixtureFactory) {
        this.fixtureFactory = fixtureFactory;
    }

    public List<HitBox> createHitBoxes(List<HitBoxPrefab> prefabs, Body body, Scale scale) {
        return prefabs.stream()
                .map(p -> createHitBox(p, body, scale))
                .collect(Collectors.toList());
    }

    public HitBox createHitBox(HitBoxPrefab prefab, Body body, Scale scale) {
        try {
            return new HitBox(
                    prefab.getId(),
                    fixtureFactory.createFixtureAsHitBox(prefab.getFixturePrefab(), body, scale)
            );
        } catch (Exception e) {
            throw new HitBoxCreateException(prefab, e);
        }
    }
}
