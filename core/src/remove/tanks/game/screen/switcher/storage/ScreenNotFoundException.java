package remove.tanks.game.screen.switcher.storage;

import remove.tanks.game.screen.GameScreen;

/**
 * @author Mateusz Długosz
 */
public final class ScreenNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Screen %s not found.";

    public ScreenNotFoundException(Class<? extends GameScreen> gameScreenClass) {
        super(String.format(MESSAGE_TEMPLATE, gameScreenClass));
    }
}
