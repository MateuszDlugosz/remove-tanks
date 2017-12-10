package remove.tanks.game.screen.switcher.storage;

import remove.tanks.game.screen.GameScreen;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class ScreenStorage {
    private final Map<Class<? extends GameScreen>, GameScreen> screens
            = new HashMap<>();

    public ScreenStorage(Set<? extends GameScreen> screens) {
        screens.forEach(s -> this.screens.put(s.getClass(), s));
    }

    public GameScreen getScreen(Class<? extends GameScreen> screenClass) {
        if (!screens.containsKey(screenClass)) {
            throw new ScreenNotFoundException(screenClass);
        }
        return screens.get(screenClass);
    }
}
