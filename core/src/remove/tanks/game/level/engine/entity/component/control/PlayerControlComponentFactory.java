package remove.tanks.game.level.engine.entity.component.control;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlComponentFactory
        implements RegistrableComponentFactory<PlayerControlComponent, PlayerControlComponentPrototype>
{
    @Override
    public PlayerControlComponent createComponent(PlayerControlComponentPrototype prototype, Level level, Entity entity) {
        return new PlayerControlComponent(prototype.getShootDelay(), new Timer(prototype.getShootDelay()));
    }

    @Override
    public Class<PlayerControlComponentPrototype> getFactoryType() {
        return PlayerControlComponentPrototype.class;
    }
}
