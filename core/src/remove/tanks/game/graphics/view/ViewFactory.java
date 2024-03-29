package remove.tanks.game.graphics.view;

import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ViewFactory {
    private final Map<Class<? extends ViewPrefab>, SubViewFactory> factories
            = new HashMap<>();

    public ViewFactory(SubViewFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public View createView(ViewPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new ViewFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createView(prefab, assetStorage, scale);
        } catch (Exception e) {
            throw new ViewCreateException(prefab, e);
        }
    }
}
