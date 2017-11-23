package remove.tanks.game.level.engine.system.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.graphic.view.updater.ViewUpdater;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.graphic.GraphicsComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdateSystem extends IteratingSystem {
    private final ViewUpdater viewUpdater;

    public ViewUpdateSystem(int priority, ViewUpdater viewUpdater) {
        super(EntityFamily.RenderableFamily.getFamily(), priority);
        this.viewUpdater = viewUpdater;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        GraphicsComponent.MAPPER.get(entity).getView(
                StateComponent.MAPPER.get(entity).getState().toString() +
                        DirectionComponent.MAPPER.get(entity).getDirection().toString()
        ).ifPresent(v -> viewUpdater.updateView(v, deltaTime));
    }
}
