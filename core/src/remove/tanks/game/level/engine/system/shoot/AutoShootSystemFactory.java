package remove.tanks.game.level.engine.system.shoot;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootSystemFactory
        implements RegistrableEntitySystemFactory<AutoShootSystem, AutoShootSystemPrototype>
{
    @Override
    public AutoShootSystem createEntitySystem(AutoShootSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new AutoShootSystem(
                    prototype.getPriority(),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                    resourceRegistry.getResource(LevelResource.EntityPrototypeRepository.toString(), EntityPrototypeRepository.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<AutoShootSystemPrototype> getFactoryType() {
        return AutoShootSystemPrototype.class;
    }
}
