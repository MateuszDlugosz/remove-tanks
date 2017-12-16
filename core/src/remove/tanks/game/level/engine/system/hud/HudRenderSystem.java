package remove.tanks.game.level.engine.system.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.level.engine.system.hud.stages.HudStage;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class HudRenderSystem extends EntitySystem {
    private final HudStage hudStage;
    private final SpriteBatch spriteBatch;
    private final Properties properties;

    public HudRenderSystem(
            int priority,
            HudStage hudStage,
            SpriteBatch spriteBatch,
            Properties properties
    ) {
        super(priority);
        this.hudStage = hudStage;
        this.spriteBatch = spriteBatch;
        this.properties = properties;
    }

    @Override
    public void update(float deltaTime) {
        hudStage.updateLabelValues(properties);
        hudStage.getStage().getCamera().update();
        spriteBatch.setProjectionMatrix(hudStage.getStage().getCamera().combined);
        hudStage.getStage().act(deltaTime);
        hudStage.getStage().draw();
    }
}
