package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.event.EntityEvent;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CreateTriggerComponent extends AbstractTriggerComponent {
    public static final ComponentMapper<CreateTriggerComponent> MAPPER
            = ComponentMapper.getFor(CreateTriggerComponent.class);

    public CreateTriggerComponent(List<EntityEvent> entityEvents) {
        super(entityEvents);
    }
}
