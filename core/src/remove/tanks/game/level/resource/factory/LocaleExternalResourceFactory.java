package remove.tanks.game.level.resource.factory;

import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;

/**
 * @author Mateusz Długosz
 */
public final class LocaleExternalResourceFactory
        extends AbstractExternalResourceFactory<Locale>
{
    @Override
    public String getResourceName() {
        return LevelResource.Locale.toString();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }

    @Override
    public Locale prepareResourceObject(Locale object, ResourceRegistry registry) {
        return object;
    }
}
