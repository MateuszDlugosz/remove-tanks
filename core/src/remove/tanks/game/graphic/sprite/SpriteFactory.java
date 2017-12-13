package remove.tanks.game.graphic.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
public final class SpriteFactory {
    private final Map<Class<? extends SpritePrototype>, RegistrableSpriteFactory> factories
            = new HashMap<>();

    public SpriteFactory(RegistrableSpriteFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<Sprite> createSprites(List<SpritePrototype> prototypes, AssetStorage assetStorage, Scale scale) {
        return prototypes.stream()
                .map(p -> createSprite(p, assetStorage, scale))
                .collect(Collectors.toList());
    }

    public Sprite createSprite(SpritePrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            if (!factories.containsKey(prototype.getClass())) {
                throw new SpriteFactoryNotFoundException(prototype.getClass());
            }
            return factories.get(prototype.getClass()).createSprite(prototype, assetStorage, scale);
        } catch (Exception e) {
            throw new SpriteCreateException(prototype, e);
        }
    }
}
