package remove.tanks.game.level.resource.factory;

import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class GameCameraExternalResourceFactory
        extends AbstractExternalResourceFactory<Game2DCamera>
{
    @Override
    public String getResourceName() {
        return LevelResource.GameCamera.toString();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }

    @Override
    public Game2DCamera prepareResourceObject(Game2DCamera object, ResourceRegistry registry) {
        return object;
    }
}
