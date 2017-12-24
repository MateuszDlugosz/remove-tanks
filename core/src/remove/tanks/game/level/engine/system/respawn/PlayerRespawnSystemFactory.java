package remove.tanks.game.level.engine.system.respawn;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnSystemFactory
        implements RegistrableEntitySystemFactory<PlayerRespawnSystem, PlayerRespawnSystemPrototype>
{
    @Override
    public PlayerRespawnSystem createEntitySystem(PlayerRespawnSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new PlayerRespawnSystem(
                    prototype.getPriority(),
                    createTimer(prototype.getRespawnTime()),
                    resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                    resourceRegistry.getResource(LevelResource.EntityPrototypeRepository.toString(),
                            EntityPrototypeRepository.class).getPrototype(prototype.getPrototypeCode())
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    @Override
    public Class<PlayerRespawnSystemPrototype> getFactoryType() {
        return PlayerRespawnSystemPrototype.class;
    }
}
