package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootComponentFactory implements SubComponentFactory<AutoShootComponent, AutoShootComponentPrefab> {
    @Override
    public AutoShootComponent createComponent(AutoShootComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AutoShootComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<AutoShootComponentPrefab> getFactoryType() {
        return AutoShootComponentPrefab.class;
    }
}