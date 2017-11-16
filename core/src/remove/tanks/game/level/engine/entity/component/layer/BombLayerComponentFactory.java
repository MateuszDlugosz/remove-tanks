package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerComponentFactory
        implements RegistrableComponentFactory<BombLayerComponent, BombLayerComponentPrototype>
{
    @Override
    public BombLayerComponent createComponent(BombLayerComponentPrototype prototype, Level level, Entity entity) {
        return new BombLayerComponent();
    }

    @Override
    public Class<BombLayerComponentPrototype> getFactoryType() {
        return BombLayerComponentPrototype.class;
    }
}
