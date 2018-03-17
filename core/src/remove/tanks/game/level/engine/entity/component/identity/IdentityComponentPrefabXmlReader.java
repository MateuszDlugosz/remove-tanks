package remove.tanks.game.level.engine.entity.component.identity;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class IdentityComponentPrefabXmlReader implements SubComponentPrefabXmlReader<IdentityComponentPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public IdentityComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new IdentityComponentPrefab(readId(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.IdentityComponent;
    }
}
