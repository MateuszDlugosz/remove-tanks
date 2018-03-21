package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactLostComponentFactory
        implements SubComponentFactory<DestroyOnContactLostComponent, DestroyOnContactLostComponentPrefab>
{
    @Override
    public DestroyOnContactLostComponent createComponent(DestroyOnContactLostComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return DestroyOnContactLostComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyOnContactLostComponentPrefab> getFactoryType() {
        return DestroyOnContactLostComponentPrefab.class;
    }
}
