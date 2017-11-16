package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponentFactory
        implements RegistrableComponentFactory<TriggerComponent, TriggerComponentPrototype>
{
    @Override
    public TriggerComponent createComponent(TriggerComponentPrototype prototype, Level level, Entity entity) {
        return new TriggerComponent(prototype.getLetter());
    }

    @Override
    public Class<TriggerComponentPrototype> getFactoryType() {
        return TriggerComponentPrototype.class;
    }
}
