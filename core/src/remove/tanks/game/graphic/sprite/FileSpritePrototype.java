package remove.tanks.game.graphic.sprite;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class FileSpritePrototype implements SpritePrototype {
    private final String filename;
    private final boolean flipX;
    private final boolean flipY;

    public FileSpritePrototype(String filename, boolean flipX, boolean flipY) {
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
