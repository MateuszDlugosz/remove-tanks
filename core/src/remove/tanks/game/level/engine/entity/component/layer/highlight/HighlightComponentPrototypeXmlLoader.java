package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class HighlightComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<HighlightComponentPrototype>
{
    private static final String HIGHLIGHT_TIME_ELEMENT = "highlightTime";

    @Override
    public HighlightComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new HighlightComponentPrototype(
                    loadHighlightTime(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private float loadHighlightTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(HIGHLIGHT_TIME_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.HighlightComponent;
    }
}
