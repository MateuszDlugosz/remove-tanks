package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class HighlightOnHitComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<HighlightOnHitComponentPrototype>
{
    @Override
    public HighlightOnHitComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new HighlightOnHitComponentPrototype();
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.HighlightOnHitComponent;
    }
}
