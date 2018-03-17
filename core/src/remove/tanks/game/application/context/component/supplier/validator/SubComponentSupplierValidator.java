package remove.tanks.game.application.context.component.supplier.validator;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public interface SubComponentSupplierValidator {
    void validate(Class<? extends ComponentSupplier> componentSupplierClass) throws ComponentSupplierClassValidationException;
}
