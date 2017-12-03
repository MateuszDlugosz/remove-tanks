package remove.tanks.game.level.engine.listener.point;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.point.PointsComponent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.level.event.property.ModifyPropertyEvent;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class PointsListener extends ExtendedEntityListener {
    private final EventBus eventBus;
    private final Properties properties;

    public PointsListener(int priority, Engine engine, EventBus eventBus, Properties properties) {
        super(priority, EntityFamily.PointsFamily.getFamily(), engine);
        this.eventBus = eventBus;
        this.properties = properties;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        int pointsValue = properties.getInt(LevelProperty.LevelPoints.getName()) +
                PointsComponent.MAPPER.get(entity).getPoints() *
                properties.getInt(LevelProperty.LevelPointsMultiplier.getName());
        eventBus.post(new ModifyPropertyEvent(
                LevelProperty.LevelPoints,
                String.valueOf(pointsValue)
        ));
    }
}
