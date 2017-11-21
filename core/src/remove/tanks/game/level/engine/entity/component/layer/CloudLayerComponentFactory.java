package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerComponentFactory
        implements RegistrableComponentFactory<CloudLayerComponent, CloudLayerComponentPrototype>
{
    @Override
    public CloudLayerComponent createComponent(CloudLayerComponentPrototype prototype, Level level, Entity entity) {
        return new CloudLayerComponent();
    }

    @Override
    public Class<CloudLayerComponentPrototype> getFactoryType() {
        return CloudLayerComponentPrototype.class;
    }
}
