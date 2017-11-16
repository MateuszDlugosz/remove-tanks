package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class FileAnimationPrototype implements AnimationPrototype {
    private final List<String> filenames;
    private final float frameDuration;
    private final Animation.PlayMode playMode;
    private final boolean flipX;
    private final boolean flipY;

    public FileAnimationPrototype(
            List<String> filenames,
            float frameDuration,
            Animation.PlayMode playMode,
            boolean flipX,
            boolean flipY
    ) {
        this.filenames = filenames;
        this.frameDuration = frameDuration;
        this.playMode = playMode;
        this.flipX = flipX;
        this.flipY = flipY;
    }

    public List<String> getFilenames() {
        return filenames;
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
                .add("filenames", filenames)
                .add("frameDuration", frameDuration)
                .add("playMode", playMode)
                .add("flipX", flipX)
                .add("flipY", flipY)
                .toString();
    }
}
