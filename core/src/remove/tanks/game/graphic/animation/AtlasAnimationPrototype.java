package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AtlasAnimationPrototype implements AnimationPrototype {
    private final String atlasFilename;
    private final List<String> regionNames;
    private final float frameDuration;
    private final Animation.PlayMode playMode;
    private final boolean flipX;
    private final boolean flipY;

    public AtlasAnimationPrototype(
            String atlasFilename,
            List<String> regionNames,
            float frameDuration,
            Animation.PlayMode playMode,
            boolean flipX,
            boolean flipY
    ) {
        this.atlasFilename = atlasFilename;
        this.regionNames = regionNames;
        this.frameDuration = frameDuration;
        this.playMode = playMode;
        this.flipX = flipX;
        this.flipY = flipY;
    }

    public String getAtlasFilename() {
        return atlasFilename;
    }

    public List<String> getRegionNames() {
        return regionNames;
    }

    public float getFrameDuration() {
        return frameDuration;
    }

    public Animation.PlayMode getPlayMode() {
        return playMode;
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
                .add("regionNames", regionNames)
                .add("frameDuration", frameDuration)
                .add("playMode", playMode)
                .add("flipX", flipX)
                .add("flipY", flipY)
                .toString();
    }
}
