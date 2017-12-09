package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public final class PrototypeComponentProvider<T> implements ComponentProvider<T> {
    private final ComponentSupplier componentSupplier;

    public PrototypeComponentProvider(ComponentSupplier componentSupplier) {
        this.componentSupplier = componentSupplier;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T provideComponent() {
        return (T) componentSupplier.supplyComponent();
    }
}
