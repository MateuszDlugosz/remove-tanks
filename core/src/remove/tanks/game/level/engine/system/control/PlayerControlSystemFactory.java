package remove.tanks.game.level.engine.system.control;

import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.input.InputMapper;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlSystemFactory
        implements RegistrableEntitySystemFactory<PlayerControlSystem, PlayerControlSystemPrototype>
{
    @Override
    public PlayerControlSystem createEntitySystem(PlayerControlSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new PlayerControlSystem(
                    prototype.getPriority(),
                    resourceRegistry.getResource(LevelResource.InputMapper.toString(), InputMapper.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<PlayerControlSystemPrototype> getFactoryType() {
        return PlayerControlSystemPrototype.class;
    }
}
