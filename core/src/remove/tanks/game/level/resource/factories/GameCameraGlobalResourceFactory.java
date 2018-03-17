package remove.tanks.game.level.resource.factories;

import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class GameCameraGlobalResourceFactory extends AbstractGlobalResourceFactory<Game2DCamera> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.GameCameraResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected Game2DCamera prepareResourceObject(Game2DCamera object) {
        return object;
    }
}
