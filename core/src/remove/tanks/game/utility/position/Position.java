package remove.tanks.game.utility.position;

import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class Position implements Serializable {
    public static final Position POSITION_ZERO = new Position(0,0);

    private final float x;
    private final float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Vector2 getAsVector2() {
        return new Vector2(x, y);
    }

    public Position sum(Position position) {
        return new Position(x + position.getX(), y + position.getY());
    }

    public static Position valueOf(float x, float y) {
        return new Position(x, y);
    }
}
