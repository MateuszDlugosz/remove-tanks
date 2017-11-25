package remove.tanks.game.level.engine.entity.component.id;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class IdentityComponentFactory
        implements RegistrableComponentFactory<IdentityComponent, IdentityComponentPrototype>
{
    @Override
    public IdentityComponent createComponent(IdentityComponentPrototype prototype, Level level, Entity entity) {
        return new IdentityComponent(prototype.getId());
    }

    @Override
    public Class<IdentityComponentPrototype> getFactoryType() {
        return IdentityComponentPrototype.class;
    }
}
