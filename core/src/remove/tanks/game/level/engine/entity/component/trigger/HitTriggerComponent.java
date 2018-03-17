package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.event.EntityEvent;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HitTriggerComponent extends AbstractTriggerComponent {
    public static final ComponentMapper<HitTriggerComponent> MAPPER
            = ComponentMapper.getFor(HitTriggerComponent.class);

    public HitTriggerComponent(List<EntityEvent> entityEvents) {
        super(entityEvents);
    }
}
