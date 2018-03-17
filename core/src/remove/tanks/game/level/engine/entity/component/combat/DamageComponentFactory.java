package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DamageComponentFactory implements SubComponentFactory<DamageComponent, DamageComponentPrefab> {
    @Override
    public DamageComponent createComponent(DamageComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new DamageComponent(prefab.getDamage());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<DamageComponentPrefab> getFactoryType() {
        return DamageComponentPrefab.class;
    }
}
