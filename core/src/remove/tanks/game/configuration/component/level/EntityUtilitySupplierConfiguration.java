package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.utility.direction.AvailableDirectionsXmlLoader;
import remove.tanks.game.level.engine.utility.direction.DirectionXmlLoader;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntryFactory;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntryPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.spwan.spawner.SpawnerFactory;
import remove.tanks.game.level.engine.utility.spwan.spawner.SpawnerPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class EntityUtilitySupplierConfiguration {
    @ComponentName("DirectionXmlLoader")
    public static final class DirectionXmlLoaderSupplier extends ComponentSupplier<DirectionXmlLoader> {
        @Override
        public DirectionXmlLoader supplyComponent() {
            return new DirectionXmlLoader();
        }
    }

    @ComponentName("AvailableDirectionsXmlLoader")
    public static final class AvailableDirectionsXmlLoaderSupplier extends ComponentSupplier<AvailableDirectionsXmlLoader> {
        @Override
        public AvailableDirectionsXmlLoader supplyComponent() {
            return new AvailableDirectionsXmlLoader(
                    getContext().getComponent("DirectionXmlLoader", DirectionXmlLoader.class)
            );
        }
    }

    @ComponentName("SpawnEntryFactory")
    public static final class SpawnEntryFactorySupplier extends ComponentSupplier<SpawnEntryFactory> {
        @Override
        public SpawnEntryFactory supplyComponent() {
            return new SpawnEntryFactory(
                    getContext().getComponent("PositionFactory", PositionFactory.class)
            );
        }
    }

    @ComponentName("SpawnEntryPrototypeXmlLoader")
    public static final class SpawnEntryPrototypeXmlLoaderSupplier extends ComponentSupplier<SpawnEntryPrototypeXmlLoader> {
        @Override
        public SpawnEntryPrototypeXmlLoader supplyComponent() {
            return new SpawnEntryPrototypeXmlLoader(
                    getContext().getComponent("PositionPrototypeXmlLoader", PositionPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("SpawnerPrototypeXmlLoader")
    public static final class SpawnerPrototypeXmlLoaderSupplier extends ComponentSupplier<SpawnerPrototypeXmlLoader> {
        @Override
        public SpawnerPrototypeXmlLoader supplyComponent() {
            return new SpawnerPrototypeXmlLoader();
        }
    }

    @ComponentName("SpawnerFactory")
    public static final class SpawnerFactorySupplier extends ComponentSupplier<SpawnerFactory> {
        @Override
        public SpawnerFactory supplyComponent() {
            return new SpawnerFactory();
        }
    }
}
