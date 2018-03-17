package remove.tanks.game.physics.light;

import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public abstract class LightPrefab extends Prefab {
    public abstract ColorPrefab getColorPrefab();
    public abstract boolean getXRay();
}
