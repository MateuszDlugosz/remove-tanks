package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponent implements Component {
    public static final ComponentMapper<HealthComponent> MAPPER
            = ComponentMapper.getFor(HealthComponent.class);

    private final int maxHealth;
    private final int health;

    public HealthComponent(int maxHealth, int health) {
        this.maxHealth = maxHealth;
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }
}
