package remove.tanks.game.physics.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Mateusz Długosz
 */
public final class WorldFactory {
    public World createWorld() {
        try {
            return new World(
                    createDefaultGravity(),
                    createDefaultAllowSleep()
            );
        } catch (Exception e) {
            throw new WorldCreateException(e);
        }
    }

    private Vector2 createDefaultGravity() {
        return new Vector2(
                Float.valueOf(WorldProperty.WorldGravityX.getDefaultValue()),
                Float.valueOf(WorldProperty.WorldGravityX.getDefaultValue())
        );
    }

    private boolean createDefaultAllowSleep() {
        return Boolean.valueOf(WorldProperty.WorldAllowSleep.getDefaultValue());
    }
}
