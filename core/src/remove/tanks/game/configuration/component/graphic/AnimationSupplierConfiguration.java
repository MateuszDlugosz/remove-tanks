package remove.tanks.game.configuration.component.graphic;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.animation.*;

/**
 * @author Mateusz Długosz
 */
public final class AnimationSupplierConfiguration {
    @ComponentName("AnimationFactory")
    public static final class AnimationFactorySupplier extends ComponentSupplier<AnimationFactory> {
        @Override
        public AnimationFactory supplyComponent() {
            return new AnimationFactory(
                    new RegistrableAnimationFactory[] {
                            new FileAnimationFactory(),
                            new AtlasAnimationFactory()
                    }
            );
        }
    }

    @ComponentName("AnimationPrototypeXmlLoader")
    public static final class AnimationPrototypeXmlLoaderSupplier extends ComponentSupplier<AnimationPrototypeXmlLoader> {
        @Override
        public AnimationPrototypeXmlLoader supplyComponent() {
            return new AnimationPrototypeXmlLoader(
                    new RegistrableAnimationPrototypeXmlLoader[] {
                            new FileAnimationPrototypeXmlLoader(),
                            new AtlasAnimationPrototypeXmlLoader()
                    }
            );
        }
    }
}
