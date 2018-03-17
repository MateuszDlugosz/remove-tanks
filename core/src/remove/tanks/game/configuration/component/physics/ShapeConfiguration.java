package remove.tanks.game.configuration.component.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.shape.*;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ShapeConfiguration {
    @ComponentName("ShapePrefabXmlReader")
    public static final class ShapePrefabXmlReaderSupplier extends ComponentSupplier<ShapePrefabXmlReader> {
        @Override
        public ShapePrefabXmlReader supplyComponent() {
            return new ShapePrefabXmlReader(
                    new SubShapePrefabXmlReader[] {
                            new RectangleShapePrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class)
                            ),
                            new CircleShapePrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class)
                            ),
                            new PolygonShapePrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                                    getContext().getComponent("VertexPrefabXmlReader", VertexPrefabXmlReader.class)
                            ),
                            new ChainShapePrefabXmlReader(
                                    getContext().getComponent("PositionPrefabXmlReader", PositionPrefabXmlReader.class),
                                    getContext().getComponent("VertexPrefabXmlReader", VertexPrefabXmlReader.class)
                            )
                    }
            );
        }
    }

    @ComponentName("ShapeFactory")
    public static final class ShapeFactorySupplier extends ComponentSupplier<ShapeFactory> {
        @Override
        public ShapeFactory supplyComponent() {
            return new ShapeFactory(
                    new SubShapeFactory[] {
                            new RectangleShapeFactory(),
                            new CircleShapeFactory(),
                            new PolygonShapeFactory(),
                            new ChainShapeFactory()
                    }
            );
        }
    }

    @ComponentName("VertexPrefabXmlReader")
    public static final class VertexPrefabXmlReaderSupplier extends ComponentSupplier<VertexPrefabXmlReader> {
        @Override
        public VertexPrefabXmlReader supplyComponent() {
            return new VertexPrefabXmlReader();
        }
    }
}
