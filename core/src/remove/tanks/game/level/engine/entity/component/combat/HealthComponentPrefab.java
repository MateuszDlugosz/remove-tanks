package remove.tanks.game.level.engine.entity.component.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponentPrefab extends ComponentPrefab {
    private final int maxHealth;
    private final int health;

    public HealthComponentPrefab(int maxHealth, int health) {
        this.maxHealth = maxHealth;
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("maxHealth", maxHealth)
                .add("health", health)
                .toString();
    }
}
