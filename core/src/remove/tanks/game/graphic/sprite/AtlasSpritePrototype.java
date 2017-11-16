package remove.tanks.game.graphic.sprite;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class AtlasSpritePrototype implements SpritePrototype {
    private final String atlasFilename;
    private final String regionName;
    private final boolean flipX;
    private final boolean flipY;

    public AtlasSpritePrototype(String atlasFilename, String regionName, boolean flipX, boolean flipY) {
        this.atlasFilename = atlasFilename;
        this.regionName = regionName;
        this.flipX = flipX;
        this.flipY = flipY;
    }

    public String getAtlasFilename() {
        return atlasFilename;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public boolean getFlipX() {
        return flipX;
    }

    @Override
    public boolean getFlipY() {
        return flipY;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("atlasFilename", atlasFilename)
                .add("regionName", regionName)
                .add("flipX", flipX)
                .add("flipY", flipY)
                .toString();
    }
}
