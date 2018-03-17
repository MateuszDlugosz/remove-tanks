package remove.tanks.game.physics.fixture;

/**
 * @author Mateusz Długosz
 */
public final class FixtureCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create fixture from prefab %s.";

    public FixtureCreateException(FixturePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
