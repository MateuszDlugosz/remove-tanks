package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabCodeXmlReader {
    public static final String ENTITY_PREFAB_CODE_ELEMENT = "entityPrefabCode";
    public static final String ENTITY_PREFAB_CODES_ELEMENT = "entityPrefabCodes";

    public List<String> readEntityPrefabCodes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ENTITY_PREFAB_CODE_ELEMENT).toArray())
                .map(this::readEntityPrefabCode)
                .collect(Collectors.toList());
    }

    public String readEntityPrefabCode(XmlReader.Element element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            throw new EntityPrefabCodeXmlReadException(element, e);
        }
    }
}
