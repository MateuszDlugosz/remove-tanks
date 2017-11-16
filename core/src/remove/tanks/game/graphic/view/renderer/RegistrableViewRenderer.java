package remove.tanks.game.graphic.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.view.View;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableViewRenderer<T extends View> {
    void render(T view, SpriteBatch spriteBatch, Position position, float angle);
    Class<T> getRendererType();
}
