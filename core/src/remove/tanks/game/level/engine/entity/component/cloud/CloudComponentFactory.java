package remove.tanks.game.level.engine.entity.component.cloud;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class CloudComponentFactory implements SubComponentFactory<CloudComponent, CloudComponentPrefab> {
    @Override
    public CloudComponent createComponent(CloudComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return CloudComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<CloudComponentPrefab> getFactoryType() {
        return CloudComponentPrefab.class;
    }
}
