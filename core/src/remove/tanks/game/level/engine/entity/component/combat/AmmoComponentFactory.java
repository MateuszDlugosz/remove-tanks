package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AmmoComponentFactory implements SubComponentFactory<AmmoComponent, AmmoComponentPrefab> {
    @Override
    public AmmoComponent createComponent(AmmoComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AmmoComponent(
                    prefab.getCurrentLevel(),
                    prefab.getMaxLevel(),
                    prefab.getPrefabCodes()
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<AmmoComponentPrefab> getFactoryType() {
        return AmmoComponentPrefab.class;
    }
}
