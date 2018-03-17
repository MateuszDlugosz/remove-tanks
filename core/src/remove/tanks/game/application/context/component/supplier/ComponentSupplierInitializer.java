package remove.tanks.game.application.context.component.supplier;

import remove.tanks.game.application.context.Context;
import remove.tanks.game.application.context.component.Scope;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentScope;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassValidator;

import java.lang.reflect.Field;

/**
 * @author Mateusz Długosz
 */
public final class ComponentSupplierInitializer {
    private static final Scope DEFAULT_SCOPE = Scope.Singleton;

    private static final String SUPPLY_COMPONENT_METHOD_NAME = "supplyComponent";

    private static final String CONTEXT_FIELD = "context";
    private static final String COMPONENT_NAME_FIELD = "componentName";
    private static final String COMPONENT_SCOPE_FIELD = "componentScope";

    private final ComponentSupplierClassValidator componentSupplierClassValidator;

    public ComponentSupplierInitializer(ComponentSupplierClassValidator componentSupplierClassValidator) {
        this.componentSupplierClassValidator = componentSupplierClassValidator;
    }

    public ComponentSupplier initializeComponentSupplier(Class<? extends ComponentSupplier> supplierClass, Context context) {
        try {
            componentSupplierClassValidator.validate(supplierClass);
            return initializeComponentSupplier(supplierClass.newInstance(), supplierClass, context);
        } catch (IllegalAccessException e) {
            throw new ComponentSupplierIllegalAccessException(e);
        } catch (InstantiationException e) {
            throw new ComponentSupplierInstantiationException(e);
        }
    }

    private ComponentSupplier initializeComponentSupplier(ComponentSupplier componentSupplier, Class<? extends ComponentSupplier> supplierClass, Context context) {
        try {
            Field contextField = supplierClass.getSuperclass().getDeclaredField(CONTEXT_FIELD);
            Field componentNameField = supplierClass.getSuperclass().getDeclaredField(COMPONENT_NAME_FIELD);
            Field componentScopeField = supplierClass.getSuperclass().getDeclaredField(COMPONENT_SCOPE_FIELD);

            contextField.setAccessible(true);
            contextField.set(componentSupplier, context);

            componentNameField.setAccessible(true);
            componentNameField.set(componentSupplier, getComponentSupplierName(supplierClass));

            componentScopeField.setAccessible(true);
            componentScopeField.set(componentSupplier, getComponentSupplierScope(supplierClass));
        } catch (NoSuchFieldException | IllegalAccessException | ComponentSupplierNoSuchMethodException e) {
            throw new ComponentSupplierInitializationException(e);
        }
        return componentSupplier;
    }

    private String getComponentSupplierName(Class<? extends ComponentSupplier> supplierClass) {
        if (supplierClass.getAnnotation(ComponentName.class) != null) {
            return supplierClass.getAnnotation(ComponentName.class).value();
        }
        try {
            return supplierClass.getMethod(SUPPLY_COMPONENT_METHOD_NAME).getReturnType().toString();
        } catch (NoSuchMethodException e) {
            throw new ComponentSupplierNoSuchMethodException(e);
        }
    }

    private Scope getComponentSupplierScope(Class<? extends ComponentSupplier> supplierClass) {
        if (supplierClass.getAnnotation(ComponentScope.class) != null) {
            return supplierClass.getAnnotation(ComponentScope.class).value();
        }
        return DEFAULT_SCOPE;
    }
}
