package remove.tanks.game.level.engine.system.layer;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.graphic.GraphicsComponent;
import remove.tanks.game.level.engine.entity.component.layer.highlight.HighlightComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;

/**
 * @author Mateusz Długosz
 */
public abstract class LayerRenderSystem extends IteratingSystem {
    private final ViewRenderer viewRenderer;
    private final SpriteBatch spriteBatch;
    private final Effect highlightEffect;

    public LayerRenderSystem(
            Family family,
            int priority,
            ViewRenderer viewRenderer,
            SpriteBatch spriteBatch,
            Effect highlightEffect
    ) {
        super(family, priority);
        this.viewRenderer = viewRenderer;
        this.spriteBatch = spriteBatch;
        this.highlightEffect = highlightEffect;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        StateComponent sc = StateComponent.MAPPER.get(entity);
        DirectionComponent dc = DirectionComponent.MAPPER.get(entity);
        String viedId = sc.getState().toString() + dc.getDirection().toString();
        PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);

        GraphicsComponent.MAPPER.get(entity).getView(viedId).ifPresent(v -> {
                HighlightComponent hc = HighlightComponent.MAPPER.get(entity);
                if (hc != null) {
                    highlightEffect.begin(spriteBatch);
                    viewRenderer.render(v, spriteBatch, pc.getPosition(), pc.getBody().getAngle());
                    highlightEffect.end(spriteBatch);
                    hc.getTimer().update(deltaTime);
                    if (hc.getTimer().isComplete()) {
                        entity.remove(HighlightComponent.class);
                    }
                } else {
                    viewRenderer.render(v, spriteBatch, pc.getPosition(), pc.getBody().getAngle());
                }
        });
    }
}
