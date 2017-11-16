package remove.tanks.game.configuration.component.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.shape.*;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ShapeSupplierConfiguration {
    @ComponentName("ShapeFactory")
    public static final class ShapeFactorySupplier extends ComponentSupplier<ShapeFactory> {
        @Override
        public ShapeFactory supplyComponent() {
            return new ShapeFactory(
                    new RegistrableShapeFactory[] {
                            new RectangleShapeFactory(),
                            new CircleShapeFactory(),
                            new PolygonShapeFactory(),
                            new ChainShapeFactory()
                    }
            );
        }
    }

    @ComponentName("VertexPrototypeXmlLoader")
    public static final class VertexPrototypeXmlLoaderSupplier extends ComponentSupplier<VertexPrototypeXmlLoader> {
        @Override
        public VertexPrototypeXmlLoader supplyComponent() {
            return new VertexPrototypeXmlLoader();
        }
    }

    @ComponentName("ShapePrototypeXmlLoader")
    public static final class ShapePrototypeXmlLoaderSupplier extends ComponentSupplier<ShapePrototypeXmlLoader> {
        @Override
        public ShapePrototypeXmlLoader supplyComponent() {
            return new ShapePrototypeXmlLoader(
                    new RegistrableShapePrototypeXmlLoader[] {
                            new RectangleShapePrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class)
                            ),
                            new CircleShapePrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class)
                            ),
                            new PolygonShapePrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class),
                                    getContext().getComponent("VertexPrototypeXmlLoader", VertexPrototypeXmlLoader.class)
                            ),
                            new ChainShapePrototypeXmlLoader(
                                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class),
                                    getContext().getComponent("VertexPrototypeXmlLoader", VertexPrototypeXmlLoader.class)
                            )
                    }
            );
        }
    }
}
