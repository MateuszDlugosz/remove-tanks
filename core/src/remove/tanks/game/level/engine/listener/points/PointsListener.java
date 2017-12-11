package remove.tanks.game.level.engine.listener.points;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.points.PointsComponent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.level.event.points.AddPointsEvent;

/**
 * @author Mateusz Długosz
 */
public final class PointsListener extends ExtendedEntityListener {
    private final EventBus eventBus;

    public PointsListener(int priority, Engine engine, EventBus eventBus) {
        super(priority, EntityFamily.PointsFamily.getFamily(), engine);
        this.eventBus = eventBus;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        eventBus.post(new AddPointsEvent(PointsComponent.MAPPER.get(entity).getPoints()));
    }
}
