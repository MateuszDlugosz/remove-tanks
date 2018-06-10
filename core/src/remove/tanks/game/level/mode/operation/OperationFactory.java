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
    public Operation createOperation(OperationPrefab prefab) {
        try {
            return new Operation(
                    prefab.getTitle(),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new OperationCreateException(prefab, e);
        }
    }
}
