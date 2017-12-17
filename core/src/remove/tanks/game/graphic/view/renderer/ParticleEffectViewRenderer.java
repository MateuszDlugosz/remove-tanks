package remove.tanks.game.graphic.view.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.view.ParticleEffectView;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewRenderer implements RegistrableViewRenderer<ParticleEffectView> {
    @Override
    public void render(ParticleEffectView view, SpriteBatch spriteBatch, Position position, float angle) {
        view.getParticleEffect().setPosition(position.getX(), position.getY());
        spriteBatch.begin();
        view.getParticleEffect().draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public Class<ParticleEffectView> getRendererType() {
        return ParticleEffectView.class;
    }
}
