package remove.tanks.game.graphics.view;

import remove.tanks.game.utility.Prefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public abstract class ViewPrefab extends Prefab {
    public abstract String getId();
    public abstract PositionPrefab getPositionPrefab();
}
