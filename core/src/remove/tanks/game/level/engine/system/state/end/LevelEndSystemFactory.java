package remove.tanks.game.level.engine.system.state.end;

import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LevelEndSystemFactory
        implements RegistrableEntitySystemFactory<LevelEndSystem, LevelEndSystemPrototype>
{
    @Override
    public LevelEndSystem createEntitySystem(LevelEndSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new LevelEndSystem(
                prototype.getPriority(),
                new Timer(prototype.getEndTime()),
                resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class)
        );
    }

    @Override
    public Class<LevelEndSystemPrototype> getFactoryType() {
        return LevelEndSystemPrototype.class;
    }
}
