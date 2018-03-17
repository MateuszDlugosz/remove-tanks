package remove.tanks.game.configuration.component.graphics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.animation.*;

/**
 * @author Mateusz Długosz
 */
public final class AnimationConfiguration {
    @ComponentName("AnimationPrefabXmlReader")
    public static final class AnimationPrefabXmlReaderSupplier extends ComponentSupplier<AnimationPrefabXmlReader> {
        @Override
        public AnimationPrefabXmlReader supplyComponent() {
            return new AnimationPrefabXmlReader(
                    new SubAnimationPrefabXmlReader[] {
                            new FileAnimationPrefabXmlReader(),
                            new AtlasAnimationPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("AnimationFactory")
    public static final class AnimationFactorySupplier extends ComponentSupplier<AnimationFactory> {
        @Override
        public AnimationFactory supplyComponent() {
            return new AnimationFactory(
                    new SubAnimationFactory[] {
                            new FileAnimationFactory(),
                            new AtlasAnimationFactory()
                    }
            );
        }
    }
}
