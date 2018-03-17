package remove.tanks.game.level.engine.listener.trigger;

import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.trigger.AbstractTriggerComponent;
import remove.tanks.game.level.engine.entity.component.trigger.CreateTriggerComponent;
import remove.tanks.game.level.engine.entity.component.trigger.DestroyTriggerComponent;
import remove.tanks.game.level.engine.entity.component.trigger.HitTriggerComponent;

/**
 * @author Mateusz Długosz
 */
public enum TriggerEntityFamily {
    CreateTriggerFamily(EntityFamily.CreateFamily, CreateTriggerComponent.class),
    DestroyTriggerFamily(EntityFamily.DestroyFamily, DestroyTriggerComponent.class),
    HitTriggerFamily(EntityFamily.HitFamily, HitTriggerComponent.class);

    private final EntityFamily entityFamily;
    private final Class<? extends AbstractTriggerComponent> triggerComponentClass;

    TriggerEntityFamily(EntityFamily entityFamily, Class<? extends AbstractTriggerComponent> triggerComponentClass) {
        this.entityFamily = entityFamily;
        this.triggerComponentClass = triggerComponentClass;
    }

    public EntityFamily getEntityFamily() {
        return entityFamily;
    }

    public Class<? extends AbstractTriggerComponent> getTriggerComponentClass() {
        return triggerComponentClass;
    }
}
