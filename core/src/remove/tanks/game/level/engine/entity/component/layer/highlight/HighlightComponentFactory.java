package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class HighlightComponentFactory
        implements RegistrableComponentFactory<HighlightComponent, HighlightComponentPrototype>
{
    @Override
    public HighlightComponent createComponent(HighlightComponentPrototype prototype, Level level, Entity entity) {
        return new HighlightComponent(new Timer(prototype.getHighlightTime()));
    }

    @Override
    public Class<HighlightComponentPrototype> getFactoryType() {
        return HighlightComponentPrototype.class;
    }
}
