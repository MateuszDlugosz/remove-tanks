package remove.tanks.game.level.mode.arena;

/**
 * @author Mateusz Długosz
 */
public final class ArenaNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Arena titled %s not found.";

    public ArenaNotFoundException(String title) {
        super(String.format(MESSAGE_TEMPLATE, title));
    }
}
