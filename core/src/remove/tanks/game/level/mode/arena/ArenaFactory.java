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
    public Arena createArena(ArenaPrefab prefab) {
        try {
            return new Arena(
                    prefab.getTitle(),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new ArenaCreateException(prefab, e);
        }
    }
}
