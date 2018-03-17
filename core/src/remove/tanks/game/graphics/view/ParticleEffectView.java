package remove.tanks.game.graphics.view;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.utility.surface.position.Position;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectView implements View, UpdatableView, ResettableView {
    private final String id;
    private final Position position;
    private final ParticleEffect particleEffect;
    private Effect effect;

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

    @Override
    public Optional<Effect> getEffect() {
        return Optional.ofNullable(effect);
    }

    @Override
    public void setEffect(Effect effect) {
        this.effect = effect;
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
