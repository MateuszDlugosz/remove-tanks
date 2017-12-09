package remove.tanks.game.application.context.component.provider;

import com.google.common.collect.ImmutableMap;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ComponentProviderFactory {
    private final ImmutableMap<Scope, RegistrableComponentProviderFactory> factories;

    public ComponentProviderFactory(RegistrableComponentProviderFactory[] factories) {
        this.factories = ImmutableMap.copyOf(Arrays.stream(factories)
                        .collect(Collectors.toMap(RegistrableComponentProviderFactory::getFactoryType, s -> s)));
    }

    public ComponentProvider createComponentProvider(ComponentSupplier componentSupplier) {
        if (!factories.containsKey(componentSupplier.getComponentScope())) {
            throw new ComponentProviderFactoryNotFoundException(componentSupplier.getComponentScope());
        }
        return factories.get(componentSupplier.getComponentScope())
                .createComponentProvider(componentSupplier);
    }
}
