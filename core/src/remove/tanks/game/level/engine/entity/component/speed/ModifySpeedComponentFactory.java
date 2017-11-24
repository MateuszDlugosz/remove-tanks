package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class ModifySpeedComponentFactory
        implements RegistrableComponentFactory<ModifySpeedComponent, ModifySpeedComponentPrototype>
{
    @Override
    public ModifySpeedComponent createComponent(ModifySpeedComponentPrototype prototype, Level level, Entity entity) {
        return new ModifySpeedComponent(prototype.getValue());
    }

    @Override
    public Class<ModifySpeedComponentPrototype> getFactoryType() {
        return ModifySpeedComponentPrototype.class;
    }
}
