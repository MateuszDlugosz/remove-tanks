package remove.tanks.game.graphic.view;

import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ViewFactory {
    private final Map<Class<? extends ViewPrototype>, RegistrableViewFactory> factories
            = new HashMap<>();

    public ViewFactory(RegistrableViewFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<View> createViews(List<ViewPrototype> prototypes, AssetStorage assetStorage, Scale scale) {
        return prototypes.stream()
                .map(p -> createView(p, assetStorage, scale))
                .collect(Collectors.toList());
    }

    public View createView(ViewPrototype prototype, AssetStorage assetStorage, Scale scale) {
        Class<? extends ViewPrototype> prototypeClass = prototype.getClass();
        if (!factories.containsKey(prototypeClass)) {
            throw new ViewFactoryNotFoundException(prototypeClass.toString());
        }
        return factories.get(prototypeClass).createView(prototype, assetStorage, scale);
    }
}
