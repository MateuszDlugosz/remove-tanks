package remove.tanks.game.graphic.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.view.SpriteView;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewRenderer implements RegistrableViewRenderer<SpriteView> {
    @Override
    public void render(SpriteView view, SpriteBatch spriteBatch, Position position, float angle) {
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
    }

    @Override
    public Class<SpriteView> getRendererType() {
        return SpriteView.class;
    }
}
