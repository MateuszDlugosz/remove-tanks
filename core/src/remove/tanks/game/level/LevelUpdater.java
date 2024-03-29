package remove.tanks.game.level;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class LevelUpdater {
    public void updateLevel(float deltaTime, Level level) {
        level.getResourceRegistry().getResource(ResourceType.EngineResource, Engine.class).update(deltaTime);
        level.getResourceRegistry().getResource(ResourceType.InputMapperResource, InputMapper.class).keyUpAll();
    }
}
