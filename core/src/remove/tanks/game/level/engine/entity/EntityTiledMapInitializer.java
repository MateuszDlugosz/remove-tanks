package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import remove.tanks.game.graphics.map.MapLayerName;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabMapObjectReader;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.position.Position;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefabMapObjectReader;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityTiledMapInitializer {
    private final EntityPrefabCodeMapObjectReader entityPrefabCodeMapObjectReader;
    private final ComponentPrefabMapObjectReader componentPrefabMapObjectReader;
    private final PositionPrefabMapObjectReader positionPrefabMapObjectReader;
    private final PositionFactory positionFactory;

    public EntityTiledMapInitializer(
            EntityPrefabCodeMapObjectReader entityPrefabCodeMapObjectReader,
            ComponentPrefabMapObjectReader componentPrefabMapObjectReader,
            PositionPrefabMapObjectReader positionPrefabMapObjectReader,
            PositionFactory positionFactory
    ) {
        this.entityPrefabCodeMapObjectReader = entityPrefabCodeMapObjectReader;
        this.componentPrefabMapObjectReader = componentPrefabMapObjectReader;
        this.positionPrefabMapObjectReader = positionPrefabMapObjectReader;
        this.positionFactory = positionFactory;
    }

    public void initializeEntities(ResourceRegistry registry) {
        initializeEntitiesFromMapLayer(registry.getResource(ResourceType.TiledMapResource, TiledMap.class)
                .getLayers().get(MapLayerName.ObjectsLayer.getName()), registry);
    }

    private void initializeEntitiesFromMapLayer(MapLayer mapLayer, ResourceRegistry registry) {
        for (MapObject mapObject : mapLayer.getObjects()) {
            initializeEntityFromMapObject(mapObject, registry);
        }
    }

    private void initializeEntityFromMapObject(MapObject mapObject, ResourceRegistry registry) {
        Position position = positionFactory.createPosition(positionPrefabMapObjectReader.readPositionPrefab(mapObject),
                registry.getResource(ResourceType.WorldScaleResource, Scale.class));
        registry.getResource(ResourceType.EntityControllerResource, EntityController.class)
                .createEntity(initializeEntityPrefab(mapObject, registry), position, registry);
    }

    private EntityPrefab initializeEntityPrefab(MapObject mapObject, ResourceRegistry registry) {
        String prefabCode = entityPrefabCodeMapObjectReader.readEntityPrefabCode(mapObject);
        EntityPrefab prefab = registry.getResource(ResourceType.EntityPrefabStorageResource, EntityPrefabStorage.class)
                .getEntityPrefab(prefabCode);
        prefab.getComponentPrefabs().putAll(initializeEntityAdditionalComponents(mapObject));
        return prefab;
    }

    private Map<Class<? extends ComponentPrefab>, ComponentPrefab> initializeEntityAdditionalComponents(MapObject mapObject) {
        return componentPrefabMapObjectReader.readComponentPrefabs(mapObject).stream()
                .collect(Collectors.toMap(ComponentPrefab::getClass, p -> p));
    }
}
