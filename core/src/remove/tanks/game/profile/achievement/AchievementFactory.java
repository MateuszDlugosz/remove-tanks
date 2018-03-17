package remove.tanks.game.profile.achievement;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class AchievementFactory {
    private final SpriteFactory spriteFactory;

    public AchievementFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public Achievement createAchievement(AchievementPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new Achievement(
                    prefab.getAchievementType(),
                    createSprite(prefab.getSpritePrefab(), assetStorage, scale)
            );
        } catch (Exception e) {
            throw new AchievementCreateException(prefab, e);
        }
    }

    private Sprite createSprite(SpritePrefab prefab, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prefab, assetStorage, scale);
    }
}
