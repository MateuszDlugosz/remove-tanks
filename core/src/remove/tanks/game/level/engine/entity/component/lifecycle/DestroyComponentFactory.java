package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyComponentFactory implements SubComponentFactory<DestroyComponent, DestroyComponentPrefab> {
    @Override
    public DestroyComponent createComponent(DestroyComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return DestroyComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyComponentPrefab> getFactoryType() {
        return DestroyComponentPrefab.class;
    }
}
