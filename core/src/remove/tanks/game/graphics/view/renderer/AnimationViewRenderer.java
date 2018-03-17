package remove.tanks.game.graphics.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.AnimationView;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class AnimationViewRenderer implements SubViewRenderer<AnimationView> {
    @Override
    public void render(AnimationView view, SpriteBatch spriteBatch, Position position, float angle) {
        try {
            float width = view.getCurrentSprite().getWidth();
            float height = view.getCurrentSprite().getHeight();
            float posX = position.getX() - ((width - view.getPosition().getX()) * 0.5f);
            float posY = position.getY() - ((height - view.getPosition().getY()) * 0.5f);
            float origX = ((width - view.getPosition().getX())) * 0.5f;
            float origY = ((height - view.getPosition().getY())) * 0.5f;
            spriteBatch.begin();
            spriteBatch.draw(
                    view.getCurrentSprite(),
                    posX, posY,
                    origX, origY,
                    width, height,
                    1, 1,
                    angle
            );
            spriteBatch.end();
        } catch (Exception e) {
            throw new ViewRenderException(view, e);
        }
    }

    @Override
    public Class<AnimationView> getRendererType() {
        return AnimationView.class;
    }
}
