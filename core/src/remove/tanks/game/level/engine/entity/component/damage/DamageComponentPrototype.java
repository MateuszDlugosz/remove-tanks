package remove.tanks.game.level.engine.entity.component.damage;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class DamageComponentPrototype implements ComponentPrototype {
    private final int damage;

    public DamageComponentPrototype(int damage) {
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
