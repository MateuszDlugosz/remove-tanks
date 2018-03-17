package remove.tanks.game.level.engine.system.move;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveSystemFactory implements SubEntitySystemFactory<AutoMoveSystem, AutoMoveSystemPrefab> {
    @Override
    public AutoMoveSystem createEntitySystem(AutoMoveSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new AutoMoveSystem(prefab.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<AutoMoveSystemPrefab> getFactoryType() {
        return AutoMoveSystemPrefab.class;
    }
}
