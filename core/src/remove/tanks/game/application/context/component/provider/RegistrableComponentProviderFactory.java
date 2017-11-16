package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableComponentProviderFactory<T extends ComponentProvider> {
    T createComponentProvider(ComponentSupplier supplier);
    Scope getFactoryType();
}
