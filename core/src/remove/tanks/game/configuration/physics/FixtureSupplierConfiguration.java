package remove.tanks.game.configuration.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.filter.FilterPrototypeXmlLoader;
import remove.tanks.game.physics.fixture.FixtureFactory;
import remove.tanks.game.physics.fixture.FixturePrototypeXmlLoader;
import remove.tanks.game.physics.fixture.hitbox.HitBoxFactory;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrototypeXmlLoader;
import remove.tanks.game.physics.fixture.sensor.SensorFactory;
import remove.tanks.game.physics.fixture.sensor.SensorPrototypeXmlLoader;
import remove.tanks.game.physics.shape.ShapeFactory;
import remove.tanks.game.physics.shape.ShapePrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class FixtureSupplierConfiguration {
    @ComponentName("FixtureFactory")
    public static final class FixtureFactorySupplier extends ComponentSupplier<FixtureFactory> {
        @Override
        public FixtureFactory supplyComponent() {
            return new FixtureFactory(
                    getContext().getComponent("ShapeFactory", ShapeFactory.class)
            );
        }
    }

    @ComponentName("FixturePrototypeXmlLoader")
    public static final class FixturePrototypeXmlLoaderSupplier extends ComponentSupplier<FixturePrototypeXmlLoader> {
        @Override
        public FixturePrototypeXmlLoader supplyComponent() {
            return new FixturePrototypeXmlLoader(
                    getContext().getComponent("ShapePrototypeXmlLoader", ShapePrototypeXmlLoader.class),
                    getContext().getComponent("FilterPrototypeXmlLoader", FilterPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("SensorFactory")
    public static final class SensorFactorySupplier extends ComponentSupplier<SensorFactory> {
        @Override
        public SensorFactory supplyComponent() {
            return new SensorFactory(getContext().getComponent("FixtureFactory", FixtureFactory.class));
        }
    }

    @ComponentName("SensorPrototypeXmlLoader")
    public static final class SensorPrototypeXmlLoaderSupplier extends ComponentSupplier<SensorPrototypeXmlLoader> {
        @Override
        public SensorPrototypeXmlLoader supplyComponent() {
            return new SensorPrototypeXmlLoader(
                    getContext().getComponent("FixturePrototypeXmlLoader", FixturePrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("HitBoxFactory")
    public static final class HitBoxFactorySupplier extends ComponentSupplier<HitBoxFactory> {
        @Override
        public HitBoxFactory supplyComponent() {
            return new HitBoxFactory(
                    getContext().getComponent("FixtureFactory", FixtureFactory.class)
            );
        }
    }

    @ComponentName("HitBoxPrototypeXmlLoader")
    public static final class HitBoxPrototypeXmlLoaderSupplier extends ComponentSupplier<HitBoxPrototypeXmlLoader> {
        @Override
        public HitBoxPrototypeXmlLoader supplyComponent() {
            return new HitBoxPrototypeXmlLoader(
                    getContext().getComponent("FixturePrototypeXmlLoader", FixturePrototypeXmlLoader.class)
            );
        }
    }
}
