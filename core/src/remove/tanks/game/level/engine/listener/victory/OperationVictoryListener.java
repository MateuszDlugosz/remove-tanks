package remove.tanks.game.level.engine.listener.victory;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelProperty;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.event.VictoryEvent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictoryListener extends ExtendedEntityListener {
    private final Properties properties;
    private final EventBus eventBus;

    public OperationVictoryListener(
            Properties properties,
            EventBus eventBus,
            Engine engine,
            int priority
    ) {
        super(priority, EntityFamily.EnemiesFamily.getFamily(), engine);
        this.properties = properties;
        this.eventBus = eventBus;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        if (properties.getInt(LevelProperty.LevelEnemies.getName()) == 0) {
            eventBus.post(new VictoryEvent());
            getEngine().removeEntityListener(this);
        }
    }
}
