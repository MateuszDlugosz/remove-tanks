package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Mateusz Długosz
 */
public final class AlphaEffect implements Effect {
    private final float alphaValue;
    private Color previousColor;

    public AlphaEffect(float alphaValue) {
        this.alphaValue = alphaValue;
    }

    @Override
    public void begin(SpriteBatch spriteBatch) {
        previousColor = spriteBatch.getColor();
        spriteBatch.setColor(new Color(
                previousColor.r,
                previousColor.g,
                previousColor.b,
                alphaValue
        ));
    }

    @Override
    public void end(SpriteBatch spriteBatch) {
        spriteBatch.setColor(previousColor);
    }
}
