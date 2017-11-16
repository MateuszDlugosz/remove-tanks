package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class HighlightOnHitComponentFactory
        implements RegistrableComponentFactory<HighlightOnHitComponent, HighlightOnHitComponentPrototype>
{
    @Override
    public HighlightOnHitComponent createComponent(HighlightOnHitComponentPrototype prototype, Level level, Entity entity) {
        return new HighlightOnHitComponent();
    }

    @Override
    public Class<HighlightOnHitComponentPrototype> getFactoryType() {
        return HighlightOnHitComponentPrototype.class;
    }
}
