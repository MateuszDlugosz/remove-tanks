package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionLayerComponentFactory
        implements RegistrableComponentFactory<ExplosionLayerComponent, ExplosionLayerComponentPrototype>
{
    @Override
    public ExplosionLayerComponent createComponent(ExplosionLayerComponentPrototype prototype, Level level, Entity entity) {
        return new ExplosionLayerComponent();
    }

    @Override
    public Class<ExplosionLayerComponentPrototype> getFactoryType() {
        return ExplosionLayerComponentPrototype.class;
    }
}
