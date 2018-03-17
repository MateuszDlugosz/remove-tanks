package remove.tanks.game.graphics.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.ParticleEffectView;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewRenderer implements SubViewRenderer<ParticleEffectView> {
    @Override
    public void render(ParticleEffectView view, SpriteBatch spriteBatch, Position position, float angle) {
        try {
            view.getParticleEffect().setPosition(position.getX(), position.getY());
            spriteBatch.begin();
            view.getParticleEffect().draw(spriteBatch);
            spriteBatch.end();
        } catch (Exception e) {
            throw new ViewRenderException(view, e);
        }
    }

    @Override
    public Class<ParticleEffectView> getRendererType() {
        return ParticleEffectView.class;
    }
}
