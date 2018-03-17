package remove.tanks.game.level.engine.entity.component.move;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveComponentFactory implements SubComponentFactory<AutoMoveComponent, AutoMoveComponentPrefab> {
    @Override
    public AutoMoveComponent createComponent(AutoMoveComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AutoMoveComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<AutoMoveComponentPrefab> getFactoryType() {
        return AutoMoveComponentPrefab.class;
    }
}
