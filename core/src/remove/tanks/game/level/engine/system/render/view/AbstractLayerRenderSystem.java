package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.render.ViewComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractLayerRenderSystem extends IteratingSystem {
    private final ViewRenderer viewRenderer;
    private final SpriteBatch spriteBatch;

    public AbstractLayerRenderSystem(RenderLayerEntityFamily family, int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        super(family.getEntityFamily().getFamily(), priority);
        this.viewRenderer = viewRenderer;
        this.spriteBatch = spriteBatch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ViewComponent.MAPPER.get(entity).getView(extractViewName(entity))
                .ifPresent(view -> {
                    PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
                    viewRenderer.render(view, spriteBatch, pc.getPosition(), pc.getBody().getAngle());
                });
    }

    private String extractViewName(Entity entity) {
        return StateComponent.MAPPER.get(entity).getState().name()
                + DirectionComponent.MAPPER.get(entity).getDirection().name();
    }
}
