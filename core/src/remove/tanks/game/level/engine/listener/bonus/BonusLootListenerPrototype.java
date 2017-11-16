package remove.tanks.game.level.engine.listener.bonus;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootListenerPrototype extends EntityListenerPrototype {
    private final int chance;
    private final List<String> prototypeCodes;

    public BonusLootListenerPrototype(int chance, List<String> prototypeCodes, int priority) {
        super(priority);
        this.chance = chance;
        this.prototypeCodes = prototypeCodes;
    }

    public int getChance() {
        return chance;
    }

    public List<String> getPrototypeCodes() {
        return prototypeCodes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("chance", chance)
                .add("prototypeCodes", prototypeCodes)
                .toString();
    }
}
