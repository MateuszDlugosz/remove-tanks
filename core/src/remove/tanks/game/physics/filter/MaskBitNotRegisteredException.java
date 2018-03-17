package remove.tanks.game.physics.filter;

/**
 * @author Mateusz Długosz
 */
public final class MaskBitNotRegisteredException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Mask bit %s is not registered in reader.";

    public MaskBitNotRegisteredException(String maskName) {
        super(String.format(MESSAGE_TEMPLATE, maskName));
    }
}
