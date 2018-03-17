package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface SubParticleEffectFactory<T extends ParticleEffectPrefab> {
    ParticleEffect createParticleEffect(T prefab, AssetStorage assetStorage, Scale scale);
    Class<T> getFactoryType();
}
