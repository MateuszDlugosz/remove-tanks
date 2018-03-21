package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class CreateComponentFactory implements SubComponentFactory<CreateComponent, CreateComponentPrefab> {
    @Override
    public CreateComponent createComponent(CreateComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return CreateComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<CreateComponentPrefab> getFactoryType() {
        return CreateComponentPrefab.class;
    }
}
