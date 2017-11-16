package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactComponentFactory
        implements RegistrableComponentFactory<DestroyOnContactComponent, DestroyOnContactComponentPrototype>
{
    @Override
    public DestroyOnContactComponent createComponent(DestroyOnContactComponentPrototype prototype, Level level, Entity entity) {
        return new DestroyOnContactComponent(null);
    }

    @Override
    public Class<DestroyOnContactComponentPrototype> getFactoryType() {
        return DestroyOnContactComponentPrototype.class;
    }
}
