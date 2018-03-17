package remove.tanks.game.level.engine.entity.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubComponentFactory<T extends Component, U extends ComponentPrefab> {
    T createComponent(U prefab, Entity entity, ResourceRegistry registry);
    Class<U> getFactoryType();
}
