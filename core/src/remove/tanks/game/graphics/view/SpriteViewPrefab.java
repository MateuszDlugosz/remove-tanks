package remove.tanks.game.graphics.view;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewPrefab extends ViewPrefab {
    private final String id;
    private final PositionPrefab positionPrefab;
    private final SpritePrefab spritePrefab;

    public SpriteViewPrefab(String id, PositionPrefab positionPrefab, SpritePrefab spritePrefab) {
        this.id = id;
        this.positionPrefab = positionPrefab;
        this.spritePrefab = spritePrefab;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public SpritePrefab getSpritePrefab() {
        return spritePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("positionPrefab", positionPrefab)
                .add("spritePrefab", spritePrefab)
                .toString();
    }
}
