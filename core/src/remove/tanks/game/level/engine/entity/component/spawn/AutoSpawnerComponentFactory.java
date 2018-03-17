package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerComponentFactory implements SubComponentFactory<AutoSpawnerComponent, AutoSpawnerComponentPrefab> {
    @Override
    public AutoSpawnerComponent createComponent(AutoSpawnerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AutoSpawnerComponent(prefab.getId());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<AutoSpawnerComponentPrefab> getFactoryType() {
        return AutoSpawnerComponentPrefab.class;
    }
}
