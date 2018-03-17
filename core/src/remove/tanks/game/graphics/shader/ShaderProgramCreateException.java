package remove.tanks.game.graphics.shader;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create shader program from prefab %s.";

    public ShaderProgramCreateException(ShaderProgramPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
