package remove.tanks.game.physics.shape;

import remove.tanks.game.utility.Prefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public abstract class ShapePrefab extends Prefab {
    public abstract PositionPrefab getPositionPrefab();
}
