package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class BonusComponentFactory
        implements RegistrableComponentFactory<BonusComponent, BonusComponentPrototype>
{
    @Override
    public BonusComponent createComponent(BonusComponentPrototype prototype, Level level, Entity entity) {
        return new BonusComponent(prototype.getBonusType());
    }

    @Override
    public Class<BonusComponentPrototype> getFactoryType() {
        return BonusComponentPrototype.class;
    }
}
