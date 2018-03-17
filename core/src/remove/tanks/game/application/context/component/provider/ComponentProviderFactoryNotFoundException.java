package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.component.Scope;

/**
 * @author Mateusz Długosz
 */
public final class ComponentProviderFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Component provider factory of '%s' scope not found.";

    public ComponentProviderFactoryNotFoundException(Scope scope) {
        super(String.format(MESSAGE_TEMPLATE, scope));
    }
}
