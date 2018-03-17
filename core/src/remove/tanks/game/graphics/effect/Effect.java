package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Mateusz Długosz
 */
public interface Effect {
    void begin(SpriteBatch spriteBatch);
    void end(SpriteBatch spriteBatch);
}
