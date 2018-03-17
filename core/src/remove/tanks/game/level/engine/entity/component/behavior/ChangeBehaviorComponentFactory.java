package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorComponentFactory implements SubComponentFactory<ChangeBehaviorComponent, ChangeBehaviorComponentPrefab> {
    private final ComponentFactory componentFactory;

    public ChangeBehaviorComponentFactory(ComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    @Override
    public ChangeBehaviorComponent createComponent(ChangeBehaviorComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ChangeBehaviorComponent(createComponents(prefab.getComponentPrefabs(), entity, registry));
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private List<Component> createComponents(List<ComponentPrefab> prefabs, Entity entity, ResourceRegistry registry) {
        return componentFactory.createComponents(prefabs, entity, registry);
    }

    @Override
    public Class<ChangeBehaviorComponentPrefab> getFactoryType() {
        return ChangeBehaviorComponentPrefab.class;
    }
}
