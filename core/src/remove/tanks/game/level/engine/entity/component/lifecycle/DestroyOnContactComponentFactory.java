package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

public final class DestroyOnContactComponentFactory implements SubComponentFactory<DestroyOnContactComponent, DestroyOnContactComponentPrefab> {
    @Override
    public DestroyOnContactComponent createComponent(DestroyOnContactComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new DestroyOnContactComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyOnContactComponentPrefab> getFactoryType() {
        return DestroyOnContactComponentPrefab.class;
    }
}
