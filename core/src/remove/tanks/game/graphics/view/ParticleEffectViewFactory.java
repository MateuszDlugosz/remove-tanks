package remove.tanks.game.graphics.view;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.particle.ParticleEffectFactory;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.position.Position;
import remove.tanks.game.utility.surface.position.PositionFactory;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewFactory implements SubViewFactory<ParticleEffectView, ParticleEffectViewPrefab> {
    private final PositionFactory positionFactory;
    private final ParticleEffectFactory particleEffectFactory;

    public ParticleEffectViewFactory(PositionFactory positionFactory, ParticleEffectFactory particleEffectFactory) {
        this.positionFactory = positionFactory;
        this.particleEffectFactory = particleEffectFactory;
    }

    @Override
    public ParticleEffectView createView(ParticleEffectViewPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new ParticleEffectView(
                    prefab.getId(),
                    createPosition(prefab, scale),
                    createParticleEffect(prefab, assetStorage, scale)
            );
        } catch (Exception e) {
            throw new ViewCreateException(prefab, e);
        }
    }

    private Position createPosition(ParticleEffectViewPrefab prefab, Scale scale) {
        return positionFactory.createPosition(prefab.getPositionPrefab(), scale);
    }

    private ParticleEffect createParticleEffect(ParticleEffectViewPrefab prefab, AssetStorage assetStorage, Scale scale) {
        return particleEffectFactory.createParticleEffect(prefab.getParticleEffectPrefab(), assetStorage, scale);
    }

    @Override
    public Class<ParticleEffectViewPrefab> getFactoryType() {
        return ParticleEffectViewPrefab.class;
    }
}
