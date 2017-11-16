package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class DestroyComponentFactory
        implements RegistrableComponentFactory<DestroyComponent, DestroyComponentPrototype>
{
    @Override
    public DestroyComponent createComponent(DestroyComponentPrototype prototype, Level level, Entity entity) {
        return new DestroyComponent();
    }

    @Override
    public Class<DestroyComponentPrototype> getFactoryType() {
        return DestroyComponentPrototype.class;
    }
}
