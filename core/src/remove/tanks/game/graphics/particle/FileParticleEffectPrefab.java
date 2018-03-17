package remove.tanks.game.graphics.particle;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class FileParticleEffectPrefab extends ParticleEffectPrefab {
    private final String filename;
    private final String imagesDirectory;
    private final boolean flipX;
    private final boolean flipY;

    public FileParticleEffectPrefab(
            String filename,
            String imagesDirectory,
            boolean flipX,
            boolean flipY
    ) {
        this.flipX = flipX;
        this.flipY = flipY;
        this.filename = filename;
        this.imagesDirectory = imagesDirectory;
    }

    public String getFilename() {
        return filename;
    }

    public String getImagesDirectory() {
        return imagesDirectory;
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
                .add("imagesDirectory", imagesDirectory)
                .add("flipX", flipX)
                .add("flipY", flipY)
                .toString();
    }
}
