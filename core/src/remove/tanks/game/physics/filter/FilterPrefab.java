package remove.tanks.game.physics.filter;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class FilterPrefab extends Prefab {
    private final short categoryBit;
    private final short maskBit;

    public FilterPrefab(short categoryBit, short maskBit) {
        this.categoryBit = categoryBit;
        this.maskBit = maskBit;
    }

    public short getCategoryBit() {
        return categoryBit;
    }

    public short getMaskBit() {
        return maskBit;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("categoryBit", categoryBit)
                .add("maskBit", maskBit)
                .toString();
    }
}
