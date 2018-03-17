package remove.tanks.game.application.context.component.supplier.validator;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public class ComponentSupplierClassModifierValidatorTest {
    private ComponentSupplierClassModifierValidator validator;

    @Before
    public void initTestObjects() {
        validator = new ComponentSupplierClassModifierValidator();
    }

    @Test(expected = ComponentSupplierClassValidationException.class)
    public void Should_ThrowException_When_GivenClassIsAbstract() {
        validator.validate(AbstractComponentSupplier.class);
    }

    @Test(expected = ComponentSupplierClassValidationException.class)
    public void Should_ThrowException_When_GivenClassIsPrivate() {
        validator.validate(PrivateComponentSupplier.class);
    }

    @Test(expected = ComponentSupplierClassValidationException.class)
    public void Should_ThrowException_When_GivenClassIsProtected() {
        validator.validate(ProtectedComponentSupplier.class);
    }

    @Test(expected = ComponentSupplierClassValidationException.class)
    public void Should_ThrowException_When_GivenClassIsNotFinal() {
        validator.validate(NotFinalComponentSupplier.class);
    }

    @Test
    public void Should_BotThrowException_When_GivenClassIsValid() {
        validator.validate(ValidComponentSupplier_0.class);
        validator.validate(ValidComponentSupplier_1.class);
    }

    abstract class AbstractComponentSupplier extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "string";
        }
    }

    private class PrivateComponentSupplier extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "string";
        }
    }

    protected class ProtectedComponentSupplier extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "string";
        }
    }

    public class NotFinalComponentSupplier extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "string";
        }
    }

    public final class ValidComponentSupplier_0 extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "string";
        }
    }

    public static final class ValidComponentSupplier_1 extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "string";
        }
    }
}