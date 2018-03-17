package remove.tanks.game.configuration.component.physics;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.physics.world.WorldFactory;
import remove.tanks.game.physics.world.WorldPropertyTranslator;
import remove.tanks.game.physics.world.renderer.WorldRenderer;
import remove.tanks.game.physics.world.updater.WorldUpdater;

/**
 * @author Mateusz Długosz
 */
public final class WorldConfiguration {
    @ComponentName("WorldFactory")
    public static final class WorldFactorySupplier extends ComponentSupplier<WorldFactory> {
        @Override
        public WorldFactory supplyComponent() {
            return new WorldFactory();
        }
    }

    @ComponentName("WorldUpdater")
    public static final class WorldUpdaterSupplier extends ComponentSupplier<WorldUpdater> {
        @Override
        public WorldUpdater supplyComponent() {
            return new WorldUpdater(
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameWorldUpdateTimeStep.getName())),
                    Integer.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameWorldUpdateVelocityIterations.getName())),
                    Integer.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameWorldUpdatePositionIterations.getName()))
            );
        }
    }

    @ComponentName("Box2DDebugRenderer")
    public static final class Box2DDebugRendererSupplier extends ComponentSupplier<Box2DDebugRenderer> {
        @Override
        public Box2DDebugRenderer supplyComponent() {
            return new Box2DDebugRenderer();
        }
    }

    @ComponentName("WorldRenderer")
    public static final class WorldRendererSupplier extends ComponentSupplier<WorldRenderer> {
        @Override
        public WorldRenderer supplyComponent() {
            return new WorldRenderer(getContext().getComponent("Box2DDebugRenderer", Box2DDebugRenderer.class));
        }
    }

    @ComponentName("WorldPropertyTranslator")
    public static final class WorldPropertyTranslatorSupplier extends ComponentSupplier<WorldPropertyTranslator> {
        @Override
        public WorldPropertyTranslator supplyComponent() {
            return new WorldPropertyTranslator();
        }
    }
}
