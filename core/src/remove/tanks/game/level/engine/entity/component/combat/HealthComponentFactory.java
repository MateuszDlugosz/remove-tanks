package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponentFactory implements SubComponentFactory<HealthComponent, HealthComponentPrefab> {
    @Override
    public HealthComponent createComponent(HealthComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new HealthComponent(
                    prefab.getMaxHealth(),
                    prefab.getHealth()
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<HealthComponentPrefab> getFactoryType() {
        return HealthComponentPrefab.class;
    }
}
