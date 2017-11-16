package remove.tanks.game.level.engine.system.actor;

import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ActorDirectionControlSystemFactory
        implements RegistrableEntitySystemFactory<ActorDirectionControlSystem, ActorDirectionControlSystemPrototype>
{
    @Override
    public ActorDirectionControlSystem createEntitySystem(ActorDirectionControlSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new ActorDirectionControlSystem(prototype.getPriority());
    }

    @Override
    public Class<ActorDirectionControlSystemPrototype> getFactoryType() {
        return ActorDirectionControlSystemPrototype.class;
    }
}
