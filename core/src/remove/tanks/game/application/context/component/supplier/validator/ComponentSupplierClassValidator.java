package remove.tanks.game.application.context.component.supplier.validator;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ComponentSupplierClassValidator {
    private final List<SubComponentSupplierValidator> validators;

    public ComponentSupplierClassValidator(SubComponentSupplierValidator[] validators) {
        this.validators = Arrays.asList(validators);
    }

    public void validate(Class<? extends ComponentSupplier> componentSupplierClass) {
        List<String> validationErrors = new ArrayList<>();
        validators.forEach(v -> {
            try {
                v.validate(componentSupplierClass);
            } catch (ComponentSupplierClassValidationException e) {
                validationErrors.add(e.getMessage());
            }
        });
        if (validationErrors.size() > 0) {
            throw new ComponentSupplierClassValidationException(String.join(" ", validationErrors));
        }
    }
}
