package remove.tanks.game.application.context.component.supplier.validator;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableComponentSupplierValidator {
    void validate(Class<? extends ComponentSupplier> componentSupplierClass) throws ComponentSupplierClassValidationException;
}
