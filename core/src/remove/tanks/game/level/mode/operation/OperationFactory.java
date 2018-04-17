package remove.tanks.game.level.mode.operation;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class OperationFactory {
    private final SpriteFactory spriteFactory;

    public OperationFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public Operation createOperation(OperationPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new Operation(
                    prefab.getTitle(),
                    createSprite(prefab.getSpritePrefab(), assetStorage, scale),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new OperationCreateException(prefab, e);
        }
    }

    private Sprite createSprite(SpritePrefab prefab, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prefab, assetStorage, scale);
    }
}
