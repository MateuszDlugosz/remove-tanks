package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeMapObjectLoader;
import remove.tanks.game.utility.scale.Scale;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Mateusz Długosz
 */
public final class EntityInitializer {
    private static final String PROTOTYPE_CODE_PROPERTY = "prototype.code";
    private static final String PROTOTYPE_COMPONENTS_PROPERTY = "prototype.components";
    private static final String OBJECTS_MAP_LAYER_NAME = "objects_layer";

    private final PositionPrototypeMapObjectLoader positionPrototypeMapObjectLoader;
    private final EntitySpawner entitySpawner;
    private final EntityFactory entityFactory;
    private final PositionFactory positionFactory;
    private final ComponentPrototypeXmlLoader componentPrototypeXmlLoader;
    private final XmlReader xmlReader;

    public EntityInitializer(
            PositionPrototypeMapObjectLoader positionPrototypeMapObjectLoader,
            EntitySpawner entitySpawner,
            EntityFactory entityFactory,
            PositionFactory positionFactory,
            ComponentPrototypeXmlLoader componentPrototypeXmlLoader,
            XmlReader xmlReader
    ) {
        this.positionPrototypeMapObjectLoader = positionPrototypeMapObjectLoader;
        this.entitySpawner = entitySpawner;
        this.entityFactory = entityFactory;
        this.positionFactory = positionFactory;
        this.componentPrototypeXmlLoader = componentPrototypeXmlLoader;
        this.xmlReader = xmlReader;
    }

    public void initializeLevelEntities(Level level) {
        initializeEntitiesFromMapLayer(
                level,
                level.getResourceRegistry().getResource(LevelResource.TiledMap.toString(), TiledMap.class)
                        .getLayers()
                        .get(OBJECTS_MAP_LAYER_NAME),
                level.getResourceRegistry().getResource(LevelResource.WorldScale.toString(), Scale.class)
        );
    }

    private void initializeEntitiesFromMapLayer(Level level, MapLayer layer, Scale scale) {
        StreamSupport.stream(layer.getObjects().spliterator(), false).forEach(mapObject ->
                entitySpawner.spawnEntity(
                        initializeEntity(
                                mapObject,
                                level.getResourceRegistry().getResource(LevelResource.EntityPrototypeRepository.toString(),
                                        EntityPrototypeRepository.class),
                                level
                        ),
                        positionFactory.createPosition(positionPrototypeMapObjectLoader.loadPositionPrototype(mapObject), scale),
                        level
        ));
    }

    private Entity initializeEntity(
            MapObject mapObject,
            EntityPrototypeRepository entityPrototypeRepository,
            Level level
    ) {
        EntityPrototype prototype = entityPrototypeRepository.getPrototype(mapObject
                .getProperties()
                .get(PROTOTYPE_CODE_PROPERTY, String.class)
                .trim()
        );
        if (mapObject.getProperties().containsKey(PROTOTYPE_COMPONENTS_PROPERTY)) {
            prototype.getComponentPrototypes().putAll(loadAdditionalComponents(
                    mapObject.getProperties().get(PROTOTYPE_COMPONENTS_PROPERTY, String.class)
            ));
        }
        return entityFactory.createEntity(prototype, level);
    }

    private Map<Class<? extends ComponentPrototype>, ComponentPrototype> loadAdditionalComponents(String xml) {
        return componentPrototypeXmlLoader.loadComponentsPrototypes(
                xmlReader.parse(xml
                        .replaceAll("&lt", "<")
                        .replaceAll("&gt", ">")
                )).stream()
                        .collect(Collectors.toMap(
                                ComponentPrototype::getClass,
                                v -> v
                        ));
    }
}
