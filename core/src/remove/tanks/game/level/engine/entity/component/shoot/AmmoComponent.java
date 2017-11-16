package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.google.common.collect.ImmutableMap;
import remove.tanks.game.level.engine.utility.direction.Direction;

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
    private final Map<Integer, Map<Direction, String>> prototypeCodes;

    public AmmoComponent(
            int currentLevel,
            int maxLevel,
            Map<Integer, Map<Direction, String>> prototypeCodes
    ) {
        this.currentLevel = currentLevel;
        this.maxLevel = maxLevel;
        this.prototypeCodes = prototypeCodes;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public Optional<String> getPrototypeCodeForDirection(Direction direction) {
        String prototypeCode = null;
        if (prototypeCodes.containsKey(currentLevel))
            prototypeCode = prototypeCodes.get(currentLevel).get(direction);
        return Optional.ofNullable(prototypeCode);
    }

    public Map<Integer, Map<Direction, String>> getPrototypeCodes() {
        return ImmutableMap.copyOf(prototypeCodes);
    }
}
