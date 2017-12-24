package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class PlayerComponentFactory
        implements RegistrableComponentFactory<PlayerComponent, PlayerComponentPrototype>
{
    @Override
    public PlayerComponent createComponent(PlayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new PlayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<PlayerComponentPrototype> getFactoryType() {
        return PlayerComponentPrototype.class;
    }
}
