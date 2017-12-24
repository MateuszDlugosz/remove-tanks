package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

import java.util.List;

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
        try {
            return new ChangeBehaviorComponent(
                    createComponents(prototype.getComponentPrototypes(), level, entity)
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private List<Component> createComponents(List<ComponentPrototype> prototypes, Level level, Entity entity) {
        return componentFactory.createComponents(prototypes, level, entity);
    }

    @Override
    public Class<ChangeBehaviorComponentPrototype> getFactoryType() {
        return ChangeBehaviorComponentPrototype.class;
    }
}
