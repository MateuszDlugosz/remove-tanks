package remove.tanks.game.level.engine.entity.component.lifetime;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponentFactory
        implements RegistrableComponentFactory<LifetimeComponent, LifetimeComponentPrototype>
{
    @Override
    public LifetimeComponent createComponent(LifetimeComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new LifetimeComponent(
                    createTimer(prototype.getLifetime())
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    @Override
    public Class<LifetimeComponentPrototype> getFactoryType() {
        return LifetimeComponentPrototype.class;
    }
}
