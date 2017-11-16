package remove.tanks.game.graphic.view;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.particle.ParticleEffectPrototype;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewPrototype implements ViewPrototype {
    private final String id;
    private final PositionPrototype positionPrototype;
    private final ParticleEffectPrototype particleEffectPrototype;

    public ParticleEffectViewPrototype(String id, PositionPrototype positionPrototype, ParticleEffectPrototype particleEffectPrototype) {
        this.id = id;
        this.positionPrototype = positionPrototype;
        this.particleEffectPrototype = particleEffectPrototype;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public ParticleEffectPrototype getParticleEffectPrototype() {
        return particleEffectPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("positionPrototype", positionPrototype)
                .add("particleEffectPrototype", particleEffectPrototype)
                .toString();
    }
}
