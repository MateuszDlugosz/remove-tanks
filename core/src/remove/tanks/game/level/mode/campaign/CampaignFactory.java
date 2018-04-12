package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class CampaignFactory {
    private final SpriteFactory spriteFactory;

    public CampaignFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public Campaign createCampaign(CampaignPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new Campaign(
                    prefab.getTitle(),
                    createSprite(prefab, assetStorage, scale),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new CampaignCreateException(prefab, e);
        }
    }

    private Sprite createSprite(CampaignPrefab prefab, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prefab.getSpritePrefab(), assetStorage, scale);
    }
}
