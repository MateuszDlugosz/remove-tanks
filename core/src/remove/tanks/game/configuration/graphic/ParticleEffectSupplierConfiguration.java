package remove.tanks.game.configuration.graphic;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.particle.*;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectSupplierConfiguration {
    @ComponentName("ParticleEffectFactory")
    public static final class ParticleEffectFactorySupplier extends ComponentSupplier<ParticleEffectFactory> {
        @Override
        public ParticleEffectFactory supplyComponent() {
            return new ParticleEffectFactory(
                    new RegistrableParticleEffectFactory[] {
                            new FileParticleEffectFactory(),
                            new AtlasParticleEffectFactory()
                    }
            );
        }
    }

    @ComponentName("ParticleEffectPrototypeXmlLoader")
    public static final class ParticleEffectPrototypeXmlLoaderSupplier extends ComponentSupplier<ParticleEffectPrototypeXmlLoader> {
        @Override
        public ParticleEffectPrototypeXmlLoader supplyComponent() {
            return new ParticleEffectPrototypeXmlLoader(
                    new RegistrableParticleEffectPrototypeXmlLoader[] {
                            new FileParticleEffectPrototypeXmlLoader(),
                            new AtlasParticleEffectPrototypeXmlLoader()
                    }
            );
        }
    }
}
