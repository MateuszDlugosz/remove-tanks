package remove.tanks.game.level.engine.system.lifecycle;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeSystemFactory implements SubEntitySystemFactory<LifetimeSystem, LifetimeSystemPrefab> {
    @Override
    public LifetimeSystem createEntitySystem(LifetimeSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new LifetimeSystem(prefab.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<LifetimeSystemPrefab> getFactoryType() {
        return LifetimeSystemPrefab.class;
    }
}
