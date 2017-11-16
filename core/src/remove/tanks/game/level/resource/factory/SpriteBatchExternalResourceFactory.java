package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class SpriteBatchExternalResourceFactory
        extends AbstractExternalResourceFactory<SpriteBatch>
{
    @Override
    public String getResourceName() {
        return LevelResource.SpriteBatch.toString();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }

    @Override
    public SpriteBatch prepareResourceObject(SpriteBatch object, ResourceRegistry registry) {
        return object;
    }
}
