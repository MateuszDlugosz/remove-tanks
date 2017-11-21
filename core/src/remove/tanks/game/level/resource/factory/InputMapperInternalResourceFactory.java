package remove.tanks.game.level.resource.factory;

import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.input.InputMapper;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class InputMapperInternalResourceFactory
        extends AbstractInternalResourceFactory<InputMapper>
{
    @Override
    protected String getResourceName() {
        return LevelResource.InputMapper.toString();
    }

    @Override
    protected InputMapper getResourceObject(ResourceRegistry registry) {
        return new InputMapper();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }
}
