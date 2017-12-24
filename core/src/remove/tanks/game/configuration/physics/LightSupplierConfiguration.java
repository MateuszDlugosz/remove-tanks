package remove.tanks.game.configuration.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.color.ColorFactory;
import remove.tanks.game.graphic.color.ColorPrototypeXmlLoader;
import remove.tanks.game.physics.light.*;
import remove.tanks.game.physics.light.world.WorldLightFactory;
import remove.tanks.game.physics.light.world.renderer.WorldLightRenderer;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class LightSupplierConfiguration {
    @ComponentName("LightFactory")
    public static final class LightFactorySupplier extends ComponentSupplier<LightFactory> {
        @Override
        public LightFactory supplyComponent() {
            return new LightFactory(
                    new RegistrableLightFactory[] {
                            new PointLightFactory(getContext().getComponent("ColorFactory", ColorFactory.class)),
                            new ConeLightFactory(getContext().getComponent("ColorFactory", ColorFactory.class)),
                            new DirectionalLightFactory(getContext().getComponent("ColorFactory", ColorFactory.class))
                    }
            );
        }
    }

    @ComponentName("LightPrototypeXmlLoader")
    public static final class LightPrototypeXmlLoaderSupplier extends ComponentSupplier<LightPrototypeXmlLoader> {
        @Override
        public LightPrototypeXmlLoader supplyComponent() {
            return new LightPrototypeXmlLoader(
                    new RegistrableLightPrototypeXmlLoader[] {
                            new PointLightPrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class),
                                    getContext().getComponent("ColorPrototypeXmlLoader", ColorPrototypeXmlLoader.class)
                            ),
                            new ConeLightPrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class),
                                    getContext().getComponent("ColorPrototypeXmlLoader", ColorPrototypeXmlLoader.class)
                            ),
                            new DirectionalLightPrototypeXmlLoader(
                                    getContext().getComponent("ColorPrototypeXmlLoader", ColorPrototypeXmlLoader.class)
                            )
                    }
            );
        }
    }

    @ComponentName("LightHandlerFactory")
    public static final class LightHandlerFactorySupplier extends ComponentSupplier<LightHandlerFactory> {
        @Override
        public LightHandlerFactory supplyComponent() {
            return new LightHandlerFactory(
                    getContext().getComponent("LightFactory", LightFactory.class)
            );
        }
    }

    @ComponentName("LightHandlerPrototypeXmlLoader")
    public static final class LightHandlerPrototypeXmlLoaderSupplier extends ComponentSupplier<LightHandlerPrototypeXmlLoader> {
        @Override
        public LightHandlerPrototypeXmlLoader supplyComponent() {
            return new LightHandlerPrototypeXmlLoader(
                    getContext().getComponent("LightPrototypeXmlLoader", LightPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("WorldLightFactory")
    public static final class WorldLightFactorySupplier extends ComponentSupplier<WorldLightFactory> {
        @Override
        public WorldLightFactory supplyComponent() {
            return new WorldLightFactory();
        }
    }

    @ComponentName("WorldLightRenderer")
    public static final class WorldLightRendererSupplier extends ComponentSupplier<WorldLightRenderer> {
        @Override
        public WorldLightRenderer supplyComponent() {
            return new WorldLightRenderer();
        }
    }
}
