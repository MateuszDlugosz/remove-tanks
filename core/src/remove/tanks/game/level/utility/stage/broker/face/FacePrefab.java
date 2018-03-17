package remove.tanks.game.level.utility.stage.broker.face;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.sprite.SpritePrefab;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class FacePrefab implements Serializable {
    private final String id;
    private final SpritePrefab spritePrefab;

    public FacePrefab(String id, SpritePrefab spritePrefab) {
        this.id = id;
        this.spritePrefab = spritePrefab;
    }

    public String getId() {
        return id;
    }

    public SpritePrefab getSpritePrefab() {
        return spritePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("spritePrefab", spritePrefab)
                .toString();
    }
}
