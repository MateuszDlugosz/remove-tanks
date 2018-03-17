package remove.tanks.game.application.context.component.supplier.validator;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public class ComponentSupplierClassValidatorTest {
    private ComponentSupplierClassValidator validator;

    @Before
    public void initTestObjects() {
        validator = new ComponentSupplierClassValidator(
                new SubComponentSupplierValidator[] {
                        new ComponentSupplierClassModifierValidator(),
                        new ComponentSupplierClassConstructorValidator()
                }
        );
    }

    @Test
    public void Should_NotThrowException_When_GivenClassIsValid() {
        validator.validate(ValidComponentSupplier.class);
    }

    @Test(expected = ComponentSupplierClassValidationException.class)
    public void Should_ThrowException_When_GivenClassIsInvalid() {
        validator.validate(InvalidComponentSupplier.class);
    }

    public final static class ValidComponentSupplier extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "string";
        }
    }

    public class InvalidComponentSupplier extends ComponentSupplier<String> {
        private final String invalidField;

        public InvalidComponentSupplier(String invalidField) {
            this.invalidField = invalidField;
        }

        @Override
        public String supplyComponent() {
            return "string";
        }
    }
}
