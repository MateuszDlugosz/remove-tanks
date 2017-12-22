package remove.tanks.game.level.engine.system.hud.stages.widget.property;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.hud.stages.widget.RegistrableWidgetFactory;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetCreateException;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;

/**
 * @author Mateusz Długosz
 */
public final class PropertyPresenterWidgetFactory
        implements RegistrableWidgetFactory<PropertyPresenterWidget, PropertyPresenterWidgetPrototype>
{
    @Override
    public PropertyPresenterWidget createWidget(PropertyPresenterWidgetPrototype prototype, Table table, ResourceRegistry resourceRegistry) {
        try {
            return new PropertyPresenterWidget(
                    prototype.getTitleEntry(),
                    prototype.getProperty(),
                    createLabel(
                            resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class)
                                    .getTranslation().getEntry(prototype.getTitleEntry().getName()),
                            resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                    ),
                    createLabel(
                            resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class)
                                    .getTranslation().getEntry(prototype.getTitleEntry().getName()),
                            resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                    )
            );
        } catch (Exception e) {
            throw new WidgetCreateException(prototype, e);
        }
    }

    private Label createLabel(String title, Skin skin) {
        return new Label(title, skin);
    }

    @Override
    public Class<PropertyPresenterWidgetPrototype> getFactoryType() {
        return PropertyPresenterWidgetPrototype.class;
    }
}
