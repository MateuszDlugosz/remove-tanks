package remove.tanks.game.level.engine.entity.component.health;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponentPrototype implements ComponentPrototype {
    private final int health;
    private final int maxHealth;

    public HealthComponentPrototype(int health, int maxHealth) {
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("health", health)
                .add("maxHealth", maxHealth)
                .toString();
    }
}
