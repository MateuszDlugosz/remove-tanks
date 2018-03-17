package remove.tanks.game.level.engine.system.hud;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;
import remove.tanks.game.level.utility.stage.HudStagePrefab;

/**
 * @author Mateusz Długosz
 */
public final class HudSystemPrefab extends EntitySystemPrefab {
    private final HudStagePrefab hudStagePrefab;

    public HudSystemPrefab(int priority, HudStagePrefab hudStagePrefab) {
        super(priority);
        this.hudStagePrefab = hudStagePrefab;
    }

    public HudStagePrefab getHudStagePrefab() {
        return hudStagePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hudStagePrefab", hudStagePrefab)
                .toString();
    }
}
