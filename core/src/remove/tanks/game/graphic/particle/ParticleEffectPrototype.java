package remove.tanks.game.graphic.particle;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectPrototype implements Serializable {
    private final String filename;
    private final boolean flipX;
    private final boolean flipY;

    public ParticleEffectPrototype(String filename, boolean flipX, boolean flipY) {
        this.filename = filename;
        this.flipX = flipX;
        this.flipY = flipY;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isFlipX() {
        return flipX;
    }

    public boolean isFlipY() {
        return flipY;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filename", filename)
                .add("flipX", flipX)
                .add("flipY", flipY)
                .toString();
    }
}
