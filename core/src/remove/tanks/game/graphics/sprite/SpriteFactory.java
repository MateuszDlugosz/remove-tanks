package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class SpriteFactory {
    private final Map<Class<? extends SpritePrefab>, SubSpriteFactory> factories
            = new HashMap<>();

    public SpriteFactory(SubSpriteFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public Sprite createSprite(SpritePrefab prefabs, AssetStorage assetStorage, Scale scale) {
        try {
            if (!factories.containsKey(prefabs.getClass())) {
                throw new SpriteFactoryNotFoundException(prefabs.getClass());
            }
            return factories.get(prefabs.getClass()).createSprite(prefabs, assetStorage, scale);
        } catch (Exception e) {
            throw new SpriteCreateException(prefabs, e);
        }
    }
}
