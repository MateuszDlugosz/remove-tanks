package remove.tanks.game.level;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import remove.tanks.game.constant.LevelMapLayer;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.entity.EntitySpawner;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeMapObjectLoader;
import remove.tanks.game.utility.scale.Scale;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelEntityInitializer {
    public static final String PROTOTYPE_CODE_PROPERTY = "prototype.code";

    private final PositionPrototypeMapObjectLoader positionPrototypeMapObjectLoader;
    private final EntitySpawner entitySpawner;
    private final EntityFactory entityFactory;
    private final PositionFactory positionFactory;

    public LevelEntityInitializer(
            PositionPrototypeMapObjectLoader positionPrototypeMapObjectLoader,
            EntitySpawner entitySpawner,
            EntityFactory entityFactory,
            PositionFactory positionFactory
    ) {
        this.positionPrototypeMapObjectLoader = positionPrototypeMapObjectLoader;
        this.entitySpawner = entitySpawner;
        this.entityFactory = entityFactory;
        this.positionFactory = positionFactory;
    }

    public List<Entity> initializeLevelEntities(Level level) {
        return initializeEntitiesFromMapLayer(
                level,
                level.getResourceRegistry().getResource(LevelResource.TiledMap.toString(), TiledMap.class)
                        .getLayers()
                        .get(LevelMapLayer.ObjectsLayer.getName()),
                level.getResourceRegistry().getResource(LevelResource.WorldScale.toString(), Scale.class)
        );
    }

    private List<Entity> initializeEntitiesFromMapLayer(Level level, MapLayer layer, Scale scale) {
        List<Entity> entities = new ArrayList<>();
        MapObjects mapObjects = layer.getObjects();
        for (MapObject mapObject : mapObjects) {
            Entity entity = initializeEntity(
                    mapObject,
                    entityFactory,
                    level.getResourceRegistry().getResource(LevelResource.EntityPrototypeRepository.toString(),
                            EntityPrototypeRepository.class),
                    level
            );
            entitySpawner.placeEntity(
                    entity,
                    positionFactory.createPosition(
                            positionPrototypeMapObjectLoader.loadPositionPrototype(mapObject),
                            scale
                    )
            );
            entities.add(entity);
        }
        return entities;
    }

    private Entity initializeEntity(
            MapObject mapObject,
            EntityFactory entityFactory,
            EntityPrototypeRepository repository,
            Level level
    ) {
        return entityFactory.createEntity(
                repository.getPrototype(mapObject
                        .getProperties()
                        .get(PROTOTYPE_CODE_PROPERTY, String.class)
                        .trim()
                ),
                level
        );
    }
}
