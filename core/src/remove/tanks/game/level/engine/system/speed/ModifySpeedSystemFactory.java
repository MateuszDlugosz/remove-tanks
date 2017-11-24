package remove.tanks.game.level.engine.system.speed;

import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ModifySpeedSystemFactory
        implements RegistrableEntitySystemFactory<ModifySpeedSystem, ModifySpeedSystemPrototype>
{
    @Override
    public ModifySpeedSystem createEntitySystem(ModifySpeedSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new ModifySpeedSystem(prototype.getPriority());
    }

    @Override
    public Class<ModifySpeedSystemPrototype> getFactoryType() {
        return ModifySpeedSystemPrototype.class;
    }
}
