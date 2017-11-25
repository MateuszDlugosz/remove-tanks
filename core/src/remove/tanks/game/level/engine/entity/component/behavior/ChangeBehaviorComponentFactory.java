package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorComponentFactory
        implements RegistrableComponentFactory<ChangeBehaviorComponent, ChangeBehaviorComponentPrototype>
{
    private final ComponentFactory componentFactory;

    public ChangeBehaviorComponentFactory(ComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    @Override
    public ChangeBehaviorComponent createComponent(ChangeBehaviorComponentPrototype prototype, Level level, Entity entity) {
        return new ChangeBehaviorComponent(componentFactory.createComponents(prototype.getComponentPrototypes(), level, entity));
    }

    @Override
    public Class<ChangeBehaviorComponentPrototype> getFactoryType() {
        return ChangeBehaviorComponentPrototype.class;
    }
}
