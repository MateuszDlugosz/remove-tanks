package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.entity.*;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class EntitySupplierConfiguration {
    @ComponentName("EntityFactory")
    public static final class EntityFactorySupplier extends ComponentSupplier<EntityFactory> {
        @Override
        public EntityFactory supplyComponent() {
            return new EntityFactory(getContext().getComponent("ComponentFactory", ComponentFactory.class));
        }
    }

    @ComponentName("EntityPrototypeXmlLoader")
    public static final class EntityPrototypeXmlLoaderSupplier extends ComponentSupplier<EntityPrototypeXmlLoader> {
        @Override
        public EntityPrototypeXmlLoader supplyComponent() {
            return new EntityPrototypeXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("ComponentPrototypeXmlLoader", ComponentPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("EntityPrototypeRepositoryXmlLoader")
    public static final class EntityPrototypeRepositoryXmlLoaderSupplier extends ComponentSupplier<EntityPrototypeRepositoryXmlLoader> {
        @Override
        public EntityPrototypeRepositoryXmlLoader supplyComponent() {
            return new EntityPrototypeRepositoryXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("EntityPrototypeXmlLoader", EntityPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("EntitySpawner")
    public static final class EntityPlacerSupplier extends ComponentSupplier<EntitySpawner> {
        @Override
        public EntitySpawner supplyComponent() {
            return new EntitySpawner();
        }
    }

    @ComponentName("EntityDestroyer")
    public static final class EntityDestroyerSupplier extends ComponentSupplier<EntityDestroyer> {
        @Override
        public EntityDestroyer supplyComponent() {
            return new EntityDestroyer();
        }
    }
}
