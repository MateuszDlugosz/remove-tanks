package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class PlayerComponentFactory
        implements RegistrableComponentFactory<PlayerComponent, PlayerComponentPrototype>
{
    @Override
    public PlayerComponent createComponent(PlayerComponentPrototype prototype, Level level, Entity entity) {
        return new PlayerComponent();
    }

    @Override
    public Class<PlayerComponentPrototype> getFactoryType() {
        return PlayerComponentPrototype.class;
    }
}
