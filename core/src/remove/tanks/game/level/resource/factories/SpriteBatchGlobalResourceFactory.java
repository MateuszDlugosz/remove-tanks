package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class SpriteBatchGlobalResourceFactory extends AbstractGlobalResourceFactory<SpriteBatch> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.SpriteBatchResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected SpriteBatch prepareResourceObject(SpriteBatch object) {
        return object;
    }
}
