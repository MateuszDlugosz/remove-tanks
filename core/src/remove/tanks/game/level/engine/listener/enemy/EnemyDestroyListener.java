package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelProperty;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.event.ModifyPropertyEvent;
import remove.tanks.game.level.engine.event.VictoryEvent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListener extends ExtendedEntityListener {
    private final EventBus eventBus;
    private final Properties properties;

    public EnemyDestroyListener(Engine engine, EventBus eventBus, Properties properties, int priority) {
        super(priority, EntityFamily.EnemiesFamily.getFamily(), engine);
        this.eventBus = eventBus;
        this.properties = properties;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        eventBus.post(new ModifyPropertyEvent(
                LevelProperty.LevelEnemies,
                String.valueOf((
                        properties.getInt(LevelProperty.LevelEnemies.getName()) - 1
                ))
        ));
        if (properties.getInt(LevelProperty.LevelEnemies.getName()) == 0) {
            eventBus.post(new VictoryEvent());
        }
    }
}
