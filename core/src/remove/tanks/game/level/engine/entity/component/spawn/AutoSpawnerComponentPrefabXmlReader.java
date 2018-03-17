package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerComponentPrefabXmlReader implements SubComponentPrefabXmlReader<AutoSpawnerComponentPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public AutoSpawnerComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new AutoSpawnerComponentPrefab(readId(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.AutoSpawnerComponent;
    }
}
