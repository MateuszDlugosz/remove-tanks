package remove.tanks.game.configuration.component.graphics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.animation.AnimationFactory;
import remove.tanks.game.graphics.animation.AnimationPrefabXmlReader;
import remove.tanks.game.graphics.particle.ParticleEffectFactory;
import remove.tanks.game.graphics.particle.ParticleEffectPrefabXmlReader;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;
import remove.tanks.game.graphics.view.*;
import remove.tanks.game.graphics.view.renderer.*;
import remove.tanks.game.graphics.view.updater.ViewUpdater;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ViewConfiguration {
    @ComponentName("ViewPrefabXmlReader")
    public static final class ViewPrefabXmlReaderSupplier extends ComponentSupplier<ViewPrefabXmlReader> {
        @Override
        public ViewPrefabXmlReader supplyComponent() {
            return new ViewPrefabXmlReader(
                    new SubViewPrefabXmlReader[] {
                            new SpriteViewPrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                                    getContext().getComponent("SpritePrefabXmlReader", SpritePrefabXmlReader.class)
                            ),
                            new AnimationViewPrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                                    getContext().getComponent("AnimationPrefabXmlReader", AnimationPrefabXmlReader.class)
                            ),
                            new ParticleEffectViewPrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                                    getContext().getComponent("ParticleEffectPrefabXmlReader", ParticleEffectPrefabXmlReader.class)
                            )
                    }
            );
        }
    }

    @ComponentName("ViewFactory")
    public static final class ViewFactorySupplier extends ComponentSupplier<ViewFactory> {
        @Override
        public ViewFactory supplyComponent() {
            return new ViewFactory(
                    new SubViewFactory[] {
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

    @ComponentName("ViewUpdater")
    public static final class ViewUpdaterSupplier extends ComponentSupplier<ViewUpdater> {
        @Override
        public ViewUpdater supplyComponent() {
            return new ViewUpdater();
        }
    }

    @ComponentName("ViewRenderer")
    public static final class ViewRendererSupplier extends ComponentSupplier<ViewRenderer> {
        @Override
        public ViewRenderer supplyComponent() {
            return new ViewRenderer(
                    new SubViewRenderer[] {
                            new SpriteViewRenderer(),
                            new AnimationViewRenderer(),
                            new ParticleEffectViewRenderer()
                    }
            );
        }
    }
}
