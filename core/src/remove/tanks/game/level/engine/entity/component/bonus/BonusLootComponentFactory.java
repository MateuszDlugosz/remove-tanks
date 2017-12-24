package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootComponentFactory
        implements RegistrableComponentFactory<BonusLootComponent, BonusLootComponentPrototype>
{
    @Override
    public BonusLootComponent createComponent(BonusLootComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new BonusLootComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<BonusLootComponentPrototype> getFactoryType() {
        return BonusLootComponentPrototype.class;
    }
}
