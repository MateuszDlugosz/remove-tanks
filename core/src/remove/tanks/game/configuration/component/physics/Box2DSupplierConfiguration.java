package remove.tanks.game.configuration.component.physics;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;

/**
 * @author Mateusz Długosz
 */
public final class Box2DSupplierConfiguration {
    @ComponentName("Box2DDebugRenderer")
    public static final class Box2DDebugRendererSupplier extends ComponentSupplier<Box2DDebugRenderer> {
        @Override
        public Box2DDebugRenderer supplyComponent() {
            return new Box2DDebugRenderer();
        }
    }
}
