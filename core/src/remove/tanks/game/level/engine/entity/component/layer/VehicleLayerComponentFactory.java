package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerComponentFactory
        implements RegistrableComponentFactory<VehicleLayerComponent, VehicleLayerComponentPrototype>
{
    @Override
    public VehicleLayerComponent createComponent(VehicleLayerComponentPrototype prototype, Level level, Entity entity) {
        return new VehicleLayerComponent();
    }

    @Override
    public Class<VehicleLayerComponentPrototype> getFactoryType() {
        return VehicleLayerComponentPrototype.class;
    }
}
