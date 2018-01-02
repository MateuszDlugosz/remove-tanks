package remove.tanks.game.level.engine.system.time;

import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeUpdateSystemFactory
        implements RegistrableEntitySystemFactory<TimeUpdateSystem, TimeUpdateSystemPrototype>
{
    @Override
    public TimeUpdateSystem createEntitySystem(TimeUpdateSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new TimeUpdateSystem(
                    prototype.getPriority(),
                    resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<TimeUpdateSystemPrototype> getFactoryType() {
        return TimeUpdateSystemPrototype.class;
    }
}
