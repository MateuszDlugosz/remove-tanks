package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class SpeedComponentFactory
        implements RegistrableComponentFactory<SpeedComponent, SpeedComponentPrototype>
{
    @Override
    public SpeedComponent createComponent(SpeedComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new SpeedComponent(
                    prototype.getSpeed()
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<SpeedComponentPrototype> getFactoryType() {
        return SpeedComponentPrototype.class;
    }
}
