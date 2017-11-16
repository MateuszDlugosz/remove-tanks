package remove.tanks.game.level.engine.system.move;

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
        return new AutoMoveSystem(prototype.getPriority());
    }

    @Override
    public Class<AutoMoveSystemPrototype> getFactoryType() {
        return AutoMoveSystemPrototype.class;
    }
}
