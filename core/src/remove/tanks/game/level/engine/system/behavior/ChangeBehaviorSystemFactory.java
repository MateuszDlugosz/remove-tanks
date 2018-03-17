package remove.tanks.game.level.engine.system.behavior;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorSystemFactory implements SubEntitySystemFactory<ChangeBehaviorSystem, ChangeBehaviorSystemPrefab> {
    @Override
    public ChangeBehaviorSystem createEntitySystem(ChangeBehaviorSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new ChangeBehaviorSystem(prefab.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<ChangeBehaviorSystemPrefab> getFactoryType() {
        return ChangeBehaviorSystemPrefab.class;
    }
}
