package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.component.Scope;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public interface SubComponentProviderFactory<T extends ComponentProvider> {
    T createComponentProvider(ComponentSupplier componentSupplier);
    Scope getFactoryType();
}
