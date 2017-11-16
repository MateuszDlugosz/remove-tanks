package remove.tanks.game.configuration.component.graphic;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.particle.ParticleEffectFactory;
import remove.tanks.game.graphic.particle.ParticleEffectPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectSupplierConfiguration {
    @ComponentName("ParticleEffectFactory")
    public static final class ParticleEffectFactorySupplier extends ComponentSupplier<ParticleEffectFactory> {
        @Override
        public ParticleEffectFactory supplyComponent() {
            return new ParticleEffectFactory();
        }
    }

    @ComponentName("ParticleEffectPrototypeXmlLoader")
    public static final class ParticleEffectPrototypeXmlLoaderSupplier extends ComponentSupplier<ParticleEffectPrototypeXmlLoader> {
        @Override
        public ParticleEffectPrototypeXmlLoader supplyComponent() {
            return new ParticleEffectPrototypeXmlLoader();
        }
    }
}
