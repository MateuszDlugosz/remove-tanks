package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class EnemyComponentFactory implements SubComponentFactory<EnemyComponent, EnemyComponentPrefab> {
    @Override
    public EnemyComponent createComponent(EnemyComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return EnemyComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<EnemyComponentPrefab> getFactoryType() {
        return EnemyComponentPrefab.class;
    }
}
