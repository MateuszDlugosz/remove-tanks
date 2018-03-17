package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.level.resource.AbstractGlobalResourceFactory;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class UISkinGlobalResourceFactory extends AbstractGlobalResourceFactory<Skin> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.UISkinResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected Skin prepareResourceObject(Skin object) {
        return object;
    }
}
