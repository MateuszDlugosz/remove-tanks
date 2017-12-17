package remove.tanks.game.graphic.view;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphic.particle.ParticleEffectFactory;
import remove.tanks.game.utility.position.Position;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewFactory implements RegistrableViewFactory<ParticleEffectView, ParticleEffectViewPrototype> {
    private final PositionFactory positionFactory;
    private final ParticleEffectFactory particleEffectFactory;

    public ParticleEffectViewFactory(PositionFactory positionFactory, ParticleEffectFactory particleEffectFactory) {
        this.positionFactory = positionFactory;
        this.particleEffectFactory = particleEffectFactory;
    }

    @Override
    public ParticleEffectView createView(ParticleEffectViewPrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            return new ParticleEffectView(
                    prototype.getId(),
                    createPosition(prototype, scale),
                    createParticleEffect(prototype, assetStorage, scale)
            );
        } catch (Exception e) {
            throw new ViewCreateException(prototype, e);
        }
    }

    private Position createPosition(ParticleEffectViewPrototype prototype, Scale scale) {
        return positionFactory.createPosition(prototype.getPositionPrototype(), scale);
    }

    private ParticleEffect createParticleEffect(ParticleEffectViewPrototype prototype, AssetStorage assetStorage, Scale scale) {
        return particleEffectFactory.createParticleEffect(prototype.getParticleEffectPrototype(), assetStorage, scale);
    }

    @Override
    public Class<ParticleEffectViewPrototype> getFactoryType() {
        return ParticleEffectViewPrototype.class;
    }
}
