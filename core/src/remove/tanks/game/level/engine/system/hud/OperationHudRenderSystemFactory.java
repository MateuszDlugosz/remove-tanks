package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.system.hud.stages.OperationHudStage;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class OperationHudRenderSystemFactory
        implements RegistrableEntitySystemFactory<OperationHudRenderSystem, OperationHudRenderSystemPrototype>
{
    @Override
    public OperationHudRenderSystem createEntitySystem(OperationHudRenderSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new OperationHudRenderSystem(
                new OperationHudStage(
                        resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class),
                        resourceRegistry.getResource(LevelResource.HudCamera.toString(), Game2DCamera.class),
                        resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class),
                        resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                ),
                resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class),
                resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                prototype.getPriority()
        );
    }

    @Override
    public Class<OperationHudRenderSystemPrototype> getFactoryType() {
        return OperationHudRenderSystemPrototype.class;
    }
}
