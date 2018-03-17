package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.google.common.collect.ImmutableMap;
import remove.tanks.game.level.utility.direction.Direction;

import java.util.Map;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AmmoComponent implements Component {
    public static final ComponentMapper<AmmoComponent> MAPPER
            = ComponentMapper.getFor(AmmoComponent.class);

    private final int currentLevel;
    private final int maxLevel;
    private final Map<Integer, Map<Direction, String>> prefabCodes;

    public AmmoComponent(
            int currentLevel,
            int maxLevel,
            Map<Integer, Map<Direction, String>> prefabCodes
    ) {
        this.currentLevel = currentLevel;
        this.maxLevel = maxLevel;
        this.prefabCodes = prefabCodes;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public Optional<String> getPrefabCodeForDirection(Direction direction) {
        String prefabCode = null;
        if (prefabCodes.containsKey(currentLevel))
            prefabCode = prefabCodes.get(currentLevel).get(direction);
        return Optional.ofNullable(prefabCode);
    }

    public Map<Integer, Map<Direction, String>> getPrefabCodes() {
        return ImmutableMap.copyOf(prefabCodes);
    }
}
