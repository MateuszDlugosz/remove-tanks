package remove.tanks.game.graphics.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.SpriteView;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewRenderer implements SubViewRenderer<SpriteView> {
    @Override
    public void render(SpriteView view, SpriteBatch spriteBatch, Position position, float angle) {
        try {
            float width = view.getSprite().getWidth();
            float height = view.getSprite().getHeight();
            float posX = position.getX() - ((width - view.getPosition().getX()) * 0.5f);
            float posY = position.getY() - ((height - view.getPosition().getY()) * 0.5f);
            float origX = ((width - view.getPosition().getX())) * 0.5f;
            float origY = ((height - view.getPosition().getY())) * 0.5f;
            spriteBatch.begin();
            spriteBatch.draw(
                    view.getSprite(),
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
    public Class<SpriteView> getRendererType() {
        return SpriteView.class;
    }
}
