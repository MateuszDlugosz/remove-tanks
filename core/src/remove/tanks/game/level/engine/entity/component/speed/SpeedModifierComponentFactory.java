package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class SpeedModifierComponentFactory
        implements RegistrableComponentFactory<SpeedModifierComponent, SpeedModifierComponentPrototype>
{
    @Override
    public SpeedModifierComponent createComponent(SpeedModifierComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new SpeedModifierComponent(
                    prototype.getValue()
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<SpeedModifierComponentPrototype> getFactoryType() {
        return SpeedModifierComponentPrototype.class;
    }
}
