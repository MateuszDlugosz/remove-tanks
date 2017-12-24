package remove.tanks.game.level.engine.entity.component.health;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponentFactory
        implements RegistrableComponentFactory<HealthComponent, HealthComponentPrototype>
{
    @Override
    public HealthComponent createComponent(HealthComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new HealthComponent(
                    prototype.getHealth(),
                    prototype.getMaxHealth()
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<HealthComponentPrototype> getFactoryType() {
        return HealthComponentPrototype.class;
    }
}
