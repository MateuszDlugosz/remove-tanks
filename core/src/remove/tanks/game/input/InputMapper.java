package remove.tanks.game.input;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class InputMapper {
    private final Map<InputKey, Boolean> keys;

    InputMapper(Map<InputKey, Boolean> keys) {
        this.keys = keys;
    }

    public void keyDown(InputKey inputKey) {
        if (!hasKey(inputKey)) {
            throw new InputKeyNotFoundException(inputKey);
        }
        keys.replace(inputKey, true);
    }

    public void keyUp(InputKey inputKey) {
        if (!hasKey(inputKey)) {
            throw new InputKeyNotFoundException(inputKey);
        }
        keys.replace(inputKey, false);
    }

    public void keyDownAll() {
        keys.keySet().forEach(k -> keys.replace(k, true));
    }

    public void keyUpAll() {
        keys.keySet().forEach(k -> keys.replace(k, false));
    }

    public boolean isKeyPressed(InputKey inputKey) {
        if (!hasKey(inputKey)) {
            throw new InputKeyNotFoundException(inputKey);
        }
        return keys.get(inputKey);
    }

    private boolean hasKey(InputKey inputKey) {
        return keys.containsKey(inputKey);
    }
}
