package remove.tanks.game.application.context.component.supplier;

import remove.tanks.game.application.context.Context;
import remove.tanks.game.application.context.component.provider.Scope;

/**
 * @author Mateusz Długosz
 */
public abstract class ComponentSupplier<T> {
    private Context context = null;
    private String componentName = null;
    private Scope componentScope = null;

    public final Context getContext() {
        return context;
    }

    public final String getComponentName() {
        return componentName;
    }

    public final Scope getComponentScope() {
        return componentScope;
    }

    public abstract T supplyComponent();
}
