package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableParticleEffectFactory<T extends ParticleEffectPrototype> {
    ParticleEffect createParticleEffect(T prototype, AssetStorage assetStorage, Scale scale);
    Class<T> getFactoryType();
}
