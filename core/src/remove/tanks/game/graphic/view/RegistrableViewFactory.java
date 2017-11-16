package remove.tanks.game.graphic.view;

import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableViewFactory<T extends View, U extends ViewPrototype> {
    T createView(U prototype, AssetStorage assetStorage, Scale scale);
    Class<U> getFactoryType();
}
