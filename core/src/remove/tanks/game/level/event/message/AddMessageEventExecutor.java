package remove.tanks.game.level.event.message;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.hud.HudSystem;
import remove.tanks.game.level.event.RegistrableEventExecutor;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEventExecutor
        implements RegistrableEventExecutor<AddMessageEvent>
{
    @Override
    public void executeEvent(AddMessageEvent event, Level level) {
        Optional.ofNullable(level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .getSystem(HudSystem.class)).ifPresent(s -> s.addMessage(event.getMessage()));
    }

    @Override
    public Class<AddMessageEvent> getExecutorType() {
        return AddMessageEvent.class;
    }
}
