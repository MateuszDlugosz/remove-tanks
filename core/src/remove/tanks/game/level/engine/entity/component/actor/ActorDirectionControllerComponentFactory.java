package remove.tanks.game.level.engine.entity.component.actor;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class ActorDirectionControllerComponentFactory
        implements RegistrableComponentFactory<ActorDirectionControllerComponent, ActorDirectionControllerComponentPrototype>
{
    @Override
    public ActorDirectionControllerComponent createComponent(ActorDirectionControllerComponentPrototype prototype, Level level, Entity entity) {
        return new ActorDirectionControllerComponent(prototype.getNewDirection());
    }

    @Override
    public Class<ActorDirectionControllerComponentPrototype> getFactoryType() {
        return ActorDirectionControllerComponentPrototype.class;
    }
}
