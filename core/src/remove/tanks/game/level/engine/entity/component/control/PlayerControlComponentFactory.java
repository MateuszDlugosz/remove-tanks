package remove.tanks.game.level.engine.entity.component.control;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
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
        try {
            return new PlayerControlComponent(
                    prototype.getShootDelay(),
                    createTimer(prototype.getShootDelay())
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    @Override
    public Class<PlayerControlComponentPrototype> getFactoryType() {
        return PlayerControlComponentPrototype.class;
    }
}
