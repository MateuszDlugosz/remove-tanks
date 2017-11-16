package remove.tanks.game.level.input;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class InputMapper {
    private final List<Key> keys = new ArrayList<>();

    public enum Key { MoveLeft, MoveRight, MoveUp, MoveDown, Shoot }

    public void apply(Key key) {
        keys.add(key);
    }

    public ImmutableList<Key> getKeysList() {
        return ImmutableList.copyOf(keys);
    }

    public boolean isKeyPressed(Key key) {
        return keys.contains(key);
    }

    public void reset() {
        keys.clear();
    }
}
