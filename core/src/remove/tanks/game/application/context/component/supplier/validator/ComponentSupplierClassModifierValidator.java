package remove.tanks.game.application.context.component.supplier.validator;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

import java.lang.reflect.Modifier;

/**
 * @author Mateusz Długosz
 */
public final class ComponentSupplierClassModifierValidator implements RegistrableComponentSupplierValidator {
    private static final String ABSTRACT_MODIFIER_ERROR_MESSAGE_TEMPLATE = "(%s) Component supplier class cannot be abstract.";
    private static final String PRIVATE_MODIFIER_ERROR_MESSAGE_TEMPLATE = "(%s) Component supplier class cannot be private.";
    private static final String PROTECTED_MODIFIER_ERROR_MESSAGE_TEMPLATE = "(%s) Component supplier class cannot be protected.";
    private static final String FINAL_MODIFIER_ERROR_MESSAGE_TEMPLATE = "(%s) Component supplier class must be final.";

    @Override
    public void validate(Class<? extends ComponentSupplier> componentSupplierClass) throws ComponentSupplierClassValidationException {
        if (Modifier.isAbstract(componentSupplierClass.getModifiers())) {
            throw new ComponentSupplierClassValidationException(
                    String.format(ABSTRACT_MODIFIER_ERROR_MESSAGE_TEMPLATE, componentSupplierClass.toString())
            );
        }

        if (Modifier.isPrivate(componentSupplierClass.getModifiers())) {
            throw new ComponentSupplierClassValidationException(
                    String.format(PRIVATE_MODIFIER_ERROR_MESSAGE_TEMPLATE, componentSupplierClass.toString())
            );
        }

        if (Modifier.isProtected(componentSupplierClass.getModifiers())) {
            throw new ComponentSupplierClassValidationException(
                    String.format(PROTECTED_MODIFIER_ERROR_MESSAGE_TEMPLATE, componentSupplierClass.toString())
            );
        }

        if (!Modifier.isFinal(componentSupplierClass.getModifiers())) {
                throw new ComponentSupplierClassValidationException(
                        String.format(FINAL_MODIFIER_ERROR_MESSAGE_TEMPLATE, componentSupplierClass.toString())
                ) ;
        }
    }
}
