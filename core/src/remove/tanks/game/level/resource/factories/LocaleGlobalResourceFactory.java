package remove.tanks.game.level.resource.factories;

import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.locale.Locale;

/**
 * @author Mateusz Długosz
 */
public final class LocaleGlobalResourceFactory extends AbstractGlobalResourceFactory<Locale> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.LocaleResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected Locale prepareResourceObject(Locale object) {
        return object;
    }
}
