package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototypeNotFoundException extends RuntimeException {
    private static final  String MESSAGE_TEMPLATE = "Entity prototype %s not found.";

    public EntityPrototypeNotFoundException(String code) {
        super(String.format(MESSAGE_TEMPLATE, code));
    }
}
