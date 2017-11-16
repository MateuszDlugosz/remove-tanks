package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerComponentFactory
        implements RegistrableComponentFactory<GroundLayerComponent, GroundLayerComponentPrototype>
{
    @Override
    public GroundLayerComponent createComponent(GroundLayerComponentPrototype prototype, Level level, Entity entity) {
        return new GroundLayerComponent();
    }

    @Override
    public Class<GroundLayerComponentPrototype> getFactoryType() {
        return GroundLayerComponentPrototype.class;
    }
}
