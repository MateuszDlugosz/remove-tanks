package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

/**
 * @author Mateusz Długosz
 */
public final class SingletonComponentProvider<T> implements ComponentProvider<T> {
    private final ComponentSupplier componentSupplier;
    private T providedComponent;

    public SingletonComponentProvider(ComponentSupplier componentSupplier) {
        this.componentSupplier = componentSupplier;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T provideComponent() {
        if (providedComponent == null) {
            providedComponent = (T) componentSupplier.supplyComponent();
        }
        return providedComponent;
    }
}
