package remove.tanks.game.level.engine.entity.component.health;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponent implements Component {
    public static final ComponentMapper<HealthComponent> MAPPER
            = ComponentMapper.getFor(HealthComponent.class);

    private final int health;
    private final int maxHealth;

    public HealthComponent(int health, int maxHealth) {
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
