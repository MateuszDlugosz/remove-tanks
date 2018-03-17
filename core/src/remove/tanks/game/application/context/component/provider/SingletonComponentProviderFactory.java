package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.component.Scope;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public final class SingletonComponentProviderFactory implements SubComponentProviderFactory<SingletonComponentProvider> {
    @Override
    public SingletonComponentProvider createComponentProvider(ComponentSupplier componentSupplier) {
        return new SingletonComponentProvider(componentSupplier);
    }

    @Override
    public Scope getFactoryType() {
        return Scope.Singleton;
    }
}
