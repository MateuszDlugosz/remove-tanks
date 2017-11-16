package remove.tanks.game.graphic.view;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectView implements View, UpdatableView, ResettableView {
    private final String id;
    private final Position position;
    private final ParticleEffect particleEffect;

    public ParticleEffectView(String id, Position position, ParticleEffect particleEffect) {
        this.id = id;
        this.position = position;
        this.particleEffect = particleEffect;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public ParticleEffect getParticleEffect() {
        return particleEffect;
    }

    @Override
    public void update(float delta) {
        particleEffect.update(delta);
    }

    @Override
    public void reset() {
        particleEffect.reset();
    }
}
