package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.entity.EntityPrototype;

/**
 * @author Mateusz Długosz
 */
public final class BombersSpawnerComponent implements Component {
    public static final ComponentMapper<BombersSpawnerComponent> MAPPER
            = ComponentMapper.getFor(BombersSpawnerComponent.class);

    private final EntityPrototype prototype;

    public BombersSpawnerComponent(EntityPrototype prototype) {
        this.prototype = prototype;
    }

    public EntityPrototype getPrototype() {
        return prototype;
    }
}
