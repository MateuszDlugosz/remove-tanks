package remove.tanks.game.configuration.component.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.filter.FilterPrefabXmlReader;
import remove.tanks.game.physics.fixture.FixtureFactory;
import remove.tanks.game.physics.fixture.FixturePrefabXmlReader;
import remove.tanks.game.physics.fixture.hitbox.HitBoxFactory;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrefabXmlReader;
import remove.tanks.game.physics.fixture.sensor.SensorFactory;
import remove.tanks.game.physics.fixture.sensor.SensorPrefabXmlReader;
import remove.tanks.game.physics.shape.ShapeFactory;
import remove.tanks.game.physics.shape.ShapePrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class FixtureConfiguration {
    @ComponentName("FixturePrefabXmlReader")
    public static final class FixturePrefabXmlReaderSupplier extends ComponentSupplier<FixturePrefabXmlReader> {
        @Override
        public FixturePrefabXmlReader supplyComponent() {
            return new FixturePrefabXmlReader(
                    getContext().getComponent("ShapePrefabXmlReader", ShapePrefabXmlReader.class),
                    getContext().getComponent("FilterPrefabXmlReader", FilterPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("FixtureFactory")
    public static final class FixtureFactorySupplier extends ComponentSupplier<FixtureFactory> {
        @Override
        public FixtureFactory supplyComponent() {
            return new FixtureFactory(
                    getContext().getComponent("ShapeFactory", ShapeFactory.class)
            );
        }
    }

    @ComponentName("HitBoxPrefabXmlReader")
    public static final class HitBoxPrefabXmlReaderSupplier extends ComponentSupplier<HitBoxPrefabXmlReader> {
        @Override
        public HitBoxPrefabXmlReader supplyComponent() {
            return new HitBoxPrefabXmlReader(
                    getContext().getComponent("FixturePrefabXmlReader", FixturePrefabXmlReader.class)
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

    @ComponentName("SensorPrefabXmlReader")
    public static final class SensorPrefabXmlReaderSupplier extends ComponentSupplier<SensorPrefabXmlReader> {
        @Override
        public SensorPrefabXmlReader supplyComponent() {
            return new SensorPrefabXmlReader(
                    getContext().getComponent("FixturePrefabXmlReader", FixturePrefabXmlReader.class)
            );
        }
    }

    @ComponentName("SensorFactory")
    public static final class SensorFactorySupplier extends ComponentSupplier<SensorFactory> {
        @Override
        public SensorFactory supplyComponent() {
            return new SensorFactory(
                    getContext().getComponent("FixtureFactory", FixtureFactory.class)
            );
        }
    }
}
