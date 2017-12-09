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
@SuppressWarnings("unchecked")
public final class ViewRenderer {
    private final Map<Class<? extends View>, RegistrableViewRenderer> renderers
            = new HashMap<>();

    public ViewRenderer(RegistrableViewRenderer[] renderers) {
        Arrays.stream(renderers).forEach(s -> this.renderers.put(s.getRendererType(), s));
    }

    public void render(View view, SpriteBatch spriteBatch, Position position, float angle) {
        Class<? extends View> viewClass = view.getClass();
        if (!renderers.containsKey(viewClass)) {
            throw new ViewRendererNotFoundException(viewClass.toString());
        }
        renderers.get(viewClass).render(view, spriteBatch, position, angle);
    }
}
