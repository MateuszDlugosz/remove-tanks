package remove.tanks.game.level.engine.entity.component.id;

import com.badlogic.gdx.utils.XmlReader;
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
        return new IdentityComponentPrototype(element.getChildByName(ID_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.IdentityComponent;
    }
}
