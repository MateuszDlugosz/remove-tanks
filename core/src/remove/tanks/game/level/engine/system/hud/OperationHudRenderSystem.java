package remove.tanks.game.level.engine.system.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.level.engine.system.hud.stages.OperationHudStage;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class OperationHudRenderSystem extends EntitySystem {
    private final OperationHudStage operationHudStage;
    private final SpriteBatch spriteBatch;
    private final Properties properties;

    public OperationHudRenderSystem(
            int priority,
            OperationHudStage operationHudStage,
            SpriteBatch spriteBatch,
            Properties properties
    ) {
        super(priority);
        this.operationHudStage = operationHudStage;
        this.spriteBatch = spriteBatch;
        this.properties = properties;
    }

    @Override
    public void update(float deltaTime) {
        operationHudStage.updateLabelValues(properties);
        operationHudStage.getStage().getCamera().update();
        spriteBatch.setProjectionMatrix(operationHudStage.getStage().getCamera().combined);
        operationHudStage.getStage().act(deltaTime);
        operationHudStage.getStage().draw();
    }
}
