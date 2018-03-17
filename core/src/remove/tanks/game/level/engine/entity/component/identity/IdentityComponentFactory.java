package remove.tanks.game.level.engine.entity.component.identity;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class IdentityComponentFactory implements SubComponentFactory<IdentityComponent, IdentityComponentPrefab> {
    @Override
    public IdentityComponent createComponent(IdentityComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new IdentityComponent(prefab.getId());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<IdentityComponentPrefab> getFactoryType() {
        return IdentityComponentPrefab.class;
    }
}
