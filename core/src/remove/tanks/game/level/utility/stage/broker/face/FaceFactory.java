package remove.tanks.game.level.utility.stage.broker.face;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FaceFactory {
    private final SpriteFactory spriteFactory;

    public FaceFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public List<Face> createFaces(List<FacePrefab> prefabs, AssetStorage assetStorage, Scale scale) {
        return prefabs.stream()
                .map(p -> createFace(p, assetStorage, scale))
                .collect(Collectors.toList());
    }

    public Face createFace(FacePrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new Face(
                    prefab.getId(),
                    createSprite(
                            prefab.getSpritePrefab(),
                            assetStorage,
                            scale
                    )
            );
        } catch (Exception e) {
            throw new FaceCreateException(prefab, e);
        }
    }

    private Sprite createSprite(SpritePrefab prefab, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prefab, assetStorage, scale);
    }
}
