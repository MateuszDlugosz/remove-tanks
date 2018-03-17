package remove.tanks.game.level.engine.system.render.view;

import remove.tanks.game.level.engine.system.EntitySystemPrefab;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractLayerRenderSystemPrefab extends EntitySystemPrefab {
    public AbstractLayerRenderSystemPrefab(int priority) {
        super(priority);
    }

    @Override
    public abstract String toString();
}
