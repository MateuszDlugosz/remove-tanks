package remove.tanks.game.graphic.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.view.View;
import remove.tanks.game.utility.position.Position;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ViewRenderer {
    private final Map<Class<? extends View>, RegistrableViewRenderer> subRenderers
            = new HashMap<>();

    public ViewRenderer(RegistrableViewRenderer[] subRenderers) {
        Arrays.stream(subRenderers).forEach(s -> this.subRenderers.put(s.getRendererType(), s));
    }

    public void render(View view, SpriteBatch spriteBatch, Position position, float angle) {
        Class<? extends View> viewClass = view.getClass();
        if (!subRenderers.containsKey(viewClass)) {
            throw new ViewRendererNotFoundException(viewClass.toString());
        }
        subRenderers.get(viewClass).render(view, spriteBatch, position, angle);
    }
}
