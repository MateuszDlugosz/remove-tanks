package remove.tanks.game.configuration.component.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.graphics.color.ColorFactory;
import remove.tanks.game.graphics.color.ColorPrefabXmlReader;
import remove.tanks.game.physics.light.*;
import remove.tanks.game.physics.light.world.WorldLightFactory;
import remove.tanks.game.physics.light.world.WorldLightPropertyTranslator;
import remove.tanks.game.physics.light.world.renderer.WorldLightRenderer;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class LightConfiguration {
    @ComponentName("LightPrefabXmlReader")
    public static final class LightPrefabXmlReaderSupplier extends ComponentSupplier<LightPrefabXmlReader> {
        @Override
        public LightPrefabXmlReader supplyComponent() {
            return new LightPrefabXmlReader(
                    new SubLightPrefabXmlReader[] {
                            new PointLightPrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                                    getContext().getComponent("ColorPrefabXmlReader", ColorPrefabXmlReader.class)
                            ),
                            new ConeLightPrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                                    getContext().getComponent("ColorPrefabXmlReader", ColorPrefabXmlReader.class)
                            ),
                            new DirectionalLightPrefabXmlReader(
                                    getContext().getComponent("ColorPrefabXmlReader", ColorPrefabXmlReader.class)
                            )
                    }
            );
        }
    }

    @ComponentName("LightFactory")
    public static final class LightFactorySupplier extends ComponentSupplier<LightFactory> {
        @Override
        public LightFactory supplyComponent() {
            return new LightFactory(
                    new SubLightFactory[] {
                            new PointLightFactory(
                                    getContext().getComponent("ColorFactory", ColorFactory.class)
                            ),
                            new ConeLightFactory(
                                    getContext().getComponent("ColorFactory", ColorFactory.class)
                            ),
                            new DirectionalLightFactory(
                                    getContext().getComponent("ColorFactory", ColorFactory.class)
                            )
                    }
            );
        }
    }

    @ComponentName("LightHandlerPrefabXmlReader")
    public static final class LightHandlerPrefabXmlReaderSupplier extends ComponentSupplier<LightHandlerPrefabXmlReader> {
        @Override
        public LightHandlerPrefabXmlReader supplyComponent() {
            return new LightHandlerPrefabXmlReader(
                    getContext().getComponent("LightPrefabXmlReader", LightPrefabXmlReader.class)
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

    @ComponentName("WorldLightFactory")
    public static final class WorldLightFactorySupplier extends ComponentSupplier<WorldLightFactory> {
        @Override
        public WorldLightFactory supplyComponent() {
            return new WorldLightFactory(
                    Integer.valueOf(
                            getContext().getConfiguration().getOption(
                                    ConfigurationOption.GameWorldLightNumberOfRays.getName())
                    )
            );
        }
    }

    @ComponentName("WorldLightRenderer")
    public static final class WorldLightRendererSupplier extends ComponentSupplier<WorldLightRenderer> {
        @Override
        public WorldLightRenderer supplyComponent() {
            return new WorldLightRenderer();
        }
    }

    @ComponentName("WorldLightPropertyTranslator")
    public static final class WorldLightPropertyTranslatorSupplier extends ComponentSupplier<WorldLightPropertyTranslator> {
        @Override
        public WorldLightPropertyTranslator supplyComponent() {
            return new WorldLightPropertyTranslator();
        }
    }
}
