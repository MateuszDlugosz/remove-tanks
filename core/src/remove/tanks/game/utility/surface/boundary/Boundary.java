package remove.tanks.game.utility.surface.boundary;

import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class Boundary {
    public static final Boundary BOUNDARY_ZERO = new Boundary(0, 0, 0, 0);

    private final float minX;
    private final float maxX;
    private final float minY;
    private final float maxY;

    public Boundary(float minX, float maxX, float minY, float maxY) {
        if (minX > maxX) throw new InvalidBoundaryValueException(InvalidBoundaryValueException.Axis.X);
        if (minY > maxY) throw new InvalidBoundaryValueException(InvalidBoundaryValueException.Axis.Y);

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

    public boolean isInBoundary(Position position) {
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

    public float getWidth() {
        return maxX - minX;
    }

    public float getHeight() {
        return maxY - minY;
    }

    public static Boundary valueOf(float minX, float maxX, float minY, float maxY) {
        return new Boundary(minX, maxX, minY, maxY);
    }
}
