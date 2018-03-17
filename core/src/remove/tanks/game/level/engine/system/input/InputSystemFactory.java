package remove.tanks.game.level.engine.system.input;

import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class InputSystemFactory implements SubEntitySystemFactory<InputSystem, InputSystemPrefab> {
    @Override
    public InputSystem createEntitySystem(InputSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new InputSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.InputMapperResource, InputMapper.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<InputSystemPrefab> getFactoryType() {
        return InputSystemPrefab.class;
    }
}
