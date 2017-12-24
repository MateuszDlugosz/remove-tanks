package remove.tanks.game.level.engine.entity.component.id;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class IdentityComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<IdentityComponentPrototype>
{
    private static final String ID_ELEMENT = "id";

    @Override
    public IdentityComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new IdentityComponentPrototype(
                    loadId(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.IdentityComponent;
    }
}
