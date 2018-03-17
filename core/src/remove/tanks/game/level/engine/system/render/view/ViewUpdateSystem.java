package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.graphics.view.updater.ViewUpdater;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.render.ViewComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdateSystem extends IteratingSystem {
    private final ViewUpdater viewUpdater;

    public ViewUpdateSystem(int priority, ViewUpdater viewUpdater) {
        super(EntityFamily.ViewFamily.getFamily(), priority);
        this.viewUpdater = viewUpdater;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ViewComponent.MAPPER.get(entity)
                .getView(extractViewName(entity))
                .ifPresent(v -> viewUpdater.updateView(v, deltaTime));
    }

    private String extractViewName(Entity entity) {
        return StateComponent.MAPPER.get(entity).getState().name()
                + DirectionComponent.MAPPER.get(entity).getDirection().name();
    }
}
