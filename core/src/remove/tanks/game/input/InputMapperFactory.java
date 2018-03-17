package remove.tanks.game.input;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class InputMapperFactory {
    public InputMapper createInputMapper() {
        try {
            return new InputMapper(createKeyMap());
        } catch (Exception e) {
            throw new InputMapperCreateException(e);
        }
    }

    private Map<InputKey, Boolean> createKeyMap() {
        return Arrays.stream(InputKey.values()).collect(Collectors.toMap(k -> k, v -> false));
    }
}
