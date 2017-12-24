package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class HighlightOnHitComponentFactory
        implements RegistrableComponentFactory<HighlightOnHitComponent, HighlightOnHitComponentPrototype>
{
    @Override
    public HighlightOnHitComponent createComponent(HighlightOnHitComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new HighlightOnHitComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<HighlightOnHitComponentPrototype> getFactoryType() {
        return HighlightOnHitComponentPrototype.class;
    }
}
