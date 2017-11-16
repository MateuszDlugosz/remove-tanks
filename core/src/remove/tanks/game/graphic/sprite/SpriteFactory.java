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
public final class SpriteFactory {
    private final Map<Class<? extends SpritePrototype>, RegistrableSpriteFactory> subFactories
            = new HashMap<>();

    public SpriteFactory(RegistrableSpriteFactory[] subFactories) {
        Arrays.stream(subFactories).forEach(s -> this.subFactories.put(s.getFactoryType(), s));
    }

    public List<Sprite> createSprites(List<SpritePrototype> prototypes, AssetStorage assetStorage, Scale scale) {
        return prototypes.stream()
                .map(p -> createSprite(p, assetStorage, scale))
                .collect(Collectors.toList());
    }

    public Sprite createSprite(SpritePrototype prototype, AssetStorage assetStorage, Scale scale) {
        Class<? extends SpritePrototype> prototypeClass = prototype.getClass();
        if (!subFactories.containsKey(prototypeClass)) {
            throw new SpriteFactoryNotFoundException(prototypeClass.toString());
        }
        return subFactories.get(prototypeClass).createSprite(prototype, assetStorage, scale);
    }
}
