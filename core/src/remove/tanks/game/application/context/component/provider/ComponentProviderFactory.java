package remove.tanks.game.application.context.component.provider;

import com.google.common.collect.ImmutableMap;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ComponentProviderFactory {
    private final ImmutableMap<Scope, RegistrableComponentProviderFactory> componentProviderFactories;

    public ComponentProviderFactory(RegistrableComponentProviderFactory[] subFactories) {
        componentProviderFactories = ImmutableMap.copyOf(
                Arrays.stream(subFactories)
                        .collect(Collectors.toMap(RegistrableComponentProviderFactory::getFactoryType, s -> s)));
    }

    public ComponentProvider createComponentProvider(ComponentSupplier componentSupplier) {
        if (!componentProviderFactories.containsKey(componentSupplier.getComponentScope())) {
            throw new ComponentProviderFactoryNotFoundException(componentSupplier.getComponentScope());
        }
        return componentProviderFactories.get(componentSupplier.getComponentScope())
                .createComponentProvider(componentSupplier);
    }
}
