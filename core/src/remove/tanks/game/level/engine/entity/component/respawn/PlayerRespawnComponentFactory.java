package remove.tanks.game.level.engine.entity.component.respawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnComponentFactory
        implements RegistrableComponentFactory<PlayerRespawnComponent, PlayerRespawnComponentPrototype>
{
    @Override
    public PlayerRespawnComponent createComponent(PlayerRespawnComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new PlayerRespawnComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<PlayerRespawnComponentPrototype> getFactoryType() {
        return PlayerRespawnComponentPrototype.class;
    }
}
