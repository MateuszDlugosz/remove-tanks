package remove.tanks.game.graphics.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.View;
import remove.tanks.game.utility.surface.position.Position;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ViewRenderer {
    private final Map<Class<? extends View>, SubViewRenderer> renderers
            = new HashMap<>();

    public ViewRenderer(SubViewRenderer[] renderers) {
        Arrays.stream(renderers).forEach(s -> this.renderers.put(s.getRendererType(), s));
    }

    public void render(View view, SpriteBatch spriteBatch, Position position, float angle) {
        try {
            if (!renderers.containsKey(view.getClass())) {
                throw new ViewRendererNotFoundException(view.getClass());
            }
            view.getEffect().ifPresent(e -> e.begin(spriteBatch));
            renderers.get(view.getClass()).render(view, spriteBatch, position, angle);
            view.getEffect().ifPresent(e -> e.end(spriteBatch));
        } catch (Exception e) {
            throw new ViewRenderException(view, e);
        }
    }
}
