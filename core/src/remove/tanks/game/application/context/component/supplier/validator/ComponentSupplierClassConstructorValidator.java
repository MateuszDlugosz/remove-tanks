package remove.tanks.game.application.context.component.supplier.validator;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

import java.util.Arrays;

/**
 * @author Mateusz Długosz
 */
public final class ComponentSupplierClassConstructorValidator implements SubComponentSupplierValidator {
    private static final String MESSAGE = "(%s) Constructor without parameters is valid constructor in supplier class.";

    @Override
    public void validate(Class<? extends ComponentSupplier> componentSupplierClass)
            throws ComponentSupplierClassValidationException
    {
        Arrays.stream(componentSupplierClass.getConstructors()).forEach(c -> {
            if (c.getParameterCount() > 0) {
                throw new ComponentSupplierClassValidationException(String.format(MESSAGE, componentSupplierClass));
            }
        });
    }
}
