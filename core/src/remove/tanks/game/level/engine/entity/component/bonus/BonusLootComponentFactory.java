package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootComponentFactory
        implements RegistrableComponentFactory<BonusLootComponent, BonusLootComponentPrototype>
{
    @Override
    public BonusLootComponent createComponent(BonusLootComponentPrototype prototype, Level level, Entity entity) {
        return new BonusLootComponent();
    }

    @Override
    public Class<BonusLootComponentPrototype> getFactoryType() {
        return BonusLootComponentPrototype.class;
    }
}
