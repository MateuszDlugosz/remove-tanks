package remove.tanks.game.level.engine.entity.component.lifetime;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponentFactory
        implements RegistrableComponentFactory<LifetimeComponent, LifetimeComponentPrototype>
{
    @Override
    public LifetimeComponent createComponent(LifetimeComponentPrototype prototype, Level level, Entity entity) {
        return new LifetimeComponent(new Timer(prototype.getLifetime()));
    }

    @Override
    public Class<LifetimeComponentPrototype> getFactoryType() {
        return LifetimeComponentPrototype.class;
    }
}
