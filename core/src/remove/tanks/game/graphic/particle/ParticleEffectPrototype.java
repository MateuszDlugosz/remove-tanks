package remove.tanks.game.graphic.particle;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public interface ParticleEffectPrototype extends Serializable {
    boolean isFlipX();
    boolean isFlipY();
}
