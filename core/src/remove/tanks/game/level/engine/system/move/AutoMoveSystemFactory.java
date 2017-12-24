package remove.tanks.game.level.engine.system.move;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveSystemFactory
        implements RegistrableEntitySystemFactory<AutoMoveSystem, AutoMoveSystemPrototype>
{
    @Override
    public AutoMoveSystem createEntitySystem(AutoMoveSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new AutoMoveSystem(prototype.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<AutoMoveSystemPrototype> getFactoryType() {
        return AutoMoveSystemPrototype.class;
    }
}
