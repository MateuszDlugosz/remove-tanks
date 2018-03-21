package remove.tanks.game.data.profile.achievement;

/**
 * @author Mateusz Długosz
 */
public final class AchievementCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create achievement from prefab %s.";

    public AchievementCreateException(AchievementPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
