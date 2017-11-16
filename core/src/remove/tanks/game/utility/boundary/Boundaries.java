package remove.tanks.game.utility.boundary;

import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class Boundaries {
    private final float minX;
    private final float maxX;
    private final float minY;
    private final float maxY;

    public Boundaries(float minX, float maxX, float minY, float maxY) {
        if (minX > maxX) {
            throw new IllegalArgumentException("Min x cannot be greater than max x.");
        }
        if (minY > maxY) {
            throw new IllegalArgumentException("Min y cannot be greater than max y.");
        }

        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public float getMinX() {
        return minX;
    }

    public float getMaxX() {
        return maxX;
    }

    public float getMinY() {
        return minY;
    }

    public float getMaxY() {
        return maxY;
    }

    public float clampX(float value) {
        return MathUtils.clamp(value, minX, maxX);
    }

    public float clampY(float value) {
        return MathUtils.clamp(value, minY, maxY);
    }

    public boolean isInBoundaries(Position position) {
        return position.getX() >= minX
                && position.getX() <= maxX
                && position.getY() >= minY
                && position.getY() <= maxY;
    }

    public Position getCenterPosition() {
        return new Position(
                minX + ((maxX - minX) * 0.5f),
                minY + ((maxY - minY) * 0.5f)
        );
    }

    public static Boundaries valueOf(float minX, float maxX, float minY, float maxY) {
        return new Boundaries(minX, maxX, minY, maxY);
    }
}
