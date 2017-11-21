package remove.tanks.game.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.common.collect.ImmutableMap;
import remove.tanks.game.application.context.Context;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityInitializer;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.scale.Scale;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class LevelLoader {
    private final LevelPrototypeXmlLoader levelPrototypeXmlLoader;
    private final LevelFactory levelFactory;
    private final EntityInitializer entityInitializer;

    public LevelLoader(
            LevelPrototypeXmlLoader levelPrototypeXmlLoader,
            LevelFactory levelFactory,
            EntityInitializer entityInitializer
    ) {
        this.levelPrototypeXmlLoader = levelPrototypeXmlLoader;
        this.levelFactory = levelFactory;
        this.entityInitializer = entityInitializer;
    }

    public final Level loadLevel(String filename, Context context) {
        Level level = levelFactory.createLevel(getResourcesMap(context, filename));
        entityInitializer.initializeLevelEntities(level);
        return level;
    }

    private Map<String, Object> getResourcesMap(Context context, String filename) {
        return new ImmutableMap.Builder<String, Object>()
                .put(LevelResource.UiSkin.toString(), context.getComponent("UiSkin", Skin.class))
                .put(LevelResource.GameCamera.toString(), context.getComponent("GameCamera", Game2DCamera.class))
                .put(LevelResource.HudCamera.toString(), context.getComponent("HudCamera", Game2DCamera.class))
                .put(LevelResource.Configuration.toString(), context.getConfiguration())
                .put(LevelResource.Locale.toString(), context.getComponent("Locale", Locale.class))
                .put(LevelResource.SpriteBatch.toString(), context.getComponent("SpriteBatch", SpriteBatch.class))
                .put(LevelResource.WorldScale.toString(), context.getComponent("WorldScale", Scale.class))
                .put(LevelResource.DisplayScale.toString(), context.getComponent("DisplayScale", Scale.class))
                .put(LevelResource.LevelPrototype.toString(), levelPrototypeXmlLoader.loadLevelPrototype(filename))
                .build();
    }
}
