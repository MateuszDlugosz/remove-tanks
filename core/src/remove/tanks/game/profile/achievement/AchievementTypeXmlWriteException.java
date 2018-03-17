package remove.tanks.game.profile.achievement;

/**
 * @author Mateusz Długosz
 */
public final class AchievementTypeXmlWriteException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot write achievement type.";

    public AchievementTypeXmlWriteException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
