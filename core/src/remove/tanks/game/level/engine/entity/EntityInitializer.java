package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelMapLayer;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeMapObjectLoader;
import remove.tanks.game.utility.scale.Scale;

import java.util.stream.StreamSupport;

/**
 * @author Mateusz Długosz
 */
public final class EntityInitializer {
    private static final String PROTOTYPE_CODE_PROPERTY = "prototype.code";

    private final PositionPrototypeMapObjectLoader positionPrototypeMapObjectLoader;
    private final EntitySpawner entitySpawner;
    private final EntityFactory entityFactory;
    private final PositionFactory positionFactory;

    public EntityInitializer(
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

    public void initializeLevelEntities(Level level) {
        initializeEntitiesFromMapLayer(
                level,
                level.getResourceRegistry().getResource(LevelResource.TiledMap.toString(), TiledMap.class)
                        .getLayers()
                        .get(LevelMapLayer.ObjectsLayer.getName()),
                level.getResourceRegistry().getResource(LevelResource.WorldScale.toString(), Scale.class)
        );
    }

    private void initializeEntitiesFromMapLayer(Level level, MapLayer layer, Scale scale) {
        StreamSupport.stream(layer.getObjects().spliterator(), false).forEach(mapObject ->
                entitySpawner.spawnEntity(
                initializeEntity(
                        mapObject,
                        level.getResourceRegistry().getResource(LevelResource.EntityPrototypeRepository.toString(), EntityPrototypeRepository.class),
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
        return entityFactory.createEntity(
                entityPrototypeRepository.getPrototype(mapObject
                        .getProperties()
                        .get(PROTOTYPE_CODE_PROPERTY, String.class)
                        .trim()
                ),
                level
        );
    }
}
