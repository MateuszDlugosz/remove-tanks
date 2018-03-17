package remove.tanks.game.level.engine.entity.component.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class DamageComponentPrefab extends ComponentPrefab {
    private final int damage;

    public DamageComponentPrefab(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("damage", damage)
                .toString();
    }
}
