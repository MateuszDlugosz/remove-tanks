package remove.tanks.game.data.profile.achievement;

/**
 * @author Mateusz Długosz
 */
public final class AchievementPrefabRepositoryXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read achievement prefab repository from file %s.";

    public AchievementPrefabRepositoryXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
