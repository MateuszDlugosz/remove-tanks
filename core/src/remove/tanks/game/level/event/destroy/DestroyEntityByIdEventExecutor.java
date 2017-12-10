package remove.tanks.game.level.event.destroy;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponent;
import remove.tanks.game.level.event.RegistrableEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEventExecutor
        implements RegistrableEventExecutor<DestroyEntityByIdEvent>
{
    @Override
    public void executeEvent(DestroyEntityByIdEvent event, Level level) {
        level.getResourceRegistry().getResource("Engine", Engine.class)
                .getEntitiesFor(EntityFamily.IdentifiableFamily.getFamily())
                .forEach(e -> e.add(new DestroyComponent()));
    }

    @Override
    public Class<DestroyEntityByIdEvent> getExecutorType() {
        return DestroyEntityByIdEvent.class;
    }
}
