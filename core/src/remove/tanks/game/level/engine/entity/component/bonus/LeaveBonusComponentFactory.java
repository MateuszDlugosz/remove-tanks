package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusComponentFactory implements SubComponentFactory<LeaveBonusComponent, LeaveBonusComponentPrefab> {
    @Override
    public LeaveBonusComponent createComponent(LeaveBonusComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new LeaveBonusComponent(prefab.getChanceModifier());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<LeaveBonusComponentPrefab> getFactoryType() {
        return LeaveBonusComponentPrefab.class;
    }
}
