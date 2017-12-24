package remove.tanks.game.configuration.physics;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.world.WorldFactory;
import remove.tanks.game.physics.world.renderer.WorldRenderer;
import remove.tanks.game.physics.world.updater.WorldUpdater;

/**
 * @author Mateusz Długosz
 */
public final class WorldSupplierConfiguration {
    @ComponentName("WorldFactory")
    public static final class WorldFactorySupplier extends ComponentSupplier<WorldFactory> {
        @Override
        public WorldFactory supplyComponent() {
            return new WorldFactory();
        }
    }

    @ComponentName("WorldRenderer")
    public static final class WorldRendererSupplier extends ComponentSupplier<WorldRenderer> {
        @Override
        public WorldRenderer supplyComponent() {
            return new WorldRenderer(getContext().getComponent("Box2DDebugRenderer", Box2DDebugRenderer.class));
        }
    }

    @ComponentName("WorldUpdater")
    public static final class WorldUpdaterSupplier extends ComponentSupplier<WorldUpdater> {
        @Override
        public WorldUpdater supplyComponent() {
            return new WorldUpdater(1/45f, 6, 2);
        }
    }
}
