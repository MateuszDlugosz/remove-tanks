package remove.tanks.game.level.engine.system.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.level.engine.system.hud.stages.HudStage;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class HudRenderSystem extends EntitySystem {
    private final HudStage hudStage;
    private final SpriteBatch spriteBatch;
    private final ResourceRegistry resourceRegistry;

    public HudRenderSystem(
            int priority,
            HudStage hudStage,
            SpriteBatch spriteBatch,
            ResourceRegistry resourceRegistry
    ) {
        super(priority);
        this.hudStage = hudStage;
        this.spriteBatch = spriteBatch;
        this.resourceRegistry =resourceRegistry;
    }

    @Override
    public void update(float deltaTime) {
        hudStage.update(deltaTime, resourceRegistry);
        hudStage.getStage().getCamera().update();
        spriteBatch.setProjectionMatrix(hudStage.getStage().getCamera().combined);
        hudStage.getStage().act(deltaTime);
        hudStage.getStage().draw();
    }
}
