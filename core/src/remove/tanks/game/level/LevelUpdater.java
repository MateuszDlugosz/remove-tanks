package remove.tanks.game.level;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.input.InputMapper;

/**
 * @author Mateusz Długosz
 */
public final class LevelUpdater {
    public void updateLevel(float deltaTime, Level level) {
        level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .update(deltaTime);
        level.getResourceRegistry().getResource(LevelResource.InputMapper.toString(), InputMapper.class)
                .reset();
    }
}
