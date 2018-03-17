package remove.tanks.game.level.engine.system.combat;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.combat.HitComponent;
import remove.tanks.game.level.engine.entity.component.render.ViewComponent;

/**
 * @author Mateusz Długosz
 */
public final class HitSystem extends IteratingSystem {
    public HitSystem(int priority) {
        super(EntityFamily.HitFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ViewComponent vc = ViewComponent.MAPPER.get(entity);
        HitComponent hc = HitComponent.MAPPER.get(entity);
        if (hc.getTimer().isCompleted()) {
            if (vc != null) vc.getViews().values().forEach(v -> v.setEffect(null));
            entity.remove(HitComponent.class);
        } else {
            if (vc != null) vc.getViews().values().forEach(v -> v.setEffect(hc.getEffect()));
            hc.getTimer().update(deltaTime);
        }
    }
}
