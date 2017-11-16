package remove.tanks.game.level.engine.entity.component.respawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnComponentFactory
        implements RegistrableComponentFactory<PlayerRespawnComponent, PlayerRespawnComponentPrototype>
{
    @Override
    public PlayerRespawnComponent createComponent(PlayerRespawnComponentPrototype prototype, Level level, Entity entity) {
        return new PlayerRespawnComponent();
    }

    @Override
    public Class<PlayerRespawnComponentPrototype> getFactoryType() {
        return PlayerRespawnComponentPrototype.class;
    }
}
