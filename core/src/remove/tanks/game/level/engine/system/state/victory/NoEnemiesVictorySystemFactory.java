package remove.tanks.game.level.engine.system.state.victory;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class NoEnemiesVictorySystemFactory
        implements RegistrableEntitySystemFactory<NoEnemiesVictorySystem, NoEnemiesVictorySystemPrototype>
{
    @Override
    public NoEnemiesVictorySystem createEntitySystem(NoEnemiesVictorySystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new NoEnemiesVictorySystem(
                    prototype.getPriority(),
                    resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                    createTimer(prototype.getDelay())
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    @Override
    public Class<NoEnemiesVictorySystemPrototype> getFactoryType() {
        return NoEnemiesVictorySystemPrototype.class;
    }
}
