package remove.tanks.game.level.engine.entity.component.faction;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class EnemyComponentPrefab extends ComponentPrefab {
    public static final EnemyComponentPrefab INSTANCE = new EnemyComponentPrefab();

    private EnemyComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
