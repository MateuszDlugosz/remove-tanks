package remove.tanks.game.graphic.shader;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create shader program from prototype %s.";

    public ShaderProgramCreateException(ShaderProgramPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
