package remove.tanks.game.graphics.sprite;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class FileSpritePrefab extends SpritePrefab {
    private final String filename;
    private final boolean flipX;
    private final boolean flipY;

    public FileSpritePrefab(String filename, boolean flipX, boolean flipY) {
        this.filename = filename;
        this.flipX = flipX;
        this.flipY = flipY;
    }

    public String getFilename() {
        return filename;
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
                .add("filename", filename)
                .add("flipX", flipX)
                .add("flipY", flipY)
                .toString();
    }
}
