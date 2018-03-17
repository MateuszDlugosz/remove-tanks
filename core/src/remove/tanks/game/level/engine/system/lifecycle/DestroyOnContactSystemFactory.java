package remove.tanks.game.level.engine.system.lifecycle;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

public final class DestroyOnContactSystemFactory implements SubEntitySystemFactory<DestroyOnContactSystem, DestroyOnContactSystemPrefab> {
    @Override
    public DestroyOnContactSystem createEntitySystem(DestroyOnContactSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new DestroyOnContactSystem(prefab.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyOnContactSystemPrefab> getFactoryType() {
        return DestroyOnContactSystemPrefab.class;
    }
}
