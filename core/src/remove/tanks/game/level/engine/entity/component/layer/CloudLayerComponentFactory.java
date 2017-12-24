package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerComponentFactory
        implements RegistrableComponentFactory<CloudLayerComponent, CloudLayerComponentPrototype>
{
    @Override
    public CloudLayerComponent createComponent(CloudLayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new CloudLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<CloudLayerComponentPrototype> getFactoryType() {
        return CloudLayerComponentPrototype.class;
    }
}
