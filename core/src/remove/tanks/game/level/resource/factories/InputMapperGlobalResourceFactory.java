package remove.tanks.game.level.resource.factories;

import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class InputMapperGlobalResourceFactory extends AbstractGlobalResourceFactory<InputMapper> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.InputMapperResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected InputMapper prepareResourceObject(InputMapper object) {
        object.keyUpAll();
        return object;
    }
}
