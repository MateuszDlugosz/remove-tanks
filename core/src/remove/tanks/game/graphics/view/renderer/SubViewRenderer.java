package remove.tanks.game.graphics.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.View;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public interface SubViewRenderer<T extends View> {
    void render(T view, SpriteBatch spriteBatch, Position position, float angle);
    Class<T> getRendererType();
}
