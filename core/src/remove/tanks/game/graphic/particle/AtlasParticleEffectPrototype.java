package remove.tanks.game.graphic.particle;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class AtlasParticleEffectPrototype implements ParticleEffectPrototype {
    private final String filename;
    private final String atlasFilename;
    private boolean flipX;
    private boolean flipY;

    public AtlasParticleEffectPrototype(
            String filename,
            String atlasFilename,
            boolean flipX,
            boolean flipY
    ) {
        this.filename = filename;
        this.atlasFilename = atlasFilename;
        this.flipX = flipX;
        this.flipY = flipY;
    }

    public String getFilename() {
        return filename;
    }

    public String getAtlasFilename() {
        return atlasFilename;
    }

    @Override
    public boolean isFlipX() {
        return flipX;
    }

    @Override
    public boolean isFlipY() {
        return flipY;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filename", filename)
                .add("atlasFilename", atlasFilename)
                .add("flipX", flipX)
                .add("flipY", flipY)
                .toString();
    }
}
