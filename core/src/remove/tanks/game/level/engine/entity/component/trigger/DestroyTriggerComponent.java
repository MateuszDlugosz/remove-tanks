package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.event.EntityEvent;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class DestroyTriggerComponent extends AbstractTriggerComponent {
    public static final ComponentMapper<DestroyTriggerComponent> MAPPER
            = ComponentMapper.getFor(DestroyTriggerComponent.class);

    public DestroyTriggerComponent(List<EntityEvent> entityEvents) {
        super(entityEvents);
    }
}
