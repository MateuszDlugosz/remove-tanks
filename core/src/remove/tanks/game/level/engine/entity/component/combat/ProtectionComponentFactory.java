package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ProtectionComponentFactory implements SubComponentFactory<ProtectionComponent, ProtectionComponentPrefab> {
    @Override
    public ProtectionComponent createComponent(ProtectionComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return ProtectionComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<ProtectionComponentPrefab> getFactoryType() {
        return ProtectionComponentPrefab.class;
    }
}
