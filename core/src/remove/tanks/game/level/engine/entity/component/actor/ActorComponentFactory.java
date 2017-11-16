package remove.tanks.game.level.engine.entity.component.actor;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class ActorComponentFactory
        implements RegistrableComponentFactory<ActorComponent, ActorComponentPrototype>
{
    @Override
    public ActorComponent createComponent(ActorComponentPrototype prototype, Level level, Entity entity) {
        return new ActorComponent();
    }

    @Override
    public Class<ActorComponentPrototype> getFactoryType() {
        return ActorComponentPrototype.class;
    }
}
