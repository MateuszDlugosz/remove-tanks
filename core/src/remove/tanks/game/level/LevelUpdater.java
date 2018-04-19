package remove.tanks.game.level;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class LevelUpdater {
    public void updateLevel(float deltaTime, Level level) {
        level.getResourceRegistry().getResource(ResourceType.EngineResource, Engine.class)
                .update(
                        level.getResourceRegistry().getResource(ResourceType.TimeScaleResource, Scale.class)
                                .scaleValue(deltaTime)
                );
        level.getResourceRegistry().getResource(ResourceType.InputMapperResource, InputMapper.class).keyUpAll();
    }
}
