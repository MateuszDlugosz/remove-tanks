package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class CampaignFactory {
    public Campaign createCampaign(CampaignPrefab prefab) {
        try {
            return new Campaign(
                    prefab.getTitle(),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new CampaignCreateException(prefab, e);
        }
    }

}
