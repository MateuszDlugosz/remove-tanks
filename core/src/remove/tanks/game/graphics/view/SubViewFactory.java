package remove.tanks.game.graphics.view;

import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface SubViewFactory<T extends View, U extends ViewPrefab> {
    T createView(U prefab, AssetStorage assetStorage, Scale scale);
    Class<U> getFactoryType();
}
