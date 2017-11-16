package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.bonus.BonusComponent;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.level.engine.listener.bonus.executor.BonusExecutor;
import remove.tanks.game.utility.properties.Properties;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class BonusPickUpListener extends ExtendedEntityListener {
    private final EventBus eventBus;
    private final Properties properties;
    private final Map<BonusType, BonusExecutor> executors
            = new HashMap<>();

    public BonusPickUpListener(
            BonusExecutor[] executors,
            EventBus eventBus,
            Engine engine,
            Properties properties,
            int priority
    ) {
        super(priority, EntityFamily.BonusFamily.getFamily(), engine);
        this.eventBus = eventBus;
        this.properties = properties;
        Arrays.stream(executors).forEach(e -> this.executors.put(e.getExecutorType(), e));
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        BonusComponent bc = BonusComponent.MAPPER.get(entity);
        if (executors.containsKey(bc.getBonusType())) {
            executors.get(bc.getBonusType()).executeBonus(entity, this);
        }
    }
}
