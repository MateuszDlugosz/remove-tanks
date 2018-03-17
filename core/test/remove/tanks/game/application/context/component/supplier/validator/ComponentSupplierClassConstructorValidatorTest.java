package remove.tanks.game.application.context.component.supplier.validator;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public class ComponentSupplierClassConstructorValidatorTest {
    private ComponentSupplierClassConstructorValidator validator;

    @Before
    public void initTestObjects() {
        validator = new ComponentSupplierClassConstructorValidator();
    }

    @Test
    public void Should_NotThrowException_When_GivenConstructorIsValid() {
        validator.validate(TestValidComponentSupplier.class);
    }

    @Test(expected = ComponentSupplierClassValidationException.class)
    public void Should_ThrowException_When_GivenConstructorIsInvalid() {
        validator.validate(TestInvalidComponentSupplier.class);
    }

    public static class TestValidComponentSupplier extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "valid";
        }
    }

    public static class TestInvalidComponentSupplier extends ComponentSupplier<String> {
        private final String invalidFinalField;

        public TestInvalidComponentSupplier(String constructorArgumentsAreInvalid) {
            invalidFinalField = constructorArgumentsAreInvalid;
        }

        @Override
        public String supplyComponent() {
            return invalidFinalField;
        }
    }
}