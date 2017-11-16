package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public final class PrototypeComponentProviderFactory implements RegistrableComponentProviderFactory<PrototypeComponentProvider> {
    @Override
    public PrototypeComponentProvider createComponentProvider(ComponentSupplier componentSupplier) {
        return new PrototypeComponentProvider(componentSupplier);
    }

    @Override
    public Scope getFactoryType() {
        return Scope.Prototype;
    }
}
