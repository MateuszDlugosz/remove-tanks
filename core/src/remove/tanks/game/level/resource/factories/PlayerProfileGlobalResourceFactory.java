package remove.tanks.game.level.resource.factories;

import remove.tanks.game.data.profile.Profile;
import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlayerProfileGlobalResourceFactory extends AbstractGlobalResourceFactory<Profile> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.PlayerProfileResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected Profile prepareResourceObject(Profile object) {
        return object;
    }
}
