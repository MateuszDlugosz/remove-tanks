package remove.tanks.game.configuration.component.graphic;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.animation.AnimationFactory;
import remove.tanks.game.graphic.animation.AnimationPrototypeXmlLoader;
import remove.tanks.game.graphic.particle.ParticleEffectFactory;
import remove.tanks.game.graphic.particle.ParticleEffectPrototypeXmlLoader;
import remove.tanks.game.graphic.sprite.SpriteFactory;
import remove.tanks.game.graphic.sprite.SpritePrototypeXmlLoader;
import remove.tanks.game.graphic.view.*;
import remove.tanks.game.graphic.view.renderer.*;
import remove.tanks.game.graphic.view.updater.ViewUpdater;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ViewSupplierConfiguration {
    @ComponentName("ViewFactory")
    public static final class ViewFactorySupplier extends ComponentSupplier<ViewFactory> {
        @Override
        public ViewFactory supplyComponent() {
            return new ViewFactory(
                    new RegistrableViewFactory[] {
                            new SpriteViewFactory(
                                    getContext().getComponent("PositionFactory", PositionFactory.class),
                                    getContext().getComponent("SpriteFactory", SpriteFactory.class)
                            ),
                            new AnimationViewFactory(
                                    getContext().getComponent("PositionFactory", PositionFactory.class),
                                    getContext().getComponent("AnimationFactory", AnimationFactory.class)
                            ),
                            new ParticleEffectViewFactory(
                                    getContext().getComponent("PositionFactory", PositionFactory.class),
                                    getContext().getComponent("ParticleEffectFactory", ParticleEffectFactory.class)
                            )
                    }
            );
        }
    }

    @ComponentName("ViewPrototypeXmlLoader")
    public static final class ViewPrototypeXmlLoaderSupplier extends ComponentSupplier<ViewPrototypeXmlLoader> {
        @Override
        public ViewPrototypeXmlLoader supplyComponent() {
            return new ViewPrototypeXmlLoader(
                    new RegistrableViewPrototypeXmlLoader[] {
                            new SpriteViewPrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class),
                                    getContext().getComponent("SpritePrototypeXmlLoader", SpritePrototypeXmlLoader.class)
                            ),
                            new AnimationViewPrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class),
                                    getContext().getComponent("AnimationPrototypeXmlLoader", AnimationPrototypeXmlLoader.class)
                            ),
                            new ParticleEffectViewPrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class),
                                    getContext().getComponent("ParticleEffectPrototypeXmlLoader", ParticleEffectPrototypeXmlLoader.class)
                            )
                    }
            );
        }
    }

    @ComponentName("ViewRenderer")
    public static final class ViewRendererSupplier extends ComponentSupplier<ViewRenderer> {
        @Override
        public ViewRenderer supplyComponent() {
            return new ViewRenderer(
                    new RegistrableViewRenderer[] {
                            new SpriteViewRenderer(),
                            new AnimationViewRenderer(),
                            new ParticleEffectViewRenderer()
                    }
            );
        }
    }

    @ComponentName("ViewUpdater")
    public static final class ViewUpdaterSupplier extends ComponentSupplier<ViewUpdater> {
        @Override
        public ViewUpdater supplyComponent() {
            return new ViewUpdater();
        }
    }
}
