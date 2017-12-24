package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerComponentFactory
        implements RegistrableComponentFactory<BonusLayerComponent, BonusLayerComponentPrototype>
{
    @Override
    public BonusLayerComponent createComponent(BonusLayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new BonusLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<BonusLayerComponentPrototype> getFactoryType() {
        return BonusLayerComponentPrototype.class;
    }
}
