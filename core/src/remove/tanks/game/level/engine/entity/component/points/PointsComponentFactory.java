package remove.tanks.game.level.engine.entity.component.points;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class PointsComponentFactory
        implements RegistrableComponentFactory<PointsComponent, PointsComponentPrototype>
{
    @Override
    public PointsComponent createComponent(PointsComponentPrototype prototype, Level level, Entity entity) {
        return new PointsComponent(prototype.getPoints());
    }

    @Override
    public Class<PointsComponentPrototype> getFactoryType() {
        return PointsComponentPrototype.class;
    }
}
