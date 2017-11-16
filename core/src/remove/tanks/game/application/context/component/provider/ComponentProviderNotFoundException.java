package remove.tanks.game.application.context.component.provider;

/**
 * @author Mateusz Długosz
 */
public final class ComponentProviderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Component provider of '%s' not found.";

    public ComponentProviderNotFoundException(String name) {
        super(String.format(MESSAGE_TEMPLATE, name));
    }
}
