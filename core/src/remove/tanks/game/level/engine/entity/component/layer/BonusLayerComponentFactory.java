package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerComponentFactory
        implements RegistrableComponentFactory<BonusLayerComponent, BonusLayerComponentPrototype>
{
    @Override
    public BonusLayerComponent createComponent(BonusLayerComponentPrototype prototype, Level level, Entity entity) {
        return new BonusLayerComponent();
    }

    @Override
    public Class<BonusLayerComponentPrototype> getFactoryType() {
        return BonusLayerComponentPrototype.class;
    }
}
