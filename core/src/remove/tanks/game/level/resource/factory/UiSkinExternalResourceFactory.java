package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class UiSkinExternalResourceFactory extends AbstractExternalResourceFactory<Skin> {
    @Override
    public String getResourceName() {
        return LevelResource.UiSkin.toString();
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[0];
    }

    @Override
    public Skin prepareResourceObject(Skin object, ResourceRegistry registry) {
        return object;
    }
}
