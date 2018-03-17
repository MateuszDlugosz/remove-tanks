package remove.tanks.game.configuration.component.graphics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.particle.*;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectConfiguration {
    @ComponentName("ParticleEffectPrefabXmlReader")
    public static final class ParticleEffectPrefabXmlReaderSupplier extends ComponentSupplier<ParticleEffectPrefabXmlReader> {
        @Override
        public ParticleEffectPrefabXmlReader supplyComponent() {
            return new ParticleEffectPrefabXmlReader(
                    new SubParticleEffectPrefabXmlReader[] {
                            new FileParticleEffectPrefabXmlReader(),
                            new AtlasParticleEffectPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("ParticleEffectFactory")
    public static final class ParticleEffectFactorySupplier extends ComponentSupplier<ParticleEffectFactory> {
        @Override
        public ParticleEffectFactory supplyComponent() {
            return new ParticleEffectFactory(
                    new SubParticleEffectFactory[] {
                            new FileParticleEffectFactory(),
                            new AtlasParticleEffectFactory()
                    }
            );
        }
    }
}
