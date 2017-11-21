package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class BomberLayerComponentFactory
        implements RegistrableComponentFactory<BomberLayerComponent, BomberLayerComponentPrototype>
{
    @Override
    public BomberLayerComponent createComponent(BomberLayerComponentPrototype prototype, Level level, Entity entity) {
        return new BomberLayerComponent();
    }

    @Override
    public Class<BomberLayerComponentPrototype> getFactoryType() {
        return BomberLayerComponentPrototype.class;
    }
}
