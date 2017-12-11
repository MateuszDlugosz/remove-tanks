package remove.tanks.game.level.engine.system.state.defeat;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class NoLifesDefeatSystemFactory
        implements RegistrableEntitySystemFactory<NoLifesDefeatSystem, NoLifesDefeatSystemPrototype>
{
    @Override
    public NoLifesDefeatSystem createEntitySystem(NoLifesDefeatSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new NoLifesDefeatSystem(
                prototype.getPriority(),
                resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                new Timer(prototype.getDelay())
        );
    }

    @Override
    public Class<NoLifesDefeatSystemPrototype> getFactoryType() {
        return NoLifesDefeatSystemPrototype.class;
    }
}
