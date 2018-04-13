package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ArenaFactory {
    private final SpriteFactory spriteFactory;

    public ArenaFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public Arena createArena(ArenaPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new Arena(
                    prefab.getTitle(),
                    prefab.getWaves(),
                    createSprite(prefab.getSpritePrefab(), assetStorage, scale),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new ArenaCreateException(prefab, e);
        }
    }

    private Sprite createSprite(SpritePrefab prefab, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prefab, assetStorage, scale);
    }
}
