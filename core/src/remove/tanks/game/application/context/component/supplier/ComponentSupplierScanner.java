package remove.tanks.game.application.context.component.supplier;

import org.reflections.Reflections;

import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class ComponentSupplierScanner {
    public Set<Class<? extends ComponentSupplier>> scanPackage(String packageName) {
        return new Reflections(packageName).getSubTypesOf(ComponentSupplier.class);
    }
}
