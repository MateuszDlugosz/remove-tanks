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

    public List<HitBox> createHitBoxes(List<HitBoxPrototype> prototypes, Body body, Scale scale) {
        return prototypes.stream()
                .map(p -> createHitBox(p, body, scale))
                .collect(Collectors.toList());
    }

    public HitBox createHitBox(HitBoxPrototype prototype, Body body, Scale scale) {
        try {
            return new HitBox(
                    prototype.getId(),
                    fixtureFactory.createFixtureAsHitBox(prototype.getFixturePrototype(), body, scale)
            );
        } catch (Exception e) {
            throw new HitBoxCreateException(prototype, e);
        }
    }
}
