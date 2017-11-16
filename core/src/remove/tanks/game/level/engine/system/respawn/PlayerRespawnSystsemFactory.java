package remove.tanks.game.level.engine.system.respawn;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnSystsemFactory
        implements RegistrableEntitySystemFactory<PlayerRespawnSystem, PlayerRespawnSystemPrototype>
{
    @Override
    public PlayerRespawnSystem createEntitySystem(PlayerRespawnSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new PlayerRespawnSystem(
                new Timer(prototype.getRespawnTime()),
                resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                resourceRegistry.getResource(LevelResource.EntityPrototypeRepository.toString(),
                        EntityPrototypeRepository.class).getPrototype(prototype.getPrototypeCode()),
                prototype.getPriority()
        );
    }

    @Override
    public Class<PlayerRespawnSystemPrototype> getFactoryType() {
        return PlayerRespawnSystemPrototype.class;
    }
}
