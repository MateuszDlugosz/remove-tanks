package remove.tanks.game.level.utility.stage.widget.property;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.stage.widget.SubWidgetFactory;
import remove.tanks.game.level.utility.stage.widget.WidgetCreateException;
import remove.tanks.game.locale.Locale;

/**
 * @author Mateusz Długosz
 */
public final class PropertyPresenterWidgetFactory implements SubWidgetFactory<PropertyPresenterWidget, PropertyPresenterWidgetPrefab> {
    @Override
    public PropertyPresenterWidget createWidget(PropertyPresenterWidgetPrefab prefab, Table table, ResourceRegistry registry) {
        try {
            return new PropertyPresenterWidget(
                    prefab.getTitleEntry(),
                    prefab.getProperty(),
                    createLabel(
                            registry.getResource(ResourceType.LocaleResource, Locale.class)
                                    .getSelectedTranslation().getEntry(prefab.getTitleEntry().getName()),
                            registry.getResource(ResourceType.UISkinResource, Skin.class)
                    ),
                    createLabel(
                            registry.getResource(ResourceType.LocaleResource, Locale.class)
                                    .getSelectedTranslation().getEntry(prefab.getTitleEntry().getName()),
                            registry.getResource(ResourceType.UISkinResource, Skin.class)
                    )
            );
        } catch (Exception e) {
            throw new WidgetCreateException(prefab, e);
        }
    }

    private Label createLabel(String title, Skin skin) {
        return new Label(title, skin);
    }

    @Override
    public Class<PropertyPresenterWidgetPrefab> getFactoryType() {
        return PropertyPresenterWidgetPrefab.class;
    }
}
