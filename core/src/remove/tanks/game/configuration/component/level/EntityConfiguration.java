package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.entity.*;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabMapObjectReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReader;
import remove.tanks.game.level.preload.PreloadDataXmlReader;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefabMapObjectReader;

/**
 * @author Mateusz Długosz
 */
public final class EntityConfiguration {
    @ComponentName("EntityFactory")
    public static final class EntityFactorySupplier extends ComponentSupplier<EntityFactory> {
        @Override
        public EntityFactory supplyComponent() {
            return new EntityFactory(
                    getContext().getComponent("ComponentFactory", ComponentFactory.class)
            );
        }
    }

    @ComponentName("EntityPrefabStorageFactory")
    public static final class EntityPrefabStorageFactorySupplier extends ComponentSupplier<EntityPrefabStorageFactory> {
        @Override
        public EntityPrefabStorageFactory supplyComponent() {
            return new EntityPrefabStorageFactory(
                    getContext().getComponent("EntityPrefabXmlReader", EntityPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("EntityPrefabXmlReader")
    public static final class EntityPrefabXmlReaderSupplier extends ComponentSupplier<EntityPrefabXmlReader> {
        @Override
        public EntityPrefabXmlReader supplyComponent() {
            return new EntityPrefabXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("PreloadDataXmlReader", PreloadDataXmlReader.class),
                    getContext().getComponent("ComponentPrefabXmlReader", ComponentPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("EntityPrefabRepositoryXmlReader")
    public static final class EntityPrefabFilenameRepositoryXmlReaderSupplier extends ComponentSupplier<EntityPrefabRepositoryXmlReader> {
        @Override
        public EntityPrefabRepositoryXmlReader supplyComponent() {
            return new EntityPrefabRepositoryXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }

    @ComponentName("EntityPrefabCodeXmlReader")
    public static final class EntityPrefabCodeXmlReaderSupplier extends ComponentSupplier<EntityPrefabCodeXmlReader> {
        @Override
        public EntityPrefabCodeXmlReader supplyComponent() {
            return new EntityPrefabCodeXmlReader();
        }
    }

    @ComponentName("EntityTiledMapInitializer")
    public static final class EntityTiledMapInitializerSupplier extends ComponentSupplier<EntityTiledMapInitializer> {
        @Override
        public EntityTiledMapInitializer supplyComponent() {
            return new EntityTiledMapInitializer(
                    getContext().getComponent("EntityPrefabCodeMapObjectReader", EntityPrefabCodeMapObjectReader.class),
                    getContext().getComponent("ComponentPrefabMapObjectReader", ComponentPrefabMapObjectReader.class),
                    getContext().getComponent("PositionPrefabMapObjectReader", PositionPrefabMapObjectReader.class),
                    getContext().getComponent("PositionFactory", PositionFactory.class)
            );
        }
    }

    @ComponentName("EntityPrefabCodeMapObjectReader")
    public static final class EntityPrefabCodeMapObjectReaderSupplier extends ComponentSupplier<EntityPrefabCodeMapObjectReader> {
        @Override
        public EntityPrefabCodeMapObjectReader supplyComponent() {
            return new EntityPrefabCodeMapObjectReader();
        }
    }
}
