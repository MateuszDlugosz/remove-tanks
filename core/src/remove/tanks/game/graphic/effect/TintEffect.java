package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Mateusz Długosz
 */
public final class TintEffect implements Effect {
    private final Color color;
    private Color previousColor;

    public TintEffect(Color color) {
        this.color = color;
    }

    @Override
    public void begin(SpriteBatch spriteBatch) {
        previousColor = spriteBatch.getColor();
        spriteBatch.setColor(color);
    }

    @Override
    public void end(SpriteBatch spriteBatch) {
        spriteBatch.setColor(previousColor);
    }
}
