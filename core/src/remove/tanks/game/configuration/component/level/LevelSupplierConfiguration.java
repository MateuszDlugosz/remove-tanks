package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.utils.XmlReader;
import com.google.common.collect.Lists;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.*;
import remove.tanks.game.level.engine.EnginePrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.EntityDestroyer;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntitySpawner;
import remove.tanks.game.level.presentation.LevelPresenter;
import remove.tanks.game.level.resource.ResourceRegistryFactory;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeMapObjectLoader;
import remove.tanks.game.utility.properties.PropertiesXmlLoader;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class LevelSupplierConfiguration {
    @ComponentName("LevelFactory")
    public static final class LevelFactorySupplier extends ComponentSupplier<LevelFactory> {
        @Override
        public LevelFactory supplyComponent() {
            return new LevelFactory(getContext().getComponent("ResourceRegistryFactory", ResourceRegistryFactory.class));
        }
    }

    @ComponentName("LevelPrototypeXmlLoader")
    public static final class LevelPrototypeXmlLoaderSupplier extends ComponentSupplier<LevelPrototypeXmlLoader> {
        @Override
        public LevelPrototypeXmlLoader supplyComponent() {
            return new LevelPrototypeXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("EnginePrototypeXmlLoader", EnginePrototypeXmlLoader.class),
                    getContext().getComponent("PropertiesXmlLoader", PropertiesXmlLoader.class)
            );
        }
    }

    @ComponentName("LevelLoader")
    public static final class LevelLoaderSupplier extends ComponentSupplier<LevelLoader> {
        @Override
        public LevelLoader supplyComponent() {
            return new LevelLoader(
                    getContext().getComponent("LevelPrototypeXmlLoader", LevelPrototypeXmlLoader.class),
                    getContext().getComponent("LevelFactory", LevelFactory.class),
                    getContext().getComponent("LevelEntityInitializer", LevelEntityInitializer.class)
            );
        }
    }

    @ComponentName("LevelEntityInitializer")
    public static final class LevelEntityInitializerSupplier extends ComponentSupplier<LevelEntityInitializer> {
        @Override
        public LevelEntityInitializer supplyComponent() {
            return new LevelEntityInitializer(
                    getContext().getComponent("PositionPrototypeMapObjectLoader", PositionPrototypeMapObjectLoader.class),
                    getContext().getComponent("EntitySpawner", EntitySpawner.class),
                    getContext().getComponent("EntityFactory", EntityFactory.class),
                    getContext().getComponent("PositionFactory", PositionFactory.class)
            );
        }
    }

    @ComponentName("LevelPropertiesInitializer")
    public static final class LevelPropertiesInitializerSupplier extends ComponentSupplier<LevelPropertiesInitializer> {
        @Override
        public LevelPropertiesInitializer supplyComponent() {
            return new LevelPropertiesInitializer();
        }
    }

    @ComponentName("LevelDisposer")
    public static final class LevelDisposerSupplier extends ComponentSupplier<LevelDisposer> {
        @Override
        public LevelDisposer supplyComponent() {
            return new LevelDisposer();
        }
    }

    @ComponentName("LevelControllerFactory")
    public static final class LevelControllerFactorySupplier extends ComponentSupplier<LevelControllerFactory> {
        @Override
        public LevelControllerFactory supplyComponent() {
            return new LevelControllerFactory(
                    getContext().getComponent("EntitySpawner", EntitySpawner.class),
                    getContext().getComponent("EntityDestroyer", EntityDestroyer.class),
                    getContext().getComponent("EntityFactory", EntityFactory.class)
            );
        }
    }

    @ComponentName("MenuLevelPresenter")
    public static final class MenuLevelPresenterSupplier extends ComponentSupplier<LevelPresenter> {
        @Override
        public LevelPresenter supplyComponent() {
            LevelLoader levelLoader = getContext().getComponent("LevelLoader", LevelLoader.class);
            LevelControllerFactory levelControllerFactory = getContext()
                    .getComponent("LevelControllerFactory", LevelControllerFactory.class);

            return new LevelPresenter(
                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class),
                    Lists.newArrayList(
                            levelControllerFactory.createLevelController(levelLoader.loadLevel(
                                    "prototypes/levels/menu/level-presentation-0.xml",
                                    getContext())
                            )
                    ),
                    10
            );
        }
    }
}
