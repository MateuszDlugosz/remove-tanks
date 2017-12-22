package remove.tanks.game.level.engine.system.hud.stages;

/**
 * @author Mateusz Długosz
 */
public final class HudStageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create hud stage from prototype %s.";

    public HudStageCreateException(HudStagePrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
