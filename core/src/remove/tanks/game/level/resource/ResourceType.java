package remove.tanks.game.level.resource;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.data.profile.Profile;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.engine.entity.EntityController;
import remove.tanks.game.level.engine.entity.EntityPrefabStorage;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.scale.MutableScale;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public enum ResourceType {
    LevelPrefabResource(LevelPrefab.class),

    GameCameraResource(Game2DCamera.class),
    SpriteBatchResource(SpriteBatch.class),
    UICameraResource(Game2DCamera.class),
    UIScaleResource(Scale.class),
    UISkinResource(Skin.class),
    LocaleResource(Locale.class),
    WorldScaleResource(Scale.class),
    InputMapperResource(InputMapper.class),
    PlayerProfileResource(Profile.class),
    ExternalEventBusResource(EventBus.class),

    TimeScaleResource(MutableScale.class),
    LevelPropertiesResource(Properties.class),
    EntityPrefabStorageResource(EntityPrefabStorage.class),
    AssetStorageResource(AssetStorage.class),
    WorldResource(World.class),
    WorldLightResource(WorldLight.class),
    EventBusResource(EventBus.class),
    TiledMapResource(TiledMap.class),
    TiledMapRendererResource(TiledMapRenderer.class),
    TiledMapBoundaryResource(Boundary.class),
    EntityControllerResource(EntityController.class),
    EngineResource(Engine.class);

    private final Class<?> resourceClass;

    ResourceType(Class<?> resourceClass) {
        this.resourceClass = resourceClass;
    }

    public Class<?> getResourceClass() {
        return resourceClass;
    }
}
