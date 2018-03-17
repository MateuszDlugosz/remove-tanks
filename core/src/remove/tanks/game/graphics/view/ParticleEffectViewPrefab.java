package remove.tanks.game.graphics.view;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.particle.ParticleEffectPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewPrefab extends ViewPrefab {
    private final String id;
    private final PositionPrefab positionPrefab;
    private final ParticleEffectPrefab particleEffectPrefab;

    public ParticleEffectViewPrefab(String id, PositionPrefab positionPrefab, ParticleEffectPrefab particleEffectPrefab) {
        this.id = id;
        this.positionPrefab = positionPrefab;
        this.particleEffectPrefab = particleEffectPrefab;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public ParticleEffectPrefab getParticleEffectPrefab() {
        return particleEffectPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("positionPrefab", positionPrefab)
                .add("particleEffectPrefab", particleEffectPrefab)
                .toString();
    }
}
