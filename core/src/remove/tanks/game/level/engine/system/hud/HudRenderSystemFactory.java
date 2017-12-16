package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.system.hud.stages.HudStage;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class HudRenderSystemFactory
        implements RegistrableEntitySystemFactory<HudRenderSystem, HudRenderSystemPrototype>
{
    @Override
    public HudRenderSystem createEntitySystem(HudRenderSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new HudRenderSystem(
                prototype.getPriority(),
                new HudStage(
                        resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class),
                        resourceRegistry.getResource(LevelResource.HudCamera.toString(), Game2DCamera.class),
                        resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class),
                        resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                ),
                resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class),
                resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class)
        );
    }

    @Override
    public Class<HudRenderSystemPrototype> getFactoryType() {
        return HudRenderSystemPrototype.class;
    }
}
