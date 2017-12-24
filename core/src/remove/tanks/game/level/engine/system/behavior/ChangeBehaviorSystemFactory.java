package remove.tanks.game.level.engine.system.behavior;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorSystemFactory
        implements RegistrableEntitySystemFactory<ChangeBehaviorSystem, ChangeBehaviorSystemPrototype>
{
    @Override
    public ChangeBehaviorSystem createEntitySystem(ChangeBehaviorSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new ChangeBehaviorSystem(prototype.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<ChangeBehaviorSystemPrototype> getFactoryType() {
        return ChangeBehaviorSystemPrototype.class;
    }
}
